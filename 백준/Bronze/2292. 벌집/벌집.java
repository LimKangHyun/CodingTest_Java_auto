import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int count = 1;
		int result = 1;
		while (true) {
		    if (result >= n) break;
		    result += 6 * count;
		    count++;
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}