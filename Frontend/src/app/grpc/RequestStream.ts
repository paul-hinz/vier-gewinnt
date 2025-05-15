// Original file: ../protos/Game.proto

import type { MakeMove as _MakeMove, MakeMove__Output as _MakeMove__Output } from './MakeMove';
import type { StartGame as _StartGame, StartGame__Output as _StartGame__Output } from './StartGame';

export interface RequestStream {
  'clientID'?: (number);
  'makeMove'?: (_MakeMove | null);
  'startGame'?: (_StartGame | null);
  'action'?: "makeMove"|"startGame";
}

export interface RequestStream__Output {
  'clientID'?: (number);
  'makeMove'?: (_MakeMove__Output);
  'startGame'?: (_StartGame__Output);
}
