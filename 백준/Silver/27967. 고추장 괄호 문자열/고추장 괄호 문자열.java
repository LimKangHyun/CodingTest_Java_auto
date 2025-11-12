import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static char[] arr;
    private static String result = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		String input = br.readLine();
		arr = input.toCharArray();
		dfs(0);
		bw.write(result);
		bw.flush();
	}
	private static void dfs(int depth) {
	    if (result != null) return;
	    if (depth == N) {
	        if(isValid()) result = new String(arr);
	        return;
	    }
	    if (arr[depth] == 'G') {
	        arr[depth] = '(';
	        dfs(depth + 1);
	        arr[depth] = ')';
	        dfs(depth + 1);
	        arr[depth] = 'G';
	    }
	    else dfs(depth + 1);
	}
	private static boolean isValid() {
	    Stack<Character> stack = new Stack<>();
	    for (char c : arr) {
	        if (!stack.isEmpty() && c == ')' && stack.peek() == '(') stack.pop();
	        else stack.push(c);
	    }
	    return stack.isEmpty();
	}
}