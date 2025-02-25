import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        } 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        } 
        
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        List<Integer> truth = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        } 

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int participate = Integer.parseInt(st.nextToken());
            for (int j = 0; j < participate; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            } 
            for (int j = 0; j < parties[i].size(); j++) {
                union(parties[i].get(0), parties[i].get(j));
            } 
        }
        
        Set<Integer> truthRoot = new HashSet<>();
        for(int t : truth) {
            truthRoot.add(find(t));
        }
        int result = 0;
        for (List<Integer> party : parties) {
            boolean lieParty = true;
            for(int i : party) {
                if (truthRoot.contains(find(i))) {
                    lieParty = false;
                    break;
                }
            }
            if (lieParty) {
                result++;
            }
        } 
        bw.write(String.valueOf(result));
        bw.flush();
    }
}