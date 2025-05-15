"use client";
import React, { useState, useEffect } from "react";

import {
  useParams,
} from "next/navigation";
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Input,
} from "@nextui-org/react";
import { Button } from "@nextui-org/react";
import { BoardComponent } from "../../../../components/BoardComponent";
import { CountdownTimer } from "../../../../components/CountdownTimer";
import { useGameDataContext } from "@/app/contexts/GameDataContext";
import {
  JoinLobbyRequest,
  MoveRequest,
  PollRequest,
  StartRequest,
  TwitterRequest,
} from "@/app/grpc/Game_pb";

const BASE_URL = process.env.NEXT_PUBLIC_BASE_URL || "http://localhost:3000";

const Game: React.FC = () => {
  const {
    enemySelectValue,
    setNameInputValue,
    nameInputValue,
    timeInputValue,
    setTimeInputValue,
    heightInputValue,
    setHeightInputValue,
    hasPlayerInfo,
    setHasPlayerInfo,
    widthInputValue,
    setWidthInputValue,
    playerId,
    setPlayerId,
    gameClient,
  } = useGameDataContext();

  const [currentPlayer, setCurrentPlayer] = useState(0);
  const [enemyName, setEnemyName] = useState(enemySelectValue === "ai" ? "AI" : "UnknownName");
  const [isNameModalOpen, setIsNameModalOpen] = useState(!hasPlayerInfo);
  const [isLobbyOwner, setIsLobbyOwner] = useState(hasPlayerInfo);
  const [isGameFinished, setIsGameFinished] = useState<boolean>(false);
  const [isGameRunning, setIsGameRunning] = useState<boolean>(false);
  const [stones, setStones] = useState(
    Array(heightInputValue * widthInputValue)
      .fill(null)
      .map(() => ({ color: null, disabled: false }))
  );
  const [timeValue, setTimeValue] = useState(timeInputValue);

  const params = useParams();
  const [lobbyId, setLobbyId] = useState(params.slug);
  const [isWinner, setIsWinner] = useState(false);
  const [hasTweeted, setHasTweeted] = useState(false);

  const handleCopyInviteLink = () => {
    navigator.clipboard.writeText(`${BASE_URL}/game/${lobbyId}`).then(() => {
      alert("Der Link wurde in die Zwischenablage kopiert!");
    });
  };

  useEffect(() => {
    handleGame();
  }, []);

  function startTimer() {
    const interval = setInterval(() => {
      setTimeValue((v) => (v <= 0 ? 0 : v - 1));
    }, 1000);
  }

  const handleGame = () => {
    if (isLobbyOwner) {
      pollGameRequest(playerId);
    } 
  };

  function pollGameRequest(clientId: number) {
    const pollReq = new PollRequest();

    console.log("--------- PollGameData ---------");
    console.log("Set PlayerId for pollRequest to: ", clientId);
    pollReq.setClientid(clientId);

    var pollResponseStream = gameClient.pollGameData(pollReq, {});
    pollResponseStream.on("data", (resp) => {
      console.log("--------- OnData ---------");
      const pollResponseObj = resp.toObject();
      console.log(pollResponseObj);

      if (pollResponseObj.begin) {
        console.log("got begin!, is: ", pollResponseObj.begin.begin);
        setIsGameRunning(true);
        startTimer();
        setCurrentPlayer(pollResponseObj.begin.begin === true ? 1 : 2);
      }

      // Stone from Enemy
      if (pollResponseObj.setstone) {
        console.log("got setstone!, is: ", pollResponseObj.setstone.col);
        setStone(pollResponseObj.setstone.col);
        setTimeValue(timeInputValue);
      }

      if (pollResponseObj.setwinner) {
        console.log("got setwinner!, is: ", pollResponseObj.setwinner.winner);
        setIsGameRunning(false);
        setIsGameFinished(true);
        setIsWinner(pollResponseObj.setwinner.winner);
      }

      if (pollResponseObj.updatetimer) {
        console.log(
          "got updatetimer! is: ",
          pollResponseObj.updatetimer.timeleft
        );
        setTimeValue(pollResponseObj.updatetimer.timeleft);
      }

      if (pollResponseObj.setenemy) {
        console.log(
          "got setenemy! is enemyName: ",
          pollResponseObj.setenemy.enemyname
        );
        setEnemyName(pollResponseObj.setenemy.enemyname);
      }
    });

    pollResponseStream.on("error", (err) => {
      alert("Error: " + err);
    });

    pollResponseStream.on("end", () => {
      console.log("End of pollStream");
      //setIsGameRunning(false);
      //setIsGameFinished(true);
    });
  }

  function makeMove(col: number) {
    const moveReq = new MoveRequest();
    moveReq.setClientid(playerId);
    moveReq.setCol(col);

    gameClient.makeMove(moveReq, {}, (err, resp) => {
      if (err) {
        alert("Es gab ein Problem bei makeMove()!");
      }
    });
    setStone(col);
    setTimeValue(timeInputValue);
  }

  function setStone(col: number) {
    let index = heightInputValue * widthInputValue - (widthInputValue - col);
    setStones((prevStones) => {
      let updatedStones = [...prevStones];

      while (index >= 0) {
        if (!updatedStones[index].disabled) {
          updatedStones[index] = {
            color: currentPlayer === 1 ? "blue" : "red",
            disabled: true,
          };
          break;
        }

        index = index - widthInputValue;
      }
      console.log(updatedStones);
      return updatedStones;
    });

    setCurrentPlayer((prevPlayer) => {
      return prevPlayer === 1 ? 2 : 1;
    });
  }

  const handleJoinGameInvited = () => {
    if (nameInputValue !== "") {
      setHasPlayerInfo(true);
      setIsLobbyOwner(false);

      console.log("nameInputValue is: ", nameInputValue);
      const joinLobbyReq = new JoinLobbyRequest()
        .setLobbyid(lobbyId)
        .setOwnname(nameInputValue);

      gameClient.joinLobby(joinLobbyReq, {}, (err, resp) => {
        if (err) {
          alert(
            "Oooopps, da gab es ein Problem bei der Kommunikation! Bitte versuche es erneut.\n\n" +
              err
          );
        } else {
          if(resp.getSuccess()) {
            setEnemyName(resp.getEnemyname());
            setTimeInputValue(resp.getGametime());
            setHeightInputValue(resp.getBoardrowcount());
            setWidthInputValue(resp.getBoardcolcount());
            setPlayerId(resp.getClientid());
            pollGameRequest(resp.getClientid());
          } else {
            alert("Die Lobby ist entweder voll oder existiert nicht!")
          }
        }
      });

      setIsNameModalOpen(false);
    }
  };

  function handleStartGame() {
    console.log("trigger");
    const startGameReq = new StartRequest();
    startGameReq.setClientid(playerId);

    gameClient.startGame(startGameReq, {}, (err, res) => {
      if (err) {
        alert("Error in startGame()");
      }
    });

  }

  function handlePublishTweet() {
    const twitterReq = new TwitterRequest();
    twitterReq.setClientid(playerId);

    gameClient.postTwitter(twitterReq, {}, (err, resp) => {
      if (err) {
        alert("Error in postTwitter()");
      } else if (resp.getSuccess()) {
        setHasTweeted(true);
        alert("Die Nachricht wurde erfolgreich an Twitter übermittelt");
        window.open("https://twitter.com/viergewinntgame", "_blank");
      }
    });
  }

  return (
    <>
      <div>
        <Modal
          size="xl"
          backdrop="opaque"
          isOpen={isNameModalOpen}
          classNames={{
            backdrop:
              "bg-gradient-to-t from-zinc-900 to-zinc-900/10 backdrop-opacity-20",
          }}
        >
          <ModalContent>
            {(onClose) => (
              <>
                <ModalHeader className="flex flex-col gap-1">
                  Der Lobby {lobbyId} beitreten
                </ModalHeader>
                    <ModalBody>
                      <form>
                        <div>
                          <Input
                            value={nameInputValue}
                            onValueChange={setNameInputValue}
                            type="string"
                            label="Name:"
                            placeholder="Dein Name"
                            labelPlacement="outside"
                            className={`w-full mb-6`}
                          />
                        </div>
                      </form>
                    </ModalBody>
                    <ModalFooter>
                      <Button color="primary" onPress={handleJoinGameInvited}>
                        Spiel beitreten
                      </Button>
                    </ModalFooter>
                  {/*
                  <form>
                    <div>
                      <p className="m-2 mb-6 ml-6">Du kannst der Lobby nicht beitreten, da diese gegen eine AI
                      spielt!</p>
                    </div>
                  </form>
                  */}
              </>
            )}
          </ModalContent>
        </Modal>
        {isNameModalOpen || (
          <>
            <div className="bg-gray-400/5 p-8 focus:ring-4 focus:outline-none focus:ring-purple-300 font-medium">
              <div className="flex flex-row bg-gray-400/5 p-8 ">
                {isGameRunning && (
                  <div className="flex-grow flex items-center">
                    {currentPlayer === 1 ? (
                      <div className="text-3xl font-semibold tracking-tight text-blue-900">
                        {nameInputValue}, du bist an der Reihe!
                      </div>
                    ) : (
                      <div className="text-3xl font-semibold tracking-tight text-red-900">
                        {enemyName} ist an der Reihe!
                      </div>
                    )}
                  </div>
                )}
                {isGameFinished && (
                  <div className="flex-grow flex items-center">
                    {isGameFinished && isWinner ? (
                      <div className="text-3xl font-semibold tracking-tight text-blue-900">
                        {nameInputValue}, du hast gewonnen!
                      </div>
                    ) : (
                      <div className="text-3xl font-semibold tracking-tight text-red-900">
                        Du hast verloren! {enemyName} hat gewonnen!
                      </div>
                    )}
                  </div>
                )}

                <div className="ml-4">
                  {isGameRunning && (
                    <CountdownTimer
                      isDisabled={!isGameRunning}
                      maxTimerSeconds={timeInputValue}
                      timeValue={timeValue}
                    />
                  )}
                </div>
              </div>
            </div>

            <BoardComponent
              stones={stones}
              makeMove={makeMove}
              boardWidth={widthInputValue}
              boardHeight={heightInputValue}
              disabled={!isGameRunning || currentPlayer !== 1}
            />

            <div className="  mx-auto p-9  flex items-center justify-center max-w-700 mx-auto bg-gray-400/5 ">
              {!isLobbyOwner || isGameRunning || isGameFinished || (
                <>
                  <Button
                    onClick={handleStartGame}
                    className="mt-4 p-4 m-2 p-3 text-white rounded"
                    color="primary"
                    variant="bordered"
                    disabled={
                      enemyName === "UnknownName" && enemySelectValue != "ai"
                    }
                  >
                    Spiel starten
                  </Button>

                  {enemySelectValue !== "ai" && (
                    <Button
                      onClick={handleCopyInviteLink}
                      className="mt-4 p-4 m-2 p-3 text-white rounded"
                      color="primary"
                      variant="bordered"
                    >
                      Spieler einladen
                    </Button>
                  )}
                </>
              )}
              {isGameFinished && (
                <Button
                  onClick={handlePublishTweet}
                  className="mt-4 p-4 m-2 p-3 text-white rounded"
                  color="primary"
                  variant="bordered"
                  disabled={hasTweeted}
                >
                  Spielergebnis auf Twitter veröffentlichen
                </Button>
              )}
            </div>
          </>
        )}
      </div>
    </>
  );
};

export default Game;
