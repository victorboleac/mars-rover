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
}
