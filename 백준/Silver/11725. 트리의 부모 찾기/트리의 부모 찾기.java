import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visit;
    static int[] parent;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        } 
        visit = new boolean[N+1];
        parent = new int[N+1];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        } 
        bfs();
        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.write("\n");
        } 
        bw.flush();
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visit[1] = true;
        queue.offer(1);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < list.get(current).size(); i++) {
                if (!visit[list.get(current).get(i)]) {
                    visit[list.get(current).get(i)] = true;
                    parent[list.get(current).get(i)] = current;
                    queue.offer(list.get(current).get(i));
                }
            }
        }
    }
}