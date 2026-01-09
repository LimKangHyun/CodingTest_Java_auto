import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visitor = new int[N];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    visitor[i] = Integer.parseInt(st.nextToken());
		    if (i < X) sum += visitor[i];
		}
		int max = sum;
		int count = 1;
		for (int i = 1; i <= N - X; i++) {
		    int temp = sum - visitor[i - 1] + visitor[i + X - 1];
		    sum = temp;
		    if (temp > max) {
		        max = temp;
		        count = 1;
		    } else if (temp == max) count++;
		}
		if (max == 0) bw.write("SAD");
		else {
		    bw.write(String.valueOf(max));
		    bw.newLine();
		    bw.write(String.valueOf(count));
		}
		bw.flush();
	}
}