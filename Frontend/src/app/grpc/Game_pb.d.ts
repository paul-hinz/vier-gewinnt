import * as jspb from 'google-protobuf'



export class GetLobbiesResponse extends jspb.Message {
  getLobbiesList(): Array<Lobby>;
  setLobbiesList(value: Array<Lobby>): GetLobbiesResponse;
  clearLobbiesList(): GetLobbiesResponse;
  addLobbies(value?: Lobby, index?: number): Lobby;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GetLobbiesResponse.AsObject;
  static toObject(includeInstance: boolean, msg: GetLobbiesResponse): GetLobbiesResponse.AsObject;
  static serializeBinaryToWriter(message: GetLobbiesResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GetLobbiesResponse;
  static deserializeBinaryFromReader(message: GetLobbiesResponse, reader: jspb.BinaryReader): GetLobbiesResponse;
}

export namespace GetLobbiesResponse {
  export type AsObject = {
    lobbiesList: Array<Lobby.AsObject>,
  }
}

export class Lobby extends jspb.Message {
  getId(): string;
  setId(value: string): Lobby;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Lobby.AsObject;
  static toObject(includeInstance: boolean, msg: Lobby): Lobby.AsObject;
  static serializeBinaryToWriter(message: Lobby, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Lobby;
  static deserializeBinaryFromReader(message: Lobby, reader: jspb.BinaryReader): Lobby;
}

export namespace Lobby {
  export type AsObject = {
    id: string,
  }
}

export class CreateLobbyRequest extends jspb.Message {
  getOwnname(): string;
  setOwnname(value: string): CreateLobbyRequest;

  getGametime(): number;
  setGametime(value: number): CreateLobbyRequest;

  getBoardrowcount(): number;
  setBoardrowcount(value: number): CreateLobbyRequest;

  getBoardcolcount(): number;
  setBoardcolcount(value: number): CreateLobbyRequest;

  getEnemy(): Enemy;
  setEnemy(value: Enemy): CreateLobbyRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CreateLobbyRequest.AsObject;
  static toObject(includeInstance: boolean, msg: CreateLobbyRequest): CreateLobbyRequest.AsObject;
  static serializeBinaryToWriter(message: CreateLobbyRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CreateLobbyRequest;
  static deserializeBinaryFromReader(message: CreateLobbyRequest, reader: jspb.BinaryReader): CreateLobbyRequest;
}

export namespace CreateLobbyRequest {
  export type AsObject = {
    ownname: string,
    gametime: number,
    boardrowcount: number,
    boardcolcount: number,
    enemy: Enemy,
  }
}

export class CreateLobbyResponse extends jspb.Message {
  getSuccess(): boolean;
  setSuccess(value: boolean): CreateLobbyResponse;

  getLobbyid(): number;
  setLobbyid(value: number): CreateLobbyResponse;

  getClientid(): number;
  setClientid(value: number): CreateLobbyResponse;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CreateLobbyResponse.AsObject;
  static toObject(includeInstance: boolean, msg: CreateLobbyResponse): CreateLobbyResponse.AsObject;
  static serializeBinaryToWriter(message: CreateLobbyResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CreateLobbyResponse;
  static deserializeBinaryFromReader(message: CreateLobbyResponse, reader: jspb.BinaryReader): CreateLobbyResponse;
}

export namespace CreateLobbyResponse {
  export type AsObject = {
    success: boolean,
    lobbyid: number,
    clientid: number,
  }
}

export class JoinLobbyRequest extends jspb.Message {
  getOwnname(): string;
  setOwnname(value: string): JoinLobbyRequest;

  getLobbyid(): number;
  setLobbyid(value: number): JoinLobbyRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): JoinLobbyRequest.AsObject;
  static toObject(includeInstance: boolean, msg: JoinLobbyRequest): JoinLobbyRequest.AsObject;
  static serializeBinaryToWriter(message: JoinLobbyRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): JoinLobbyRequest;
  static deserializeBinaryFromReader(message: JoinLobbyRequest, reader: jspb.BinaryReader): JoinLobbyRequest;
}

export namespace JoinLobbyRequest {
  export type AsObject = {
    ownname: string,
    lobbyid: number,
  }
}

export class JoinLobbyResponse extends jspb.Message {
  getSuccess(): boolean;
  setSuccess(value: boolean): JoinLobbyResponse;

  getEnemyname(): string;
  setEnemyname(value: string): JoinLobbyResponse;

  getGametime(): number;
  setGametime(value: number): JoinLobbyResponse;

  getBoardrowcount(): number;
  setBoardrowcount(value: number): JoinLobbyResponse;

