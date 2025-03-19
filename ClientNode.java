public class ClientNode {
    private String id;
    private ServerNode server;
    // private HuffmanCoding huffman; // Huffman Coding instance

    public ClientNode(String id, ServerNode server) {
        this.id = id;
        this.server = server;
        // this.huffman = new HuffmanCoding(); // Initialize Huffman Coding
        server.registerClient(this);
    }

    public String getId() {
        return id;
    }

    // public void send(String receiverId, String message) {
 
    //     String compressedMessage = HuffmanCoding.compress(message); // Call it statically
    //     System.out.println("Sending compressed message: " + compressedMessage);
    //     server.sendMessage(this.id, receiverId, compressedMessage);
    // }
    public void send(String receiverId, String message) {
        // Check if receiver exists in the server
        if (!server.clientExists(receiverId)) {
            System.out.println("Error: Client " + receiverId + " does not exist in the network.");
            return; // Stop execution if client doesn't exist
        }
    
        // Compress message
        String compressedMessage = HuffmanCoding.compress(message);
        System.out.println("Sending compressed message: " + compressedMessage);
    
        // Send message via server
        server.sendMessage(this.id, receiverId, compressedMessage);
    }
    

    public void receive(String senderId, String compressedMessage) {
        String decompressedMessage = HuffmanCoding.decompress(compressedMessage); // Decompress message
        System.out.println("Message from " + senderId + " to " + id + ": " + decompressedMessage);
    
    }
}
