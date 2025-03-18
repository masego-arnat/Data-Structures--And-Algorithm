// ClientNode.java
public class ClientNode {
    private String id;
    private ServerNode server;

    public ClientNode(String id, ServerNode server) {
        this.id = id;
        this.server = server;
        server.addClient(this);
    }

    // Add this method to return the client's ID
    public String getId() {
        return id;
    }

    public void send(String message, ClientNode receiver) {
        server.sendMessage(this, message, receiver);
    }

    public void receive(String message, String senderId) {
        System.out.println("Client " + senderId + " sends: " + message);
    }
}