// ClientNode.java
public class ClientNode {
    private String id;
    private ServerNode serverNode;

    public ClientNode(String id, ServerNode serverNode) {
        this.id = id;
        this.serverNode = serverNode;
    }

    // Add this method to return the client's ID
    public String getId() {
        return id;
    }

    public void sendMessage(String message, ClientNode receiver) {
        serverNode.sendMessage(this, message, receiver);
    }

    public void receive(String message, String senderId) {
        System.out.println("Message from " + senderId + ": " + message);
    }
}