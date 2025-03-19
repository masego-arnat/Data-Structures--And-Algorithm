import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clients;

    public ServerNode() {
        clients = new ArrayList<>();
    }

    public void addClient(ClientNode client) {
        clients.add(client);
    }

    public void removeClient(ClientNode client) {
        clients.remove(client);
    }

    public void sendMessage(ClientNode sender, String message, ClientNode receiver) {
        if (clients.contains(receiver)) {
            receiver.receive(message, sender.getId());
        } else {
            System.out.println("Receiver not found in the client list.");
        }
    }
}
