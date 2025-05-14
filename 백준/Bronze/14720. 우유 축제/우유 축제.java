import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int count = 0;
        int milk = 0;
        for (int i = 0; i < N; i++) {
            int store = Integer.parseInt(input[i]);
            if (milk == store) {
                milk = milk + 1 == 3 ? 0 : milk + 1;
                count++;
            } 
        } 
        bw.write(String.valueOf(count));
        bw.flush();
    }
}