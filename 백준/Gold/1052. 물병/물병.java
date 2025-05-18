import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		int count = 0;
		while(Integer.bitCount(n) > k) {
		    count += n & (-n);
		    n += n & (-n);
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}