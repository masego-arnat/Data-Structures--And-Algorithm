import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerNode {
    private String serverId;
    private List<ClientNode> connectedClients;
    private Map<String, ClientNode> clients; // Maps client ID to ClientNode object

    public ServerNode() {
        clients = new HashMap<>();
          this.connectedClients = new ArrayList<>();  // Initialize the list
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

    public String getServerDetails() {
        return "Server ID: " + serverId + ", Number of connected clients: " + connectedClients.size();
    }



}
