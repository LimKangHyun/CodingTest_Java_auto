import java.io.*;
import java.util.*;

public class Main {
    static class Truck {
        int weight;
        int dist;
        public Truck(int weight, int bridgeLen) {
            this.weight = weight;
            this.dist = bridgeLen;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] trucks = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    trucks[i] = Integer.parseInt(st.nextToken());
		} 
		Queue<Truck> bridge = new LinkedList<>();
		int time = 0;
		int index = 0;
		int bridgeWeight = 0;
		while(index < n || !bridge.isEmpty()) {
		    time++;
		    if (!bridge.isEmpty() && bridge.peek().dist == 1) {
		        bridgeWeight -= bridge.poll().weight;
		    } 
		    for (Truck t : bridge) {
		        t.dist--;
		    } 
		    if (index < n && bridgeWeight + trucks[index] <= L && bridge.size() < w) {
		        bridge.add(new Truck(trucks[index], w));
		        bridgeWeight += trucks[index];
		        index++;
		    } 
		}
		bw.write(String.valueOf(time));
		bw.flush();
	}
}