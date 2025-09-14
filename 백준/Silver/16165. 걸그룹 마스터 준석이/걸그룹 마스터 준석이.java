import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, TreeSet<String>> groupMap = new HashMap<>();
    private static Map<String, String> memberMap = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while(N-- > 0) {
		    String groupName = br.readLine();
		    int num = Integer.parseInt(br.readLine());
		    TreeSet<String> members = new TreeSet<>();
		    while(num-- > 0) {
		        String member = br.readLine();
		        members.add(member);
		        memberMap.put(member, groupName);
		    }
		    groupMap.put(groupName, members);
		} 
		while(M-- > 0) {
		    String input = br.readLine();
		    if (Integer.parseInt(br.readLine()) == 0) { // 그룹명으로 멤버 찾기
		        for (String member : groupMap.get(input)) {
		            sb.append(member).append("\n");
		        }
		    } else { // 멤버명으로 그룹 찾기
		        sb.append(memberMap.get(input)).append("\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}