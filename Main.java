public class Main {

    public static void main(String[] args) {

        Star network = new Star();  //  Create the network

        //  Insert nodes and get references
        ClientNode clientA = network.insertNode("A");
        ClientNode clientB = network.insertNode("Bx");
    

        //  Send messages 
        clientA.send("j", "Hello, B! How are you?");
        clientB.send("A", "Hey A, I'm good. How about you?");
        // The sender is clientB, as it is the one calling the send method. 
        // Typically, send is a method used to send a message from one entity
        //  (in this case, clientB) to another (in this case, "A").

        // // So, in this specific example, clientB is sending the message to "A". 
        // If you wanted to programmatically track or refer to the sender, it would be clientB.




 
    }

 
 

}