import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 학생 수
        int M = Integer.parseInt(input[1]); // 키 비교횟수
        List<Integer>[] graph = new ArrayList[N+1];
        int[] inDegree = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } 
        
        for(int i = 0; i < M; i++) {
            String[] versus = br.readLine().split(" ");
            int a = Integer.parseInt(versus[0]);
            int b = Integer.parseInt(versus[1]);
            graph[a].add(b);
            inDegree[b]++;
        }
        topologySort(N, graph, inDegree);
        bw.write(sb.toString());
        bw.flush();
    }
    private static void topologySort(int N, List<Integer>[] graph, int[] inDegree) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            } 
        }
        while(!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current + " ");
            for (int next : graph[current]) {
                if(--inDegree[next] == 0) {
                    pq.offer(next);
                }
            } 
        }
    }
}