import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[8][2];
		for (int i = 0; i < 8; i++) {
		    arr[i][0] = Integer.parseInt(br.readLine());
		    arr[i][1] = i;
		} 
		Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[0]).reversed());
		int sum = 0;
		int[] temp = new int[5];
		sb.append("\n");
		for (int i = 0; i < 5; i++) {
		    sum += arr[i][0];
		    temp[i] = arr[i][1];
		} 
		Arrays.sort(temp);
		bw.write(String.valueOf(sum));
		for (int i = 0; i < 5; i++) {
		    sb.append(temp[i] + 1).append(" ");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}