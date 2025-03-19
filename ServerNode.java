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
        this.connectedClients = new ArrayList<>(); // Initialize the list
    }

    public void registerClient(ClientNode client) {
        clients.put(client.getId(), client);
    }

    public void removeClient(String clientId) {
        clients.remove(clientId);
    }

    public void sendMessage(String senderId, String receiverId, String message) {
        // // Check if receiver exists in the server
        // if (!server.clientExists(receiverId)) {
        // System.out.println("Error: Client " + receiverId + " does not exist in the
        // network.");
        // return; // Stop execution if client doesn't exist
        // }

        if (clients.containsKey(receiverId)) {
            // Compress message
            String compressedMessage = HuffmanCoding.compress(message);
            System.out.println("Sending compressed message: " + compressedMessage +" "+ "To"  +" "+ receiverId);
            receive(senderId,receiverId, compressedMessage);
        } else {
            System.out.println("Client " + receiverId + " not found in network.");
        }
    }

    // public void receiveMessage(String senderId, String receiverId, String message) {
   
    //     if (clients.containsKey(receiverId)) {
    //         // Compress message
    //         String compressedMessage = HuffmanCoding.compress(message);
    //         System.out.println("Sending compressed message: " + compressedMessage +" "+ "To"  +" "+ receiverId);
    //         clients.get(receiverId).receiveDecompressedMessage(senderId, compressedMessage);
    //     } else {
    //         System.out.println("Client " + receiverId + " not found in network.");
    //     }
    // }

    public boolean clientExists(String clientId) {
        return clients.containsKey(clientId);
    }

    public String getServerDetails() {
        return "Server ID: " + serverId + ", Number of connected clients: " + connectedClients.size();
    }


    public void receive(String senderId,String receiverId, String compressedMessage) {
        // Decompress the received message
        String decompressedMessage = HuffmanCoding.decompress(compressedMessage);

        // Log the received and decompressed message
        System.out.println("Server received message from client " + senderId);
        System.out.println("Compressed Message: " + compressedMessage);
        // System.out.println("Decompressed Message: " + decompressedMessage);

     
        // I want to print or return this message to the client
        ClientNode sender = clients.get(senderId);
        if (sender != null) {
            sender.receiveDecompressedMessage(senderId,receiverId, decompressedMessage);
        }
    }

    // // Method to handle message back to the client
    // public void sendDecompressedMessageToClient(String clientId, String decompressedMessage) {
    //     ClientNode client = clients.get(clientId);
    //     if (client != null) {
    //         client.receiveDecompressedMessage(clientId,decompressedMessage);
    //     }
    // }

}
