import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int score;
        Node next;
        Node shortcut;
        // Node의 score 초기화
        Node(int score) {
            this.score = score;
        }
    }
    private static Node start;
    private static int[] dice = new int[10];
    private static Node[] horses = new Node[4];
    private static boolean[] finished = new boolean[4]; // 말의 도착 표시
    private static int maxScore = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 10; i++) {
		    dice[i] = Integer.parseInt(st.nextToken());
		}
		buildBoard();
		for (int i = 0; i < 4; i++) {
            horses[i] = start;
        }
		dfs(0, 0);
		bw.write(String.valueOf(maxScore));
		bw.flush();
	}
	private static void dfs(int depth, int score) {
	    if (depth == 10) {
	        maxScore = Math.max(maxScore, score);
	        return;
	    } 
	    for (int i = 0; i < 4; i++) {
	        if (finished[i]) continue;
	        
	        Node curr = horses[i];
	        Node next = move(curr, dice[depth]);
	        // 말이 도착을 안했고(next != null) && 겹치는 말이 존재한다면 해당 말은 이동 불가
	        if (next != null && isOverlap(i, next)) continue;
	        horses[i] = next;
	        if (next == null) { // 말이 도착한 경우 (next가 null이면 도착임)
	            finished[i] = true;
	            dfs(depth+1, score);
	            finished[i] = false;
	        } else {
	            dfs(depth+1, score + next.score);
	        }
	        horses[i] = curr;
	    } 
	}
	private static boolean isOverlap(int idx, Node curr) {
	    for (int i = 0; i < 4; i++) {
	        // 노드 자신인경우 || 말이 도착한 경우는 제외
	        if (i == idx || horses[i] == null) continue;
	        if (horses[i] == curr) return true; 
	    } 
	    return false;
	}
	private static Node move(Node node, int dist) {
	    Node curr = node;
	    if (curr == null) return null;
	    if (curr.shortcut != null) {
	        curr = curr.shortcut;
	        dist--;
	    } 
	    while(dist-- > 0) {
	        if (curr.next == null) return null;
	        curr = curr.next;
	    }
	    return curr;
	}
	private static void buildBoard() {
	    start = new Node(0);
	    Node curr = start;
	    for (int i = 2; i <= 40; i += 2) {
	        curr.next = new Node(i);
	        curr = curr.next; // 출발부터 점수 40 노드까지 연결
	    } 
	    Node end = new Node(0);
	    curr.next = end; // 도착지 노드 연결
	    
	    Node node25 = new Node(25);
	    Node node30 = new Node(30);
	    Node node35 = new Node(35);
	    Node node40 = getNode(start, 40);
	    
	    node25.next = node30;
	    node30.next = node35;
	    node35.next = node40;
	    
	    // 점수 10 노드의 지름길
	    Node ten = getNode(start, 10);
	    Node shortcut1 = new Node(13);
	    shortcut1.next = new Node(16);
	    shortcut1.next.next = new Node(19);
	    shortcut1.next.next.next = node25;
	    ten.shortcut = shortcut1;
	    
	    // 점수 20 노드의 지름길
	    Node twenty = getNode(start, 20);
	    Node shortcut2 = new Node(22);
	    shortcut2.next = new Node(24);
	    shortcut2.next.next = node25;
	    twenty.shortcut = shortcut2;
	    
	    // 점수 30 노드의 지름길
	    Node thirty = getNode(start, 30);
	    Node shortcut3 = new Node(28);
	    shortcut3.next = new Node(27);
	    shortcut3.next.next = new Node(26);
	    shortcut3.next.next.next = node25;
	    thirty.shortcut = shortcut3;
	}
	// buildBoard()로 만들어진 특정 점수 노드 찾기
	private static Node getNode(Node start, int score) {
	    Node curr = start;
	    while(curr != null) {
	        if (curr.score == score) return curr;
	        curr = curr.next;
	    }
	    return null;
	}
}