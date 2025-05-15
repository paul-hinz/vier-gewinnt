"use client";
import { CircularProgress } from "@nextui-org/react";

export function CountdownTimer({
  timeValue,
  maxTimerSeconds,
  isDisabled,
}: {
  timeValue: number;
  maxTimerSeconds: number;
  isDisabled: boolean;
}) {
  return (
    <div className="text-white">
      <div
        id="timer"
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <span>Zeit verbleibend:</span>
        <CircularProgress
          aria-label="Loading..."
          formatOptions={{ style: "unit", unit: "second" }}
          size="lg"
          value={timeValue}
          showValueLabel={true}
          valueLabel={timeValue}
          maxValue={maxTimerSeconds}
          isDisabled={isDisabled}
        />
      </div>
    </div>
  );
}
