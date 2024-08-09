package au.felix.dev;

import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class GameWindow {

    // Add window attribute
    private long window;

    public GameWindow(final int[] dimensions, final String title) {
        createWindow(dimensions, title);
    }

    /**
     * Create a window
     *
     * @param dimensions width and height of the window
     * @param title      title of the window
     */
    private void createWindow(final int[] dimensions, final String title) {
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        this.window = glfwCreateWindow(dimensions[0], dimensions[1], title, 0, 0);
        if (this.window == 0)
            throw new IllegalStateException("Failed to create window");
        glfwMakeContextCurrent(this.window);
        // Add vidMode attribute
        final GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        //center the window
        if (vidMode != null)
            glfwSetWindowPos(this.window, (vidMode.width() - dimensions[0]) / 2, (vidMode.height() - dimensions[1]) / 2);
        else
            throw new IllegalStateException("Failed to get video mode");

        glfwShowWindow(this.window);
    }

    /**
     * Run the window
     */
    public void run() {
        while (!glfwWindowShouldClose(this.window)) {
            glfwPollEvents();
        }
        glfwTerminate();
    }

}
