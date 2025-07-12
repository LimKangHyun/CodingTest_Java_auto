import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
		    trucks.offer(Integer.parseInt(st.nextToken()));
		} 
		for (int i = 0; i < w; i++) {
		    bridge.offer(0);
		}
		int time = 0;
		int bridgeWeight = 0;
		while(!bridge.isEmpty()) {
		    time++;
		    bridgeWeight -= bridge.poll();
		    if (!trucks.isEmpty()) {
		        if (trucks.peek() + bridgeWeight <= L) {
		            bridgeWeight += trucks.peek();
		            bridge.offer(trucks.poll());
		        } else {
		            bridge.offer(0);
		        }
		    } 
		}
		bw.write(String.valueOf(time));
		bw.flush();
	}
}