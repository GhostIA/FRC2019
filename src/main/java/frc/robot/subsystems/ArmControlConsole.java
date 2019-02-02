package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class ArmControlConsole {

    private Joystick joystick;

    public static enum Action {
        NONE,
        ROCKET_LOW,
        ROCKET_UP,
        CARGO_LOW,
        CARGO_UP,
        LOADING_LOW,
        LOADING_UP
    }

    public ArmControlConsole(int port) {
        joystick = new Joystick(port);
    }

    public Action getNextAction() {
        int lastButtonPressed = lastButtonPressed();
        Action nextAction = Action.NONE;

        switch (lastButtonPressed) {
            case 1:
                nextAction = Action.ROCKET_LOW;
                break;
            case 2:
                nextAction = Action.ROCKET_UP;
                break;
            case 3:
                nextAction = Action.CARGO_LOW;
                break;
            case 4:
                nextAction = Action.LOADING_LOW;
                break;
            case 5:
                nextAction = Action.LOADING_UP;
                break;
            default:
                nextAction = Action.NONE;
        }

        return nextAction;
    }

    private int lastButtonPressed() {
        for(int i = 1 ; i <= 6 ; i++) {
            if(joystick.getRawButtonPressed(i)) {
                return i;
            }
        }

        return -1;
    }
}