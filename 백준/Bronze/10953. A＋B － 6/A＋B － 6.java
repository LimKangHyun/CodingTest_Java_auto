import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
		    String[] input = br.readLine().split(",");
		    int a = Integer.parseInt(input[0]);
		    int b = Integer.parseInt(input[1]);
		    sb.append(a + b).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}