  getBoardcolcount(): number;
  setBoardcolcount(value: number): JoinLobbyResponse;

  getClientid(): number;
  setClientid(value: number): JoinLobbyResponse;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): JoinLobbyResponse.AsObject;
  static toObject(includeInstance: boolean, msg: JoinLobbyResponse): JoinLobbyResponse.AsObject;
  static serializeBinaryToWriter(message: JoinLobbyResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): JoinLobbyResponse;
  static deserializeBinaryFromReader(message: JoinLobbyResponse, reader: jspb.BinaryReader): JoinLobbyResponse;
}

export namespace JoinLobbyResponse {
  export type AsObject = {
    success: boolean,
    enemyname: string,
    gametime: number,
    boardrowcount: number,
    boardcolcount: number,
    clientid: number,
  }
}

export class ResponseStream extends jspb.Message {
  getBegin(): Begin | undefined;
  setBegin(value?: Begin): ResponseStream;
  hasBegin(): boolean;
  clearBegin(): ResponseStream;

  getSetstone(): SetStone | undefined;
  setSetstone(value?: SetStone): ResponseStream;
  hasSetstone(): boolean;
  clearSetstone(): ResponseStream;

  getUpdatetimer(): UpdateTimer | undefined;
  setUpdatetimer(value?: UpdateTimer): ResponseStream;
  hasUpdatetimer(): boolean;
  clearUpdatetimer(): ResponseStream;

  getSetwinner(): SetWinner | undefined;
  setSetwinner(value?: SetWinner): ResponseStream;
  hasSetwinner(): boolean;
  clearSetwinner(): ResponseStream;

  getSetenemy(): EnemyData | undefined;
  setSetenemy(value?: EnemyData): ResponseStream;
  hasSetenemy(): boolean;
  clearSetenemy(): ResponseStream;

  getActionCase(): ResponseStream.ActionCase;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): ResponseStream.AsObject;
  static toObject(includeInstance: boolean, msg: ResponseStream): ResponseStream.AsObject;
  static serializeBinaryToWriter(message: ResponseStream, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): ResponseStream;
  static deserializeBinaryFromReader(message: ResponseStream, reader: jspb.BinaryReader): ResponseStream;
}

export namespace ResponseStream {
  export type AsObject = {
    begin?: Begin.AsObject,
    setstone?: SetStone.AsObject,
    updatetimer?: UpdateTimer.AsObject,
    setwinner?: SetWinner.AsObject,
    setenemy?: EnemyData.AsObject,
  }

  export enum ActionCase { 
    ACTION_NOT_SET = 0,
    BEGIN = 1,
    SETSTONE = 2,
    UPDATETIMER = 3,
    SETWINNER = 4,
    SETENEMY = 5,
  }
}

export class PollRequest extends jspb.Message {
  getClientid(): number;
  setClientid(value: number): PollRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): PollRequest.AsObject;
  static toObject(includeInstance: boolean, msg: PollRequest): PollRequest.AsObject;
  static serializeBinaryToWriter(message: PollRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): PollRequest;
  static deserializeBinaryFromReader(message: PollRequest, reader: jspb.BinaryReader): PollRequest;
}

export namespace PollRequest {
  export type AsObject = {
    clientid: number,
  }
}

export class Begin extends jspb.Message {
  getBegin(): boolean;
  setBegin(value: boolean): Begin;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Begin.AsObject;
  static toObject(includeInstance: boolean, msg: Begin): Begin.AsObject;
  static serializeBinaryToWriter(message: Begin, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Begin;
  static deserializeBinaryFromReader(message: Begin, reader: jspb.BinaryReader): Begin;
}

export namespace Begin {
  export type AsObject = {
    begin: boolean,
  }
}

export class TwitterSuccess extends jspb.Message {
  getSuccess(): boolean;
  setSuccess(value: boolean): TwitterSuccess;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): TwitterSuccess.AsObject;
  static toObject(includeInstance: boolean, msg: TwitterSuccess): TwitterSuccess.AsObject;
  static serializeBinaryToWriter(message: TwitterSuccess, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): TwitterSuccess;
  static deserializeBinaryFromReader(message: TwitterSuccess, reader: jspb.BinaryReader): TwitterSuccess;
}

export namespace TwitterSuccess {
  export type AsObject = {
    success: boolean,
  }
}

export class StartGame extends jspb.Message {
  getStartgame(): boolean;
  setStartgame(value: boolean): StartGame;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): StartGame.AsObject;
  static toObject(includeInstance: boolean, msg: StartGame): StartGame.AsObject;
  static serializeBinaryToWriter(message: StartGame, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): StartGame;
  static deserializeBinaryFromReader(message: StartGame, reader: jspb.BinaryReader): StartGame;
}

