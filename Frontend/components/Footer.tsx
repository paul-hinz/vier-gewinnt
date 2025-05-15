"use client";

import React from "react";

export function Footer() {
  return (
    <footer className=" mx-auto px-6 bg-gray-800">
      <div className="flex flex-col justify-center items-center gap-1">
        <p className="text-sm text-default-400 p-6 text-white">
          &copy; 2023 VierGewinnt, Inc. Alle Rechte vorbehalten
        </p>
      </div>
    </footer>
  );
}
