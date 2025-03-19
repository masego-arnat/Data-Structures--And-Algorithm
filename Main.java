public class Main {

    public static void main(String[] args) {
        ServerNode server = new ServerNode();

        // Create clients
        ClientNode clientA = new ClientNode("A", server);
        ClientNode clientB = new ClientNode("B", server);

        // Send messages with compression
        clientA.send("B", "Hello, B! How are you?");
        clientB.send("A", "Hey A, I'm good. How about you?");
    }

    // public static void main(String[] args) {
    // Star network = new Star();

    // // Add clients
    // network.insertNode("A");
    // network.insertNode("B");
    // network.insertNode("C");

    // // Get clients (not accessible directly, so let's recreate)
    // ClientNode clientA = new ClientNode("A", new ServerNode());
    // ClientNode clientB = new ClientNode("B", new ServerNode());

    // // Send message
    // clientA.send("B", "Hello, B!");
    // clientB.send("A", "Hey A, got your message.");
    // }

}