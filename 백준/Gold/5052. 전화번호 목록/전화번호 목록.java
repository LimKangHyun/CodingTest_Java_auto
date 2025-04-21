import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }
    
    static class Trie {
        TrieNode root = new TrieNode();
        
        public boolean insert(String number) {
            TrieNode node = root;
            for (char c : number.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                } 
                node = node.children.get(c);
                if (node.isEnd) {
                    return false;
                } 
            } 
            node.isEnd = true;
            return true;
        }
    }
	public static void main(String[] args) throws IOException {
	    StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    String[] numbers = new String[n];
		    for (int i = 0; i < n; i++) {
		        numbers[i] = br.readLine();
		    } 
		    Arrays.sort(numbers);
		    
		    Trie trie = new Trie();
		    boolean isConsistent = true;
		    for (String num : numbers) {
		        if(!trie.insert(num)) {
		            isConsistent = false;
		            break;
		        }
		    } 
		    sb.append(isConsistent ? "YES\n" : "NO\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}