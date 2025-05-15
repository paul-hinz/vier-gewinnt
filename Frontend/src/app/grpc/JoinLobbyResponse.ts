// Original file: protos/Game.proto


export interface JoinLobbyResponse {
  'success'?: (boolean);
  'enemyName'?: (string);
  'gameTime'?: (number);
  'boardRowCount'?: (number);
  'boardColCount'?: (number);
  'clientID'?: (number);
}

export interface JoinLobbyResponse__Output {
  'success'?: (boolean);
  'enemyName'?: (string);
  'gameTime'?: (number);
  'boardRowCount'?: (number);
  'boardColCount'?: (number);
  'clientID'?: (number);
}
