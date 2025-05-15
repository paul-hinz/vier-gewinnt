"use client";

import React, { useState } from "react";
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
  Input,
} from "@nextui-org/react";
import { useRouter } from "next/navigation";

export function JoinLobbyModalComponent({isOpen, onClose} : {isOpen: boolean, onClose: () => void}) {
    const router = useRouter();
    const [lobbyId, setLobbyId] = useState<number>();

    const handleJoinGameSubmit = () => {
        router.push(
          `/game/${lobbyId}`
        );
    }

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
                Einer vorhandenen Lobby beitreten
              </ModalHeader>
              <ModalBody>
                <form>
                  <div>
                    <Input
                      value={lobbyId}
                      onValueChange={setLobbyId}
                      type="number"
                      label="Lobby-ID:"
                      placeholder="Bitte gebe die Lobby-ID an"
                      labelPlacement="outside"
                      className={`w-full mb-4`}
                    />
                  </div>
                </form>
              </ModalBody>
              <ModalFooter>
                <Button color="danger" variant="light" onPress={onClose}>
                  Abbrechen
                </Button>
                <Button color="primary" onPress={handleJoinGameSubmit}>
                  Spiel beitreten
                </Button>
              </ModalFooter>
            </>
          )}
        </ModalContent>
      </Modal>
    </>
)};
export default JoinLobbyModalComponent;