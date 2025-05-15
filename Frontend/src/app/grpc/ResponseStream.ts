// Original file: protos/Game.proto

import type { Begin as _Begin, Begin__Output as _Begin__Output } from './Begin';
import type { SetStone as _SetStone, SetStone__Output as _SetStone__Output } from './SetStone';
import type { UpdateTimer as _UpdateTimer, UpdateTimer__Output as _UpdateTimer__Output } from './UpdateTimer';
import type { SetWinner as _SetWinner, SetWinner__Output as _SetWinner__Output } from './SetWinner';
import type { EnemyData as _EnemyData, EnemyData__Output as _EnemyData__Output } from './EnemyData';

export interface ResponseStream {
  'begin'?: (_Begin | null);
  'setStone'?: (_SetStone | null);
  'updateTimer'?: (_UpdateTimer | null);
  'setWinner'?: (_SetWinner | null);
  'setEnemy'?: (_EnemyData | null);
  'action'?: "begin"|"setStone"|"updateTimer"|"setWinner"|"setEnemy";
}

export interface ResponseStream__Output {
  'begin'?: (_Begin__Output);
  'setStone'?: (_SetStone__Output);
  'updateTimer'?: (_UpdateTimer__Output);
  'setWinner'?: (_SetWinner__Output);
  'setEnemy'?: (_EnemyData__Output);
}
