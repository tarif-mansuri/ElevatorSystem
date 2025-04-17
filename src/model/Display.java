package model;

public class Display {
    public void showStatus(Floor floor, Direction direction, ElevatorStatus elevatorStatus) {
        System.out.print("Floor " + floor+" Direction " + direction+" Elevator Status " + elevatorStatus);
    }
}
