import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cycleLength = 0;
            int result = 1;
            
            if (a % 10 == 0 || a % 10 == 1 || a % 10 == 5 || a % 10 == 6) {
                result = a % 10;
            } else if (a % 10 == 4 || a % 10 == 9) {
                cycleLength = b % 2;
                if (cycleLength == 0) cycleLength = 2;
            } else {
                cycleLength = b % 4;
                if (cycleLength == 0) cycleLength = 4; 
            }
            
            for (int i = 0; i < cycleLength; i++) {
                result = (result * a) % 10;
            } 
            if (result == 0) result = 10;
            sb.append(result + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}