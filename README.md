# Process Scheduling Algorithms Implementation

This project is part of the Operating Systems course, where we implement various process scheduling algorithms. The project involves reading a text file containing processes. Each line of the file represents a process, with information about its name, duration, and priority.

Once the processes are loaded, the program displays a console menu for the user to choose from the following scheduling algorithms:
1. FCFS (First-Come, First-Served)
2. SJF (Shortest Job First)
3. Priority Scheduling
4. Round Robin (with a quantum of 3)

The 5th option in the menu terminates the program's execution.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Algorithms Implemented](#algorithms-implemented)
  - [FCFS (First-Come, First-Served)](#1-fcfs-first-come-first-served)
  - [SJF (Shortest Job First)](#2-sjf-shortest-job-first)
  - [Priority Scheduling](#3-priority-scheduling)
  - [Round Robin](#4-round-robin)
- [Dependencies](#dependencies)
- [Contact](#contact)

## Features
- Load and parse process data from a text file.
- Simulate process scheduling using multiple algorithms.
- Display scheduling results and process execution order.

## Getting Started
To run this project, follow these steps:

1. Clone the repository to your local machine.
2. Compile the Java source code.
3. Run the program and follow the on-screen instructions.

## Usage
1. Choose one of the scheduling algorithms from the menu.
2. The program will execute the selected algorithm and display the results.
3. You can continue to select different algorithms or exit the program.

## Algorithms Implemented
### 1. FCFS (First-Come, First-Served)
This algorithm schedules processes in the order they arrive.

### 2. SJF (Shortest Job First)
This algorithm schedules processes based on their execution time, selecting the shortest job first.

### 3. Priority Scheduling
Processes are scheduled based on their priority levels.

### 4. Round Robin
Processes are scheduled in a circular manner, each receiving a fixed time slice (quantum) of 3 units.

## Dependencies
This project is implemented in Java and does not have external dependencies beyond the Java Development Kit (JDK).

## Contact

If you have any questions or need further assistance, feel free to contact the project maintainer:

Ismael Avila
- Email: ismaelg.avilag@gmail.com
- GitHub: [Ismaelg-Avilag](https://github.com/ismaelg-avilag)
- LinkedIn: [Ismaelg-Avilag](https://www.linkedin.com/in/ismaelg-avilag)
