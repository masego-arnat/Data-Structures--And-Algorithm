public class Main {

    public static void main(String[] args) {
        // Start the spinner loader
        ConsoleLoader.startSpinner();

        Star network = new Star(); // Create the network

        // Insert nodes and get references
        ClientNode clientA = network.insertNode("A");
        ClientNode clientB = network.insertNode("B");
        // ClientNode clientsA = network.insertNode("A");

        // Send messages
        clientA.send("B", "Hello, B! How are you?");
        clientB.send("A", "Hey A, I'm good. How about you?");
    
              

        System.out.println("==========================================");
        System.out.println("Before removal:");
        var tt = network.getClients();
        // Iterate through the list and print the client details along with server info
        for (ClientNode client : tt) {
            System.out.println(client);
            System.out.println(client.getId());
            System.out.println(client.getServerIddd());
        }
        System.out.println("==========================================");


        network.deleteNode("A");
        // Print remaining clients
        System.out.println("After removal:");

        // Iterate through the list and print the client details along with server info
        for (ClientNode client : tt) {
            System.out.println(client);
            System.out.println(client.getId());
            System.out.println(client.getServerIddd());
            
        }

        // After the task is done, stop the loading animation
        ConsoleLoader.stopLoading();

    }

}