import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		boolean check = false;
		
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
		    if (input.charAt(i) == '<') {
		        check = true;
		        while(!stack.isEmpty()) {
		            sb.append(stack.pop());
		        }
		        sb.append(input.charAt(i));
		    } 
		    else if (input.charAt(i) == '>') {
		        check = false;
		        sb.append(input.charAt(i));
		    }
		    else if (check) {
		        sb.append(input.charAt(i));
		    }
		    else if (!check) {
		        if (input.charAt(i) == ' ') {
		            while(!stack.empty()) {
		                sb.append(stack.pop());
		            }
		            sb.append(input.charAt(i));
		        } else {
		            stack.push(input.charAt(i));
		        }
		    }
		} 
		while (!stack.empty()) {
		    sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.flush();
	}
}