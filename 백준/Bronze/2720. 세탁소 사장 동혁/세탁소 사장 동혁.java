import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int quarter = 25;  //쿼터 0.25$
        int dime = 10;  //다임 0.10$
        int nickel = 5;  //니켈 0.05$
        int penny = 1;  //페니 0.01$
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            sb.append(c / quarter + " ");
            c %= quarter;
            sb.append(c / dime + " ");
            c %= dime;
            sb.append(c / nickel + " ");
            c %= nickel;
            sb.append(c / penny + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}