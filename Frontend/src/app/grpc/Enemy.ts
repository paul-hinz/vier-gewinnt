// Original file: protos/Game.proto

export const Enemy = {
  AI: 0,
  PVP: 1,
} as const;

export type Enemy =
  | 'AI'
  | 0
  | 'PVP'
  | 1

export type Enemy__Output = typeof Enemy[keyof typeof Enemy]
