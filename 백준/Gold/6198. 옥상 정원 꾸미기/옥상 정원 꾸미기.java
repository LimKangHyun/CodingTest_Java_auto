import java.io.*;
import java.util.*;

public class Main {
    private static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long answer = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
		    int building = Integer.parseInt(br.readLine());
		    while(!stack.isEmpty()) {
		        if (stack.peek() <= building) {
		            stack.pop();
		        } else {
		            break;
		        }
		    }
		    answer += stack.size();
		    stack.push(building);
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}