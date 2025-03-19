public class Main {

    public static void main(String[] args) {

        Star network = new Star(); // Create the network

        // Insert nodes and get references
        ClientNode clientA = network.insertNode("A");
        ClientNode clientB = network.insertNode("B");

        // Send messages
        clientA.send("B", "Hello, B! How are you?");
        clientB.send("A", "Hey A, I'm good. How about you?");
        // The sender is clientB, as it is the one calling the send method.
        // Typically, send is a method used to send a message from one entity
        // (in this case, clientB) to another (in this case, "A").

        // // So, in this specific example, clientB is sending the message to "A".
        // If you wanted to programmatically track or refer to the sender, it would be
        // clientB.

        // Get the list of clients
        // List<ClientNode> clients = clientManager.getClients();

        // var tt = network.getClients();
        // // Iterate through the list and print the client details
        // for (ClientNode client : tt) {
        // System.out.println(client);
        // }
        network.deleteNode("A");
        // Print remaining clients
        System.out.println("After removal:");

        var tt = network.getClients();
        // Iterate through the list and print the client details along with server info
        for (ClientNode client : tt) {
            System.out.println(client);
        }

    }

}