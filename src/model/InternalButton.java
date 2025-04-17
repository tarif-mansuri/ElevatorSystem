package model;

public class InternalButton extends Button {
    Elevator elevator;

    public InternalButton(int floor, Elevator elevator) {
        super(floor);
        this.elevator = elevator;
    }

    @Override
    public Request press() {
        return new Request(elevator.getCurrentFloor(), getFloor(), true, elevator.getDirection());
    }
}
