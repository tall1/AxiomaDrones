package main.ground.control;

import main.Constants;

import java.util.Stack;

public class GroundControl {
    private final Stack<Integer> heights; // Stack of heights

    public GroundControl() {
        this.heights = new Stack<>();
        int curHeight = 10;
        for (int i = 0; i < Constants.HEIGHTS_AMOUNT; i++) {
            heights.push(curHeight);
            curHeight += 10;
        }
    }

    // When a drone wants to take off it calls this method.
    // Returns: -1 if there are no available heights or else the height that is allocated to the requesting drone.
    public int askForPermission() {
        if (heights.isEmpty()) {
            return -1;
        }
        return heights.pop();
    }

    // When a drone wants to land it declares landing and "frees" the allocated height.
    public void declareLanding(int height) {
        heights.push(height);
    }
}
