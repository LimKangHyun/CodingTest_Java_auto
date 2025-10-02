import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) { 
		    arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        if (o1.length() != o2.length()) {
		            return o1.length() - o2.length();
		        } else {
		            int sum1 = 0;
		            int sum2 = 0;
		            for (int i = 0; i < o1.length(); i++) {
		                if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
		                    sum1 += o1.charAt(i) - 48;
		                }
		            } 
		            for (int i = 0; i < o2.length(); i++) {
		                if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
		                    sum2 += o2.charAt(i) - 48;
		                }
		            } 
		            if (sum1 != sum2) return sum1 - sum2;
		            else return o1.compareTo(o2);
		        }
		    }
		});
		for (int i = 0; i < N; i++) {
		    sb.append(arr[i]).append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
}