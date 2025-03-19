import java.util.HashMap;
import java.util.Map;

public class ServerNode {
    private Map<String, ClientNode> clients; // Maps client ID to ClientNode object

    public ServerNode() {
        clients = new HashMap<>();
    }

    public void registerClient(ClientNode client) {
        clients.put(client.getId(), client);
    }

    public void removeClient(String clientId) {
        clients.remove(clientId);
    }

    public void sendMessage(String senderId, String receiverId, String message) {
        if (clients.containsKey(receiverId)) {
            clients.get(receiverId).receive(senderId, message);
        } else {
            System.out.println("Client " + receiverId + " not found in network.");
        }
    }

    public boolean clientExists(String clientId) {
        return clients.containsKey(clientId);
    }
}
