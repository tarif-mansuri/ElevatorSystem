package model;

import java.util.List;

public class Controller {
    private List<Elevator> elevators;

    public Controller(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void assignRequest(Request request) {
        // Basic strategy: assign to first idle elevator
        for (Elevator elevator : elevators) {
            if (elevator.getCurrentFloor().getFloorNumber() == request.sourceFloor || request.isInternal) {
                elevator.addRequest(request.targetFloor);
                return;
            }
        }
    }
}
