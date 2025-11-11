import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String input = br.readLine();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
		    char c = input.charAt(i);
		    if (c == '(') {
	            stack.push(c);
	        } else {
	            if (!stack.isEmpty() && stack.peek() == '(') {
	                stack.pop();
	            } else stack.push(c);
	        }
		}
		System.out.println(stack.size());
	}
}