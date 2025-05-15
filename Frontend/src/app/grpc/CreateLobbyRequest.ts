// Original file: protos/Game.proto

import type { Enemy as _Enemy, Enemy__Output as _Enemy__Output } from './Enemy';

export interface CreateLobbyRequest {
  'ownName'?: (string);
  'gameTime'?: (number);
  'boardRowCount'?: (number);
  'boardColCount'?: (number);
  'enemy'?: (_Enemy);
}

export interface CreateLobbyRequest__Output {
  'ownName'?: (string);
  'gameTime'?: (number);
  'boardRowCount'?: (number);
  'boardColCount'?: (number);
  'enemy'?: (_Enemy__Output);
}
