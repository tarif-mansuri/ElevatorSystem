package model;

public class ExternalButton extends Button {
    private Direction direction;

    public ExternalButton(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    @Override
    public Request press() {
        return new Request(getFloor(), -1, false, direction);
    }
}
