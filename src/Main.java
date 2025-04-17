import model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            ElevatorSystem system = new ElevatorSystem(3);

            Request r1 = new ExternalButton(2, Direction.UP).press();
            system.handleRequest(r1);

            Request r2 = new InternalButton(5, system.elevators.get(0)).press();
            system.handleRequest(r2);

            for (int i = 0; i < 5; i++) {
                system.step();
            }

    }
}