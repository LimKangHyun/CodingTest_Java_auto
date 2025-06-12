import java.io.*;
import java.util.*;
 
public class Main {
    static class Node{
        HashMap<String, Node> child;
        public Node() {
            child = new HashMap<>();
        }
    }
    private static int n;
    private static Node root = new Node();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = root;
            for (int j = 0; j < k; j++) {
                String word = st.nextToken();
                if (!cur.child.containsKey(word)) {
                    cur.child.put(word, new Node());
                }
                cur = cur.child.get(word);
            } 
        } 
        print(root, "");
        bw.write(sb.toString());
        bw.flush();
    }
    private static void print(Node cur, String s) {
        // 현재 노드의 자식 키(단어)들 집합
        ArrayList<String> list = new ArrayList<>(cur.child.keySet());
        Collections.sort(list);
        for (String str : list) {
            sb.append(s).append(str).append("\n");
            print(cur.child.get(str), s + "--");
        } 
        
    }
}