package model;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public List<Elevator> elevators;
    private Controller controller;

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i, 1000));
        }
        controller = new Controller(elevators);
    }

    public void handleRequest(Request request) {
        controller.assignRequest(request);
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }
}
