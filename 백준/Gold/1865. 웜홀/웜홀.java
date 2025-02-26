import java.io.*;
import java.util.*;

class Node {
    int target;
    int time;
    
    Node(int target, int time) {
        this.target = target;
        this.time = time;
    }
}
public class Main {
    static List<List<Node>> list;
    static int N;
    static int dist[];
    private static final int INF = 500 * 10_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            } 
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (i < M) {
                    list.get(s).add(new Node(e, t));
                    list.get(e).add(new Node(s, t));
                } else {
                    list.get(s).add(new Node(e, -t));
                }
            }
            if (bellmanFord()) {
                bw.write(String.valueOf("YES\n"));
            } else {
                bw.write(String.valueOf("NO\n"));
            }
        } 
        bw.flush();
    }
    private static boolean bellmanFord() {
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        boolean check = false;
        for (int i = 0; i < N; i++) {//모든 최단경로 계산
            check = false;
            for(int j = 1; j <= N; j++) {
                for (Node node : list.get(j)) {
                    if (dist[node.target] > dist[j] + node.time) {
                        dist[node.target] = dist[j] + node.time;
                        check = true;
                    }
                } 
            }
            if(!check) {
                break;
            }
        } 
        if(check) {
            for (int j = 1; j <= N; j++) {
                for (Node node : list.get(j)) { //한번 더 계산했을 때, 최단경로가 변경된다면 음수사이클 존재
                    if (dist[node.target] > dist[j] + node.time) {
                        return true;
                    }
                }
            } 
        }
        return false;
    }
}