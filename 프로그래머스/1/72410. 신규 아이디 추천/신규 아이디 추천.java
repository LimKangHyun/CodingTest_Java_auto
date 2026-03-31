class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = Character.toLowerCase(new_id.charAt(i));
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                if (sb.length() > 0 && c == '.' && sb.charAt(sb.length() - 1) == '.') continue;
                sb.append(c);
            }
        }
        for (int i = 1; i < sb.length(); ) {
            if (sb.charAt(i) == '.' && sb.charAt(i - 1) == '.') sb.deleteCharAt(i);
            else i++;
        }
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0) sb.append('a');
        
        if (sb.length() > 15) {
            sb.setLength(15);
            if (sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        }
        while(sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }
}