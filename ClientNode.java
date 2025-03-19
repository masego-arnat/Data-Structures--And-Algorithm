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
    public String getServerIddd() {
        return server.toString();
    }

    // public void send(String receiverId, String message) {

    // String compressedMessage = HuffmanCoding.compress(message); // Call it
    // statically
    // System.out.println("Sending compressed message: " + compressedMessage);
    // server.sendMessage(this.id, receiverId, compressedMessage);
    // }
    public void send(String receiverId, String message) {

        // Send message via server
        server.sendMessage(this.id, receiverId, message);
    }

    // public void receive(String senderId, String compressedMessage) {
    //     String decompressedMessage = HuffmanCoding.decompress(compressedMessage); // Decompress message
    //     System.out.println("Decompressing  Message " + compressedMessage);
    //     System.out.println("Message from " + senderId + " to " + id + ": " + decompressedMessage);

    // }

    // Receive the decompressed message from the server
    public void receiveDecompressedMessage(String senderId ,String receiverId,  String decompressedMessage) {
       System.out.println("==========================================");
        System.out.println("Client " +  receiverId + " received decompressed message: " + decompressedMessage+" from: " + senderId);
    }


    // Optionally, if you need a detailed server output for the client
    public String getClientDetails() {
        return "Client ID: " + id + ", Server: " + server.getServerDetails();
    }

}
