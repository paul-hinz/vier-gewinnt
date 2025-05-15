"use client";
import React, { useState, useEffect } from "react";
import { Button } from "@nextui-org/react";
import CreateLobbyModalComponent from "../../components/CreateLobbyModalComponent";
import { Container } from "../../components/Container";
import { JoinLobbyModalComponent } from "../../components/JoinLobbyModalComponent";


const Home: React.FC = () => {
  const [createGameModalIsOpen, setCreateGameModalIsOpen] = useState(false);
  const [joinGameModalIsOpen, setJoinGameModalIsOpen] = useState(false);

  const openCreateGameModal = () => {
    setCreateGameModalIsOpen(true);
  };

  const closeCreateGameModal = () => {
    setCreateGameModalIsOpen(false);
  };

  const openJoinGameModal = () => {
    setJoinGameModalIsOpen(true);
  };

  const closeJoinGameModal = () => {
    setJoinGameModalIsOpen(false);
  };

  return (
    <>
      <Container>
        <div className="relative  px-6 pt-14 lg:px-8">
          <div className="relative container mx-auto  z-10 px-6  mb-12 flex-grow flex items-center justify-center">
            <div className="text-center">
              <h1 className="text-4xl font-bold tracking-tight text-white sm:text-6xl">
                Vier-Gewinnt Online
              </h1>
              <p className="mt-6 text-lg leading-8 text-gray-600">
                Wo Bits und Bytes sich zum Vier-Gewinnt vereinen!
              </p>
              <p className="mt-6 text-lg leading-8 text-gray-400">
                Also, worauf wartest du noch? Klicke auf "Spiel erstellen" und
                zeige, dass du der ultimative Vier-Gewinnt-Champion bist! Viel
                Spaß und viel Erfolg beim Vier-Gewinnt-Spiel
              </p>
              <div className="mt-10 flex items-center justify-center gap-x-6">
                <Button
                  onClick={openCreateGameModal}
                  className="mt-4 p-4"
                  color="primary"
                  variant="bordered"
                >
                  Spiel erstellen
                </Button>
                <Button
                  onClick={openJoinGameModal}
                  className="mt-4 p-4"
                  color="primary"
                  variant="bordered"
                  >
                    Spiel beitreten
                </Button>
                
                <CreateLobbyModalComponent
                  isOpen={createGameModalIsOpen}
                  onClose={closeCreateGameModal}
                  //setWidthInputValue={boardWidth}
                  // setHeightInputValue={boardHeight}
                />
                <JoinLobbyModalComponent
                  isOpen={joinGameModalIsOpen}
                  onClose={closeJoinGameModal}
                />
              </div>
            </div>
          </div>
        </div>
      </Container>
    </>
  );
};

export default Home;
