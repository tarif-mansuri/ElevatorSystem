package model;

import java.util.List;
import java.util.Queue;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private ElevatorStatus status;
    private Queue<Integer> requests;
    private WeightSensor weightSensor;
    private EmergencySystem emergencySystem;
    private Display display;
    private List<Button> buttons;

}
