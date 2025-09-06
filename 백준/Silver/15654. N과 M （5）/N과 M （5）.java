import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        arr = new int[M];
        sb = new StringBuilder();
        
        dfs(0);
        bw.write(sb.toString());
        bw.flush();
    }
    
    private static void dfs(int depth) {
        if(depth == M) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
            
        }
    }
}