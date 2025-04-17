package model;

public class Request {
    int sourceFloor;
    int targetFloor;
    boolean isInternal;
    Direction direction;

    public Request(int sourceFloor, int targetFloor, boolean isInternal, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.targetFloor = targetFloor;
        this.isInternal = isInternal;
        this.direction = direction;
    }
}
