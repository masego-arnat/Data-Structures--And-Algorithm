// ConsoleLoader.java
public class ConsoleLoader {
    
    private static boolean isLoading = true;  // Flag to control the loading animation

    // Start the spinner animation in a separate thread
    public static void startSpinner() {
        String[] spinner = {"." , ".."}; // Spinner characters
        new Thread(() -> {
            while (isLoading) {
                for (String s : spinner) {
                    if (!isLoading) {
                        return;  // Exit the loop if the task is done
                    }
                    System.out.println("\rLoading " + s);
                    try {
                        Thread.sleep(100); // Sleep for 100ms to create animation
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // Stop the spinner animation
    public static void stopLoading() {
        isLoading = false;  // Stop the spinner animation
        System.out.print("\rTask Complete!   \n");
    }
}
