import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		
		int result = a * b * c;
		int num = 0;
		while(result > 0) {
		    num = result % 10;
		    arr[num]++;
		    result /= 10;
		}
		for (int i : arr) {
		    sb.append(i + "\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}