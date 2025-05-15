# VierGewinnt

Kurze Beschreibung oder Einleitung deines Projekts hier.

## Inhaltsverzeichnis

- [Installation](#installation)
- [Verwendung](#verwendung)
- [Projektstruktur](#projektstruktur)
- [Tailwind CSS](#tailwind-css)
- [Next UI](#next-ui)
- [Dienste](#dienste)
- [Mitwirkende](#mitwirkende)
- [Lizenz](#lizenz)

## Installation

1. **Klonen des Repositories:**

   - Über SSH:

   ```bash
   git clone git@git.haw-hamburg.de:infwng589/vs-viergewinnt.git
   cd Frontend
   ```

   - Über HTTPS:

     ```bash
     git clone https://git.haw-hamburg.de/infwng589/vs-viergewinnt.git
     cd Frontend
     ```

   **Wichtig:** Stelle sicher, dass du zum richtigen Projektverzeichnis gewechselt bist, bevor du `npm install` ausführst.

## Installieren der Abhängigkeiten

First, run the development server:

```bash
npm install

```

## Entwicklungsserver starten:

```bash
npm run dev

```

Öffne deinen Browser und besuche [http://localhost:3000](http://localhost:3000), um das Ergebnis zu sehen.

Du kannst die Seite bearbeiten, indem du app/page.tsx änderst. Die Seite wird automatisch aktualisiert, während du die Datei bearbeitest.

## Produktionsbuild erstellen:

```bash
npm run build

```

## Anwendung starten:

```bash
npm start

```

## Projektstruktur

.
├── components/ # Wiederverwendbare React-Komponenten
├── pages/ # Seitenkomponenten für Next.js
├── public/ # Statische Dateien (z.B. Bilder)
├── styles/ # Stildefinitionen (CSS, SCSS, etc.)
├── services/ # Dienste (z.B. API-Anfragen, Datenverarbeitung)
├── .gitignore # Git Ignore-Datei
├── next.config.js # Next.js Konfigurationsdatei
├── package.json # NPM-Paketkonfiguration
└── README.md # Diese README-Datei

## Verwendete Technologien und Frameworks

Dieses Projekt nutzt die folgenden Technologien und Frameworks:

- **Next.js:** Ein React-Framework, das eine optimierte und performante Entwicklung von Webanwendungen ermöglicht. Weitere Informationen findest du in der [Next.js Dokumentation](https://nextjs.org/docs).

- **Tailwind CSS:** Ein Utility-First CSS-Framework für die einfache und schnelle Gestaltung von Benutzeroberflächen. Erfahre mehr über Tailwind CSS auf der [offiziellen Website](https://tailwindcss.com/).

- **Next UI:** Eine UI-Komponentenbibliothek für Next.js, die benutzerfreundliche und ansprechende UI-Elemente bereitstellt. Informationen dazu findest du auf [Next UI's Website](https://nextui.org/).

**Hinweis:** Stelle sicher, dass du die entsprechenden Abhängigkeiten installierst, wie in der [Installationsanleitung](#installation) beschrieben.

## Dienste

## Mitwirkende

Möchtest du zu diesem Projekt beitragen? Wir freuen uns über Beiträge aus der Community! Folge diesen Schritten:

1. **Fork das Repository.**
2. **Erstelle einen Branch:** `git checkout -b dein-feature`.
3. **Commit deine Änderungen:** `git commit -m 'Füge neue Funktion hinzu'`.
4. **Push zu dem Branch:** `git push origin dein-feature`.
5. **Öffne einen Pull Request.**

Dein Feedback und deine Beiträge sind willkommen!

## Weitere Informationen

Möchtest du mehr über Next.js erfahren? Schau dir die folgenden Ressourcen an:

- [Next.js Dokumentation](https://nextjs.org/docs) - erfahre mehr über die Funktionen und API von Next.js.
- [Next.js Lernen](https://nextjs.org/learn) - ein interaktives Next.js Tutorial.

Du kannst auch das [Next.js GitHub-Repository](https://github.com/vercel/next.js/) besuchen - dein Feedback und deine Beiträge sind willkommen!
