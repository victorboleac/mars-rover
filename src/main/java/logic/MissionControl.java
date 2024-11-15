package logic;

import java.util.ArrayList;
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
