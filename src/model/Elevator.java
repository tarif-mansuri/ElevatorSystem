package model;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private int id;
    private Floor currentFloor;
    private Direction direction;
    private ElevatorStatus status;
    private Queue<Integer> requestQueue;
    private WeightSensor weightSensor;
    private EmergencySystem emergencySystem;
    private Display display;
    private List<Button> buttons;

    public Elevator(int id, float maxWeight) {
        this.id = id;
        currentFloor = new Floor(0);
        requestQueue = new PriorityQueue<>();
        emergencySystem = new EmergencySystem();
        this.weightSensor = new WeightSensor(maxWeight);
        this.emergencySystem = new EmergencySystem();
        this.display = new Display();
    }
    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
    public void addRequest(int floor){
        requestQueue.add(floor);
    }

    public void openDoor() {
        System.out.println("Elevator " + id + " door opened at floor " + currentFloor);
    }

    public void closeDoor() {
        System.out.println("Elevator " + id + " door closed at floor " + currentFloor);
    }

    public void move() {
        if (status == ElevatorStatus.MAINTENANCE || status == ElevatorStatus.EMERGENCY) return;
        if (weightSensor.isOverLoaded()) {
            System.out.println("Elevator " + id + " is overloaded.");
            return;
        }
        if (requestQueue.isEmpty()) {
            status = ElevatorStatus.IDLE;
            direction = Direction.IDLE;
            display.showStatus(currentFloor, direction, status);
            return;
        }

        int nextFloorNumber = requestQueue.poll();
        direction = nextFloorNumber > currentFloor.getFloorNumber() ? Direction.UP : Direction.DOWN;
        status = ElevatorStatus.MOVING;

        System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to " + nextFloorNumber);
        currentFloor = new Floor(nextFloorNumber);

        openDoor();
        display.showStatus(currentFloor, direction, status);
        closeDoor();

        status = ElevatorStatus.IDLE;
        direction = Direction.IDLE;
    }

    public void triggerEmergency() {
        status = ElevatorStatus.EMERGENCY;
        emergencySystem.emergencyStop();
    }

    public void setMaintenance(boolean value) {
        status = value ? ElevatorStatus.MAINTENANCE : ElevatorStatus.IDLE;
    }

}
