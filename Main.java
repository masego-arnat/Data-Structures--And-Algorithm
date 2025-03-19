public class Main {
    public static void main(String[] args) {
        // Create a ServerNode instance
        ServerNode server = new ServerNode();

        // Create ClientNode instances and pass the server reference
        ClientNode client1 = new ClientNode("Client1", server);
        ClientNode client2 = new ClientNode("Client2", server);

        // Add clients to the server
        server.addClient(client1);
        server.addClient(client2);

        // Test sending a message from client1 to client2
        client1.sendMessage("Hello, Client2!", client2); // Expected output: "Message from Client1: Hello, Client2!"

        // Test sending a message to a non-existent client
        ClientNode client3 = new ClientNode("Client3", server);
        client1.sendMessage("Hello, Client3!", client3); // Expected output: "Receiver not found in the client list."
    }
} 