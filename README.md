# Mars Rover Project

## Description
 The **Mars Rover Project** is a Java mini application that simulates the movement of a rover on a rectangular plateau. 
 The rover can receive commands to move and turn on a grid-based enviroment, adhering to user-defined constraints and positions. The project demonstrates the use of Object Oriented Programming Principles, including abstraction, encapsulation and inheritance, and also aligning with SOLID principles.

 ## Features
 - **Plateau Initialization** : Define the dimensions of the plateau
 - **Rover Placement**: Set the initial position and orientation of the rover
 - **Instructions Parsing**: Process movement instructions (`L`, `R`, `M`) to navigate the rover.
 - **Boundary Handling**: Ensure the rover stays within the defined plateau grid by turning right each time when the next move should be outside the grid.
 - **ASCII Art**: Display a visual representation of the Mars Roverin the console

 ## How to Run

 ### Prerequisites
 - **Java Development Kit (JDK)**
 - **IDE or Terminal**: Any JAVA IDE (IntelliJ, Eclipse) or a terminal, with Java properly confirgured

 ### Steps
 1. Clone the repository:
    ```bash
    git clone https://github.com/victorboleac/mars-rover.git
    ```
2. Open the project in your IDE
3. Find and Run the Main Class `src/main/java/Main.java`

### Example Input & Output
- Input Plateau Size: `5 5`
- Input Initial Position: `1 2 N`
- Input Instructions: `LMLMLMLMM`

Output:
```bash
1 3 N
```
## Documentation for Developers
### Project Structure
```bash
src/main/java
├── input/                  # Handles input parsing logic
│   └── InputParser.java
├── model/                  # Contains enums and models for positions and directions
│   ├── CompassDirection.java
│   ├── Instruction.java
│   └── Position.java
├── plateau/                # Singleton pattern for the plateau grid
│   └── PlateauSize.java
├── vehicle/                # Abstract MarsVehicle and Rover implementation
│   ├── MarsVehicle.java
│   └── Rover.java
└── controller/
│   └──MissionControl.java  # Controller for executing missions
└── Main.java               # Main class for running the app
```
### Key Classes and Responsibilities

- **`InputParser`**:
  - Parses user input for plateau size, initial position, and instructions.

- **`CompassDirection`**:
  - Enum representing the rover's possible orientations (`N`, `E`, `S`, `W`).

- **`Instruction`**:
  - Enum for movement commands (`L`, `R`, `M`) with a utility to parse characters.

- **`PlateauSize`**:
  - Singleton to define and validate the plateau boundaries.

- **`Position`**:
  - Tracks the rover's position and facing direction.

- **`MarsVehicle`**:
  - Abstract class for rover behavior, including movement and turning logic.

- **`Rover`**:
  - Implements the `MarsVehicle` class for a basic rover.

- **`MissionControl`**:
  - Orchestrates the execution of movement instructions.
    
### New Features To Be Added
1. **Additional Vehicles**:
   - Extend the `MarsVehicle` class.
   - Add interfaces for vehicles that can fly
   - Implement specific behavior in the `moveForward` method.
   - Add moveBackward option

2. **Enhanced Instruction Parsing**:
   - Add new instructions to the `Instruction` enum.
   - Update `executeInstruction` in `MarsVehicle` for custom behaviors.
