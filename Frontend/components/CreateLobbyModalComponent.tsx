"use client";
import React, { ChangeEvent, useState } from "react";
import { useRouter } from "next/navigation";
import { useGameDataContext } from "@/app/contexts/GameDataContext";

import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
  Select,
  SelectItem,
  Input,
} from "@nextui-org/react";
import { CreateLobbyRequest, Enemy } from "@/app/grpc/Game_pb";


interface CreateLobbyModalComponentProps {
  isOpen: boolean;
  onClose: () => void;
  onFormSubmit: (formValues: {
    nameInputValue: number;
    enemySelectValue: number;
    lobbySelectValue: number;
    timeInputValue: number;
    heightInputValue: number;
    widthInputValue: number;
  }) => void;
}

const CreateLobbyModalComponent: React.FC<CreateLobbyModalComponentProps> = ({
  isOpen, onClose, onFormSubmit
}) => {
  const { enemySelectValue, setEnemySelectValue,
    nameInputValue, setNameInputValue,
    timeInputValue, setTimeInputValue,
    heightInputValue, setHeightInputValue,
    widthInputValue, setWidthInputValue,
    setPlayerId, gameClient, setHasPlayerInfo} = useGameDataContext();
  const [isSecondSelectDisabled, setIsSecondSelectDisabled] = useState(true);
  const router = useRouter();


  const enemys = [
    {
      label: "AI",
      value: "ai",
      description: "Gegen KI spielen",
    },
    {
      label: "Person",
      value: "person",
      description: "Gegen einen Spieler spielen",
    },
  ];

  const heightInputInvalid = React.useMemo(() => {
    if (isNaN(heightInputValue) || heightInputValue < 4 || heightInputValue > 20) {
      return true;
    }
  }, [heightInputValue]);

  const widthInputInvalid = React.useMemo(() => {
    if (isNaN(widthInputValue) || widthInputValue < 4 || widthInputValue > 20) {
      return true;
    }
  }, [widthInputValue]);

  const timeInputInvalid = React.useMemo(() => {
    if (isNaN(timeInputValue) || timeInputValue < 10 || timeInputValue > 600) {
      return true;
    }
  }, [timeInputValue]);

  const handleFirstSelectChange = (e: ChangeEvent<HTMLSelectElement>) => {
    setEnemySelectValue(e.target.value);
    if (e.target.value === "person") {
      setIsSecondSelectDisabled(false);
    }

    if (e.target.value === "ai") {
      setIsSecondSelectDisabled(true);
      setHeightInputValue(6);
      setWidthInputValue(7);
    }
  };

  const handleCreateGameSubmit = (e: ChangeEvent<HTMLInputElement>) => {
    onClose();
    e.preventDefault;

    const createLobbyReq = new CreateLobbyRequest();
    createLobbyReq.setBoardcolcount(widthInputValue)
        .setBoardrowcount(heightInputValue)
        .setEnemy(enemySelectValue === "ai" ? Enemy.AI : Enemy.PVP)
        .setGametime(timeInputValue)
        .setOwnname(nameInputValue);

    console.log(createLobbyReq);

    gameClient.createLobby(createLobbyReq, {}, (err, resp) => {
      if (err) {
          alert("Oooopps, da gab es ein Problem bei der Kommunikation! Bitte versuche es erneut.\n\n" + err);
      } else {
          if(resp.getSuccess()) {
            const lobbyId = resp.getLobbyid();
            setPlayerId(resp.getClientid());
            setHasPlayerInfo(true);

            console.log("lobbyId: ", resp.getLobbyid())
            console.log("playerId: ", resp.getClientid())
            router.push(
              `/game/${lobbyId}`
            );
          } else {
              alert("Da gab es ein Problem!");
          }
      }
    });
  };

  return (
    <>
      <Modal
        size="5xl"
        backdrop="opaque"
        isOpen={isOpen}
        classNames={{
          backdrop:
            "bg-gradient-to-t from-zinc-900 to-zinc-900/10 backdrop-opacity-20",
        }}
        onClose={onClose}
      >
        <ModalContent>
          {(onClose) => (
            <>
              <ModalHeader className="flex flex-col gap-1">
                Ein neues Spiel erstellen
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
                      className={`w-full mb-4`}
                    />
                  </div>
                  <div>
                    <label htmlFor="enemySelect" className={` mb-12`}>Spielgegner auswählen:</label>
                    <Select
                      label="Enemies"
                      items={enemys}
                      placeholder="Bitte Spielgegner auswählen"
                      value={enemySelectValue}
                      onChange={handleFirstSelectChange}
                      className="w-full mb-4"
                    >
                      {(enemys) => (
                        <SelectItem key={enemys.value}>
                          {enemys.label}
                        </SelectItem>
                      )}
                    </Select>
                  </div>
                  <div>
                    <Input
                      value={timeInputValue}
                      onValueChange={setTimeInputValue}
                      type="number"
                      label="Zeit in Sekunden auswählen"
                      placeholder="10"
                      labelPlacement="outside"
                      className={`w-full mb-4`}
                      color={timeInputInvalid ? "danger" : ""}
                      errorMessage={
                        timeInputInvalid && "Bitte zwischen einschließlich 10 und 600 auswählen"
                      }
                      endContent={
                        <div className="pointer-events-none flex items-center">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            strokeWidth="1.5"
                            stroke="currentColor"
                            data-slot="icon"
                            className="w-6 h-6"
                          >
                            <path
                              strokeLinecap="round"
                              strokeLinejoin="round"
                              d="M12 6v6h4.5m4.5 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"
                            />
                          </svg>
                        </div>
                      }
                    />
                    <label htmlFor="enemySelect"></label>
                  </div>
                  <div className="flex">
                    <Input
                      value={heightInputValue}
                      type="number"
                      label="Spielfeldhöhe auswählen"
                      placeholder="10"
                      labelPlacement="outside"
                      onChange={(e) => setHeightInputValue(e.target.valueAsNumber)}
                      color={heightInputInvalid ? "danger" : ""}
                      errorMessage={
                        heightInputInvalid && "Bitte zweischen 4 und 20 auswählen  "
                      }
                      //isDisabled={isSecondSelectDisabled}
                      isDisabled={true}
                      className={`${
                        isSecondSelectDisabled
                          ? "opacity-50 cursor-not-allowed"
                          : ""
                      }`}
                      endContent={
                        <div className="pointer-events-none flex items-center max-w-xs">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            strokeWidth="1.5"
                            stroke="currentColor"
                            data-slot="icon"
                            className="w-6 h-6"
                          >
                            <path
                              strokeLinecap="round"
                              strokeLinejoin="round"
                              d="M8.25 6.75 12 3m0 0 3.75 3.75M12 3v18"
                            />
                          </svg>
                        </div>
                      }
                    />
                    {/* {zweischen 4 und 20 } */}
                    <Input
                      type="number"
                      label="Spielfeldbreite auswählen"
                      placeholder="4"
                      labelPlacement="outside"
                      value={widthInputValue}
                      onChange={(e) => setWidthInputValue(e.target.valueAsNumber)}
                      //isDisabled={isSecondSelectDisabled}
                      isDisabled={true}
                      color={widthInputInvalid ? "danger" : ""}
                      errorMessage={
                        widthInputInvalid && "Bitte zweischen 4 und 20 auswählen  "
                      }
                      className={`${
                        isSecondSelectDisabled
                          ? "opacity-50 cursor-not-allowed"
                          : ""
                      }`}
                      endContent={
                        <div className="pointer-events-none flex items-center">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            strokeWidth="1.5"
                            stroke="currentColor"
                            data-slot="icon"
                            className="w-6 h-6"
                          >
                            <path
                              strokeLinecap="round"
                              strokeLinejoin="round"
                              d="M17.25 8.25 21 12m0 0-3.75 3.75M21 12H3"
                            />
                          </svg>
                        </div>
                      }
                    />
                  </div>
                </form>
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="light" onPress={onClose}>
                  Abbrechen
                </Button>
                <Button color="primary" onPress={handleCreateGameSubmit}>
                  Spiel erstellen
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
    </>
  );
};

export default CreateLobbyModalComponent;
