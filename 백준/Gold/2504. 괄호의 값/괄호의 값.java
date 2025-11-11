import java.io.*;
import java.util.*;

public class Main {
    private static String input;
    private static int idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine();
		int result = 0;
		int temp = 1;
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
		    char c = input.charAt(i);
		    if (c == '(') {
		        stack.push(c);
		        temp *= 2;
	        } else if (c == ')') {
	            if (stack.isEmpty() || stack.peek() != '(') {
	                result = 0;
	                break;
	            }
	            if (input.charAt(i - 1) == '(') result += temp;
	            stack.pop();
	            temp /= 2;
	        } else if (c == '[') {
	            stack.push(c);
		        temp *= 3;
	        } else if (c == ']') {
	            if (stack.isEmpty() || stack.peek() != '[') {
	                result = 0;
	                break;
	            }
	            if (input.charAt(i - 1) == '[') result += temp;
	            stack.pop();
	            temp /= 3;
	        }
		}
		if (!stack.isEmpty()) result = 0;
		bw.write(String.valueOf(result));
		bw.flush();
	}
}