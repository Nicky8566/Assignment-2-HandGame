# Odds and Evens Hand Game

## Overview
Odds and Evens is a simple hand game implemented in Java. In this game, a human player faces off against an artificial intelligence (AI) named HAL-9000 from three selected 
difficulty. The game combines elements of chance and psychology, as HAL-9000 attempts to learn the behavior of the human player and predict their moves.
## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Gameplay](#gameplay)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Human vs AI Gameplay:** Play against an AI opponent that learns from your moves.
- **Random Move Generation:** AI randomly generates its moves within the range of 0 to 5 fingers.
- **Psychological Component:** The AI attempts to predict the player's moves based on past behavior.
- **Interactive Command-Line Interface:** Simple and interactive text-based interface for playing the game.
- **Score Tracking:** Keeps track of the number of rounds won by each player.

## Installation
To run **Assignment-2-HandGame** locally, follow these steps:

### 1. Clone the repository:
```sh
git clone https://github.com/Nicky8566/Assignment-2-HandGame.git
```

### 2. Navigate to the project directory:
```sh
cd Assignment-2-HandGame
```

### 3. Run the program:
#### For Mac:
```sh
./mvnw clean javafx:run
```
#### For Windows:
```sh
./mvnw.cmd clean javafx:run
```

## Gameplay

### Objective
The objective of the game is to correctly predict whether the total number of fingers shown by both players will be odd or even. The human player competes against the AI, HAL-9000, to see who can make the most correct predictions over multiple rounds.

### How to Play
#### 1. Setup: 
Two players face each other. One player decides if they want to be odds or evens. Let’s say the human player chooses evens.

#### 2. Gameplay:
Both players simultaneously show any number of fingers from 0 to 5.

#### 3. Counting:
If the total number of fingers shown by both players is even (0, 2, 4, 6, 8, 10), the player who chose evens wins. If it’s odd (1, 3, 5, 7, 9), the player who chose odds wins.

#### 4. Winner:
The player who correctly predicted the total (odd or even) wins that round.

#### 5. Repeat:
Players can play multiple rounds to determine an overall winner.

### How to Play
Odd + Odd = Even: Adding two odd numbers results in an even number. Even + Even = Even: Adding two even numbers results in an even number. Odd + Even = Odd: Adding an odd number and an even number results in an odd number. Even + Odd = Odd: This is the same as above, just in reverse order.

## Contributing
Contributions are welcome! If you have suggestions for improvements or new features, feel free to fork the repository and create a pull request.

### Steps to Contribute:
1. **Fork the Project**
2. **Create a Feature Branch**
   ```sh
   git checkout -b feature/AmazingFeature
   ```
3. **Commit your Changes**
   ```sh
   git commit -m 'Add some AmazingFeature'
   ```
4. **Push to the Branch**
   ```sh
   git push origin feature/AmazingFeature
   ```
5. **Open a Pull Request**

## License
Distributed under the **MIT License**. See `LICENSE` for more information.

