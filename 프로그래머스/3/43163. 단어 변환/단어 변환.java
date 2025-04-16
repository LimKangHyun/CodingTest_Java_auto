import java.util.*;

class Case {
    String word;
    int count;
    
    Case(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    private static int bfs(String begin, String target, String[] words) {
        Queue<Case> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];
        queue.offer(new Case (begin, 0));
        
        while(!queue.isEmpty()) {
            Case current = queue.poll();
            String word = current.word;
            int count = current.count;
            
            if(word.equals(target)) return count;
            
            for(int i = 0; i < words.length; i++) {
                if(!visit[i]) {
                    int correct = 0;
                    for(int j = 0; j < word.length(); j++) {
                        if(word.charAt(j) == words[i].charAt(j)) {
                            correct++;
                        }
                    }
                    if(correct == word.length() - 1) {
                        queue.offer(new Case(words[i], count+1));
                        visit[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}