export namespace StartGame {
  export type AsObject = {
    startgame: boolean,
  }
}

export class SetStone extends jspb.Message {
  getCol(): number;
  setCol(value: number): SetStone;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): SetStone.AsObject;
  static toObject(includeInstance: boolean, msg: SetStone): SetStone.AsObject;
  static serializeBinaryToWriter(message: SetStone, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): SetStone;
  static deserializeBinaryFromReader(message: SetStone, reader: jspb.BinaryReader): SetStone;
}

export namespace SetStone {
  export type AsObject = {
    col: number,
  }
}

export class UpdateTimer extends jspb.Message {
  getTimeleft(): number;
  setTimeleft(value: number): UpdateTimer;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): UpdateTimer.AsObject;
  static toObject(includeInstance: boolean, msg: UpdateTimer): UpdateTimer.AsObject;
  static serializeBinaryToWriter(message: UpdateTimer, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): UpdateTimer;
  static deserializeBinaryFromReader(message: UpdateTimer, reader: jspb.BinaryReader): UpdateTimer;
}

export namespace UpdateTimer {
  export type AsObject = {
    timeleft: number,
  }
}

export class MoveRequest extends jspb.Message {
  getClientid(): number;
  setClientid(value: number): MoveRequest;

  getCol(): number;
  setCol(value: number): MoveRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): MoveRequest.AsObject;
  static toObject(includeInstance: boolean, msg: MoveRequest): MoveRequest.AsObject;
  static serializeBinaryToWriter(message: MoveRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): MoveRequest;
  static deserializeBinaryFromReader(message: MoveRequest, reader: jspb.BinaryReader): MoveRequest;
}

export namespace MoveRequest {
  export type AsObject = {
    clientid: number,
    col: number,
  }
}

export class StartRequest extends jspb.Message {
  getClientid(): number;
  setClientid(value: number): StartRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): StartRequest.AsObject;
  static toObject(includeInstance: boolean, msg: StartRequest): StartRequest.AsObject;
  static serializeBinaryToWriter(message: StartRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): StartRequest;
  static deserializeBinaryFromReader(message: StartRequest, reader: jspb.BinaryReader): StartRequest;
}

export namespace StartRequest {
  export type AsObject = {
    clientid: number,
  }
}

export class TwitterRequest extends jspb.Message {
  getClientid(): number;
  setClientid(value: number): TwitterRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): TwitterRequest.AsObject;
  static toObject(includeInstance: boolean, msg: TwitterRequest): TwitterRequest.AsObject;
  static serializeBinaryToWriter(message: TwitterRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): TwitterRequest;
  static deserializeBinaryFromReader(message: TwitterRequest, reader: jspb.BinaryReader): TwitterRequest;
}

export namespace TwitterRequest {
  export type AsObject = {
    clientid: number,
  }
}

export class SetWinner extends jspb.Message {
  getWinner(): boolean;
  setWinner(value: boolean): SetWinner;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): SetWinner.AsObject;
  static toObject(includeInstance: boolean, msg: SetWinner): SetWinner.AsObject;
  static serializeBinaryToWriter(message: SetWinner, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): SetWinner;
  static deserializeBinaryFromReader(message: SetWinner, reader: jspb.BinaryReader): SetWinner;
}

export namespace SetWinner {
  export type AsObject = {
    winner: boolean,
  }
}

export class EnemyData extends jspb.Message {
  getEnemyid(): number;
  setEnemyid(value: number): EnemyData;

  getEnemyname(): string;
  setEnemyname(value: string): EnemyData;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): EnemyData.AsObject;
  static toObject(includeInstance: boolean, msg: EnemyData): EnemyData.AsObject;
  static serializeBinaryToWriter(message: EnemyData, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): EnemyData;
  static deserializeBinaryFromReader(message: EnemyData, reader: jspb.BinaryReader): EnemyData;
}

export namespace EnemyData {
  export type AsObject = {
    enemyid: number,
    enemyname: string,
  }
}

export class Void extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Void.AsObject;
  static toObject(includeInstance: boolean, msg: Void): Void.AsObject;
  static serializeBinaryToWriter(message: Void, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Void;
  static deserializeBinaryFromReader(message: Void, reader: jspb.BinaryReader): Void;
}

export namespace Void {
  export type AsObject = {
  }
}

export enum Enemy { 
  AI = 0,
  PVP = 1,
}
