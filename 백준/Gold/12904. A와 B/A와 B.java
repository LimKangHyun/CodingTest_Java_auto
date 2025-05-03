import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		while(T.length() > S.length()) {
		    if (T.charAt(T.length() - 1) == 'A') {
		        T.deleteCharAt(T.length() - 1);
		    } else {
		        T.deleteCharAt(T.length() - 1);
		        T.reverse();
		    }
		}
		bw.write(T.toString().equals(S.toString()) ? "1" : "0"); 
		bw.flush();
	}
}