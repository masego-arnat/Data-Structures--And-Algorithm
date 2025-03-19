import java.util.ArrayList;
import java.util.List;

public class Star {
    private ServerNode server;
    private List<ClientNode> clients;

    public Star() {
        // Purpose: It initializes the central server for the network. 
        // This server will be responsible for managing the communication between clients,
        //  including registering
        //  and removing clients, and possibly handling messages.
        server = new ServerNode();  // Create the central server
        // Purpose: This list will hold the ClientNode objects.
        //  Each client will be added to this list as the network grows,
        //  and the server will interact with these clients.
        clients = new ArrayList<>(); // Initialize the list of clients
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
