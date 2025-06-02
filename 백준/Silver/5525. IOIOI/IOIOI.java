import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		for (int i = 0; i < n; i++) {
		    sb.append("IO");
		} 
		sb.append("I");
		
		String st = sb.toString();
		int count = 0;
		for (int i = 0; i <= m - st.length(); i++) {
		    if (input.substring(i, i+st.length()).equals(st)) {
		        count++;
		    } 
		} 
		bw.write(count + "\n");
		bw.flush();
	}
}