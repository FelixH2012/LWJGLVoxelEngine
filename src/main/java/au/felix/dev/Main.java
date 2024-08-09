package au.felix.dev;

import org.lwjgl.glfw.GLFW;

public class Main {

    public static GameWindow window;

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        if (!GLFW.glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW library");
        window = new GameWindow(new int[]{1600, 800}, "Voxel Test");
        window.run();
    }

}
