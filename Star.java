import java.util.ArrayList;
import java.util.List;

public class Star {
    private ServerNode server;
    private List<ClientNode> clients;

    public Star() {
        server = new ServerNode();
        clients = new ArrayList<>();
    }

    public void insertNode(String clientId) {
        clients.add(new ClientNode(clientId, server));
    }

    public void deleteNode(String clientId) {
        clients.removeIf(client -> client.getId().equals(clientId));
        server.removeClient(clientId);
    }
}
