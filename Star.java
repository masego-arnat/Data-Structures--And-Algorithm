import java.util.ArrayList;
import java.util.List;

public class Star {
    private ServerNode server;
    private List<ClientNode> clients;

    public Star() {
        server = new ServerNode();  // Create the central server
        clients = new ArrayList<>();
    }

    public ClientNode insertNode(String clientId) {
        ClientNode client = new ClientNode(clientId, server);  // Create client
        clients.add(client);
        return client;
    }

    public void deleteNode(String clientId) {
        clients.removeIf(client -> client.getId().equals(clientId));
        server.removeClient(clientId);
    }

    public ServerNode getServer() {
        return server;
    }

    public List<ClientNode> getClients() {
        return clients;
    }
}
