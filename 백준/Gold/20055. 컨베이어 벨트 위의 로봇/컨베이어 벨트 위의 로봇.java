import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static List<int[]> belt; // [내구도, 로봇유무]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt.add(new int[] {Integer.parseInt(st.nextToken()), 0});
        } 
        int stage = 0;
        int zeroCount = 0;
        while(zeroCount < K) {
            stage++;
            belt.add(0, belt.remove(belt.size() - 1));
            if (belt.get(N-1)[1] == 1) belt.get(N-1)[1] = 0; 
            for (int i = N - 2; i >= 0; i--) {
                if (belt.get(i)[1] == 1 && belt.get(i+1)[1] == 0 && belt.get(i+1)[0] >= 1) {
                    belt.get(i)[1]--;
                    belt.get(i+1)[1]++;
                    belt.get(i+1)[0]--;
                    if (belt.get(i+1)[0] == 0) zeroCount++; 
                }
            } 
            if (belt.get(N-1)[1] == 1) belt.get(N-1)[1] = 0; 
            if (belt.get(0)[1] == 0 && belt.get(0)[0] > 0) {
                belt.get(0)[1]++;
                belt.get(0)[0]--;
                if (belt.get(0)[0] == 0) zeroCount++; 
            } 
        }
        bw.write(String.valueOf(stage));
        bw.flush();
    }
}