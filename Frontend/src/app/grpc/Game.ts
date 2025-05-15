// Original file: protos/Game.proto

import type * as grpc from '@grpc/grpc-js'
import type { MethodDefinition } from '@grpc/proto-loader'
import type { CreateLobbyRequest as _CreateLobbyRequest, CreateLobbyRequest__Output as _CreateLobbyRequest__Output } from './CreateLobbyRequest';
import type { CreateLobbyResponse as _CreateLobbyResponse, CreateLobbyResponse__Output as _CreateLobbyResponse__Output } from './CreateLobbyResponse';
import type { GetLobbiesResponse as _GetLobbiesResponse, GetLobbiesResponse__Output as _GetLobbiesResponse__Output } from './GetLobbiesResponse';
import type { JoinLobbyRequest as _JoinLobbyRequest, JoinLobbyRequest__Output as _JoinLobbyRequest__Output } from './JoinLobbyRequest';
import type { JoinLobbyResponse as _JoinLobbyResponse, JoinLobbyResponse__Output as _JoinLobbyResponse__Output } from './JoinLobbyResponse';
import type { MoveRequest as _MoveRequest, MoveRequest__Output as _MoveRequest__Output } from './MoveRequest';
import type { PollRequest as _PollRequest, PollRequest__Output as _PollRequest__Output } from './PollRequest';
import type { ResponseStream as _ResponseStream, ResponseStream__Output as _ResponseStream__Output } from './ResponseStream';
import type { StartRequest as _StartRequest, StartRequest__Output as _StartRequest__Output } from './StartRequest';
import type { TwitterRequest as _TwitterRequest, TwitterRequest__Output as _TwitterRequest__Output } from './TwitterRequest';
import type { TwitterSuccess as _TwitterSuccess, TwitterSuccess__Output as _TwitterSuccess__Output } from './TwitterSuccess';
import type { Void as _Void, Void__Output as _Void__Output } from './Void';

export interface GameClient extends grpc.Client {
  CreateLobby(argument: _CreateLobbyRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  CreateLobby(argument: _CreateLobbyRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  CreateLobby(argument: _CreateLobbyRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  CreateLobby(argument: _CreateLobbyRequest, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  createLobby(argument: _CreateLobbyRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  createLobby(argument: _CreateLobbyRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  createLobby(argument: _CreateLobbyRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  createLobby(argument: _CreateLobbyRequest, callback: grpc.requestCallback<_CreateLobbyResponse__Output>): grpc.ClientUnaryCall;
  
  GetLobbies(argument: _Void, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  GetLobbies(argument: _Void, metadata: grpc.Metadata, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  GetLobbies(argument: _Void, options: grpc.CallOptions, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  GetLobbies(argument: _Void, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  getLobbies(argument: _Void, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  getLobbies(argument: _Void, metadata: grpc.Metadata, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  getLobbies(argument: _Void, options: grpc.CallOptions, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  getLobbies(argument: _Void, callback: grpc.requestCallback<_GetLobbiesResponse__Output>): grpc.ClientUnaryCall;
  
  JoinLobby(argument: _JoinLobbyRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  JoinLobby(argument: _JoinLobbyRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  JoinLobby(argument: _JoinLobbyRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  JoinLobby(argument: _JoinLobbyRequest, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  joinLobby(argument: _JoinLobbyRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  joinLobby(argument: _JoinLobbyRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  joinLobby(argument: _JoinLobbyRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  joinLobby(argument: _JoinLobbyRequest, callback: grpc.requestCallback<_JoinLobbyResponse__Output>): grpc.ClientUnaryCall;
  
  MakeMove(argument: _MoveRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  MakeMove(argument: _MoveRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  MakeMove(argument: _MoveRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  MakeMove(argument: _MoveRequest, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  makeMove(argument: _MoveRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  makeMove(argument: _MoveRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  makeMove(argument: _MoveRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  makeMove(argument: _MoveRequest, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  
  PollGameData(argument: _PollRequest, metadata: grpc.Metadata, options?: grpc.CallOptions): grpc.ClientReadableStream<_ResponseStream__Output>;
  PollGameData(argument: _PollRequest, options?: grpc.CallOptions): grpc.ClientReadableStream<_ResponseStream__Output>;
  pollGameData(argument: _PollRequest, metadata: grpc.Metadata, options?: grpc.CallOptions): grpc.ClientReadableStream<_ResponseStream__Output>;
  pollGameData(argument: _PollRequest, options?: grpc.CallOptions): grpc.ClientReadableStream<_ResponseStream__Output>;
  
  PostTwitter(argument: _TwitterRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  PostTwitter(argument: _TwitterRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  PostTwitter(argument: _TwitterRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  PostTwitter(argument: _TwitterRequest, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  postTwitter(argument: _TwitterRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  postTwitter(argument: _TwitterRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  postTwitter(argument: _TwitterRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  postTwitter(argument: _TwitterRequest, callback: grpc.requestCallback<_TwitterSuccess__Output>): grpc.ClientUnaryCall;
  
  StartGame(argument: _StartRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  StartGame(argument: _StartRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  StartGame(argument: _StartRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  StartGame(argument: _StartRequest, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  startGame(argument: _StartRequest, metadata: grpc.Metadata, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  startGame(argument: _StartRequest, metadata: grpc.Metadata, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  startGame(argument: _StartRequest, options: grpc.CallOptions, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  startGame(argument: _StartRequest, callback: grpc.requestCallback<_Void__Output>): grpc.ClientUnaryCall;
  
}

export interface GameHandlers extends grpc.UntypedServiceImplementation {
  CreateLobby: grpc.handleUnaryCall<_CreateLobbyRequest__Output, _CreateLobbyResponse>;
  
  GetLobbies: grpc.handleUnaryCall<_Void__Output, _GetLobbiesResponse>;
  
  JoinLobby: grpc.handleUnaryCall<_JoinLobbyRequest__Output, _JoinLobbyResponse>;
  
  MakeMove: grpc.handleUnaryCall<_MoveRequest__Output, _Void>;
  
  PollGameData: grpc.handleServerStreamingCall<_PollRequest__Output, _ResponseStream>;
  
  PostTwitter: grpc.handleUnaryCall<_TwitterRequest__Output, _TwitterSuccess>;
  
  StartGame: grpc.handleUnaryCall<_StartRequest__Output, _Void>;
  
}

export interface GameDefinition extends grpc.ServiceDefinition {
  CreateLobby: MethodDefinition<_CreateLobbyRequest, _CreateLobbyResponse, _CreateLobbyRequest__Output, _CreateLobbyResponse__Output>
  GetLobbies: MethodDefinition<_Void, _GetLobbiesResponse, _Void__Output, _GetLobbiesResponse__Output>
  JoinLobby: MethodDefinition<_JoinLobbyRequest, _JoinLobbyResponse, _JoinLobbyRequest__Output, _JoinLobbyResponse__Output>
  MakeMove: MethodDefinition<_MoveRequest, _Void, _MoveRequest__Output, _Void__Output>
  PollGameData: MethodDefinition<_PollRequest, _ResponseStream, _PollRequest__Output, _ResponseStream__Output>
  PostTwitter: MethodDefinition<_TwitterRequest, _TwitterSuccess, _TwitterRequest__Output, _TwitterSuccess__Output>
  StartGame: MethodDefinition<_StartRequest, _Void, _StartRequest__Output, _Void__Output>
}
