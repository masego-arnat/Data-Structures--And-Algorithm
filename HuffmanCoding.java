import java.util.*;

class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left, right;
}

public class HuffmanCoding {
    private static HuffmanNode root; // Store the Huffman tree

    public static String compress(String message) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : message.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        root = buildTree(freqMap); // Store root for decompression
        
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);
        
        StringBuilder compressed = new StringBuilder();
        for (char c : message.toCharArray()) {
            compressed.append(huffmanCodes.get(c));
        }
        
        return compressed.toString();
    }

    public static String decompress(String compressedMessage) {
        if (root == null) {
            throw new IllegalStateException("Huffman tree is not built yet.");
        }
        return decompress(compressedMessage, root);
    }

    private static HuffmanNode buildTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.character = entry.getKey();
            node.frequency = entry.getValue();
            queue.add(node);
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode();
            parent.frequency = left.frequency + right.frequency;
            parent.left = left;
            parent.right = right;
            queue.add(parent);
        }
        
        return queue.poll();
    }

    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }
        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    public static String decompress(String compressedMessage, HuffmanNode root) {
        StringBuilder result = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : compressedMessage.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;
            if (current.left == null && current.right == null) {
                result.append(current.character);
                current = root;
            }
        }

        return result.toString();
    }
}
