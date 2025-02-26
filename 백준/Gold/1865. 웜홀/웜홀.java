import java.io.*;
import java.util.*;

public class Main {
    static List<int []> list;
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
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (i < M) {
                    list.add(new int[] {s,e,t});
                    list.add(new int[] {e,s,t});
                } else {
                    list.add(new int[] {s,e,-t});
                }
            }
            for (int i = 1; i <= N; i++) {
                list.add(new int[] {0, i, 0});
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
        for (int i = 0; i < N; i++) {//모든 최단경로 계산
            for (int[] node : list) {
                int start = node[0];
                int end = node[1];
                int time = node[2];
                if (dist[start] != INF && dist[end] > dist[start] + time) {
                    dist[end] = dist[start] + time;
                }
            } 
        } 
        for (int[] node : list) { //한번 더 계산했을 때, 최단경로가 변경된다면 음수사이클 존재
            int start = node[0];
            int end = node[1];
            int time = node[2];
            if (dist[start] != INF && dist[end] > dist[start] + time) {
                return true;
            }
        }
        return false;
    }
}