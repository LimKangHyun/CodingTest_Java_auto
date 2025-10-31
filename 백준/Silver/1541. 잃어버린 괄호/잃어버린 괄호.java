import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        char standard = '+';
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-') {
                standard = '-';
            }
            
            if(input.charAt(i) == '+' && standard == '-') {
                sb.append(' ').append('-');
            } else {
                if(input.charAt(i) == '+' || input.charAt(i) == '-') {
                    sb.append(' ').append(input.charAt(i));    
                } else {
                    sb.append(input.charAt(i));    
                }
            }
        }
        int result = 0;
        StringTokenizer st = new StringTokenizer(sb.toString());
        while(st.hasMoreTokens()) {
            result += Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}