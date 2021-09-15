package programmers;

/*
 * 프로그래머스 Level3 단어변환
 * backtracking 방식을 사용해 풀수 있었음
 * */

public class Solution2 {

    int minimum;
    boolean[] visited;

    public void backtracking(String cur, int cnt, String target, String[] words){
        if(cur.equals(target)){
            if(cnt<minimum) minimum = cnt;
            return ;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            if (!canChange(cur, words[i])) continue;
            visited[i] = true;
            backtracking(words[i],cnt+1,target,words);
            visited[i] = false;
        }

    }

    public boolean canChange(String str1, String str2){
        int cnt=0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        minimum = words.length+1;

        backtracking(begin,0,target,words);

        if(minimum == words.length+1) minimum=0;
        return minimum;
    }
}
