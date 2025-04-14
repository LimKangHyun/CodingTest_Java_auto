import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
		    String command = br.readLine();
		    int N = Integer.parseInt(br.readLine());
		    Deque<Integer> deq = new ArrayDeque<>();
		    String input = br.readLine();
		    input = input.replace("[", "").replace("]","");
		    String[] arr = input.split(",");
		    for (int i = 0; i < N; i++) {
		        deq.offer(Integer.parseInt(arr[i]));
		    }
		    boolean isError = false;
		    boolean isReversed = false;
		    for (char c : command.toCharArray()) {
		        if (c == 'R') {
		            isReversed = !isReversed;
		        } else if(c == 'D') {
		            if (deq.isEmpty()) {
		                sb.append("error\n");
		                isError = true;
		                break;
		            }
		            if (!isReversed) deq.pollFirst();
		            else deq.pollLast();
		        }
		    }
		    if (!isError) {
		        sb.append("[");
		        while(!deq.isEmpty()) {
		            sb.append(isReversed ? deq.pollLast() : deq.pollFirst());
		            if (!deq.isEmpty()) sb.append(","); 
		        }
		        sb.append("]\n");
		    } 
		}
		bw.write(sb.toString());
		bw.flush();
	}
}