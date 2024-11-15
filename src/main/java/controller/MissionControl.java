package controller;

/* TODO: to make it work with a list of MarsVehicles, to implement the logic to avoid collisions
    HashMap should be taken into consideration
    Logic to avoid collisions: a simple  "rock scissors paper" game between objects.
*/
import model.Instruction;
import vehicle.MarsVehicle;

import java.util.List;

public class MissionControl {

    public void executeMission(MarsVehicle vehicle, List<Instruction> instructions){
        try{
            vehicle.executeInstructions(instructions);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
    public void printName(){
        System.out.println("\033[1;36m========================\033[0m");
        System.out.println("\033[1;33m   M A R S   R O V E R\033[0m");
        System.out.println("\033[1;36m========================\033[0m");
    }
    public void printMarsRover(){
        System.out.println("\033[1;33m         ______\033[0m");
        System.out.println("\033[1;33m       _/      \\_\033[0m");
        System.out.println("\033[1;33m      / |      | \\\033[0m");
        System.out.println("\033[1;33m     /  |______|  \\\033[0m");
        System.out.println("\033[1;33m  __|______________|__\033[0m");
        System.out.println("\033[1;33m |                  o o|\033[0m");
        System.out.println("\033[1;33m |_____________________|\033[0m");
        System.out.println("\033[1;33m   |  \\__________/  |\033[0m");
        System.out.println("\033[1;33m   |                |\033[0m");
        System.out.println("\033[1;33m  [==]            [==]\033[0m");
        System.out.println("\033[1;33m   o                o\033[0m");
        System.out.println("\n\n");
    }
}
