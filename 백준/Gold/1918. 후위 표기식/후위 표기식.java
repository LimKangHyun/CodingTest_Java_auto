import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        Stack<Character> oper = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        char[] c = new char[input.length()];
        for (int i = 0; i < c.length; i++) {
            c[i] = input.charAt(i);
            switch(c[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!oper.isEmpty() && precedence(oper.peek()) >= precedence(c[i])) {
                        sb.append(oper.pop());
                    }
                    oper.push(c[i]);
                    break;
                case '(':
                    oper.push('(');
                    break;
                case ')':
                    while(!oper.isEmpty() && oper.peek() != '(') {
                        sb.append(oper.pop());
                    }
                    oper.pop();
                    break;
                default:
                    sb.append(c[i]);
            }
        } 
        while(!oper.isEmpty()) {
            sb.append(oper.pop());
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else if (op == '(' || op == ')') {
            return 0;
        } else {
            return -1;
        }
    }
}