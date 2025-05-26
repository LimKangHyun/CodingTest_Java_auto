import java.io.*;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;
        
        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
        
        @Override
        public int compareTo(Jewel j) {
            return this.weight - j.weight;
        }
    }
    private static int n, k;
    private static int[] bags;
    private static Jewel[] jewels;
    private static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bags = new int[k];
        jewels = new Jewel[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        bw.write(findMaxPrice() + "\n");
        bw.flush();
    }
    private static long findMaxPrice() {
        Arrays.sort(jewels);
        Arrays.sort(bags);
        int jewelIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int bagWeight : bags) {
            while(jewelIdx < n && jewels[jewelIdx].weight <= bagWeight) {
                pq.offer(jewels[jewelIdx].price);
                jewelIdx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            } 
        }
        return result;
    }
}