# Process Scheduling Algorithms with GUI Enhancement

This project is an extension of the original [Process Scheduling Algorithms project](https://github.com/ismaelg-avilag/os-lab03-process-planning-algorithms-01), which now includes a Graphical User Interface (GUI) implemented with Java Swing for enhanced user interaction. In addition to loading processes from a file, users can now add new processes and choose whether to place them at the beginning or the end of the process queue.

![Demo GIF](https://github.com/ismaelg-avilag/os-lab04-process-planning-algorithms-02/blob/main/images/GUI.gif)

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
- [License](#license)
- [Contact](#contact)

## Features
- Load and parse process data from a text file.
- Simulate process scheduling using multiple algorithms.
- Display scheduling results and process execution order.
- Interactive Graphical User Interface (GUI) for easier use.
- Add new processes to the queue and specify their placement (beginning or end).

## Getting Started
To run this project, follow these steps:

1. Clone the repository to your local machine.
2. Compile the Java source code.
3. Run the program and interact with the GUI.

## Usage
1. Choose one of the scheduling algorithms from the menu.
2. The program will execute the selected algorithm and display the results in the GUI.
3. You can add new processes by providing their name, duration, and priority, and choose to place them at the beginning or end of the queue.
4. Continue to interact with the GUI to simulate different scenarios.

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
This project is implemented in Java with Java Swing for the GUI and does not have external dependencies beyond the Java Development Kit (JDK).

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact
If you have any questions or need further assistance, feel free to contact the project maintainer:

Ismael Avila
- Email: ismaelg.avilag@gmail.com
- GitHub: [Ismaelg-Avilag](https://github.com/ismaelg-avilag)
- LinkedIn: [Ismaelg-Avilag](https://www.linkedin.com/in/ismaelg-avilag)
