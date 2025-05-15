const { nextui } = require("@nextui-org/react");

/** @type {import('tailwindcss').Config} */

module.exports = {
  content: [
    "./app/**/*.{js,ts,jsx,tsx}",
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./app/pages/**{js,ts,jsx,tsx}",
    "./app/**{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
    "./node_modules/@nextui-org/theme/dist/**/*.{js,ts,jsx,tsx}",
    "./src/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        dd: "#3f3412",
      },
      gridTemplateColumns: {
        16: "repeat(16, minmax(0, 1fr))",

        footer: "200px minmax(900px, 1fr) 100px",
      },
    },
  },
  darkMode: "class",
  plugins: [nextui()],
};
