import java.io.*;
import java.util.*;

class Player {
    String nickname;
    int level;
    
    public Player(String nickname, int level) {
        this.nickname = nickname;
        this.level = level;
    }
}
class Room {
    int capacity;
    int minLevel;
    int maxLevel;
    List<Player> players;
    
    public Room(int capacity, Player first) {
        this.capacity = capacity;
        this.minLevel = first.level - 10;
        this.maxLevel = first.level + 10;
        this.players = new ArrayList<>();
        this.players.add(first);
    }
}
public class Main {
    static List<Room> rooms;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Room> rooms = new ArrayList<>();
		
		for (int i = 0; i < p; i++) {
		    st = new StringTokenizer(br.readLine());
		    int level = Integer.parseInt(st.nextToken());
		    String nickname = st.nextToken();
		    Player player = new Player(nickname, level);
		    
		    boolean isJoined = false;
		    for (Room room : rooms) {
		        if (room.players.size() < m && level >= room.minLevel && level <= room.maxLevel) {
		            room.players.add(player);
		            isJoined = true;
		            break;
		        }
		    }
		    if (!isJoined) {
		        rooms.add(new Room(m, player));
		    }
		}
		for (Room room : rooms) {
		    sb.append(room.players.size() == m ? "Started!" : "Waiting!" ).append("\n");
		    Collections.sort(room.players, Comparator.comparing(a -> a.nickname));
		    for (Player player : room.players) {
		        sb.append(player.level).append(" ").append(player.nickname).append("\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}