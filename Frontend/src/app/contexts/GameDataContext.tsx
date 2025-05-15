"use client";
import React, { createContext, useContext, useState } from "react";
import { GameClient } from "@/app/grpc/GameServiceClientPb";

import { CreateLobbyRequest, Enemy } from "@/app/grpc/Game_pb";


export const GameDataContext = createContext(null);

export default function GameDataContextProvider({ children }) {
    const [enemySelectValue, setEnemySelectValue] = useState("");
    const [nameInputValue, setNameInputValue] = useState<string>();
    const [timeInputValue, setTimeInputValue] = useState<number>(30);
    const [heightInputValue, setHeightInputValue] = useState<number>(6);
    const [widthInputValue, setWidthInputValue] = useState<number>(7);
    const [hasPlayerInfo, setHasPlayerInfo] = useState<boolean>(false);
    const [playerId, setPlayerId] = useState<string>("");
    const gameClient = new GameClient("http://localhost:8080");

    return (
        <GameDataContext.Provider
            value={{enemySelectValue, setEnemySelectValue,
                nameInputValue, setNameInputValue,
                timeInputValue, setTimeInputValue,
                heightInputValue, setHeightInputValue,
                widthInputValue, setWidthInputValue,
                playerId, setPlayerId,
                hasPlayerInfo, setHasPlayerInfo,
                gameClient
            }}
        >
            {children}
        </GameDataContext.Provider>
    )
}

export function useGameDataContext() {
    const gameDataContext = useContext(GameDataContext);
    if (!gameDataContext) {
        throw new Error("GameDataContext must be used within a GameDataContextProvider!");
    }
    return gameDataContext;
}