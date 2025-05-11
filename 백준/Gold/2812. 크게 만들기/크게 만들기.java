import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		String num = br.readLine();
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
		    while(!stack.isEmpty() && count < K && stack.peek() < num.charAt(i)) {
		        stack.pop();
		        count++;
		    }
		    stack.push(num.charAt(i));
		} 
		while(stack.size() != N - K) stack.pop();
		for (int i = 0; i < N - K; i++) {
		    sb.append(stack.pop());
		} 
		bw.write(sb.reverse().toString());
		bw.flush();
	}
}