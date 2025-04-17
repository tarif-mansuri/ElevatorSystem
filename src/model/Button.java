package model;

public abstract class Button {
    private Floor floor;
    public Button(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }
    public abstract Request press();
}
