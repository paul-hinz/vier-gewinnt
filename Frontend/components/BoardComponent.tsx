"use client";
import React from "react";

export function BoardComponent({
  stones,
  boardWidth,
  boardHeight,
  disabled,
  makeMove,
}: {
  stones: {
    color: null;
    disabled: boolean;
  }[];
  boardWidth: number;
  boardHeight: number;
  disabled: boolean;
  makeMove: (col: number) => void;
}) {
  const QuadratGrid = ({
    length,
    height,
  }: {
    length: number;
    height: number;
  }) => {
    const rows = height;
    const columns = length;
    const widthInPX = 80 * columns;
    return (
      <>
        <div className="p-8 bg-amber-100 flex flex-row-reverse bg-gray-400/5 ">
          <div
            className={`mx-auto border-2 border-blue-500 rounded-lg grid grid-cols-${columns} gap-2 w-[${widthInPX}px] `}
          >
            {Array.from({ length: columns * rows }, (_, index) => {
              const stone = stones[index];

              const col = index % columns;
              const row = Math.floor(index / columns);

              return (
                <div key={index}>
                  <button
                    data-index={index}
                    data-testid={`button-${index}`}
                    style={{
                      background:
                        stone.color ||
                        "radial-gradient(circle at 100px 100px, #93c5fd, #000)",
                    }}
                    role="button"
                    disabled={disabled}
                    onClick={() => makeMove(index % boardWidth)}
                    className="inline-flex items-center justify-center w-[4.5rem] h-[4.5rem] mr-2 text-indigo-100 transition-colors duration-150 bg-gray-100 rounded-full focus:shadow-outline hover:bg-gray-500"
                  >
                    <svg
                      className="w-6 h-5 fill-current"
                      viewBox="0 0 20 20"
                    ></svg>
                  </button>
                </div>
              );
            })}
          </div>
        </div>
      </>
    );
  };

  return (
    <>
      <QuadratGrid length={boardWidth} height={boardHeight}></QuadratGrid>
    </>
  );
}
