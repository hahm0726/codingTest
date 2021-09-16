package programmers;

/*
* 베스트앨범
* - 많이 재생된 장르를 먼저 수록 => 각 장르별 재생회수를 알아야함
* - 장르 내에서 많이 재생된 노래 => 해당
* */

import java.util.HashMap;

public class Solution6 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genreCnt = new HashMap<>();
        for(String g : genres){
            if(!genreCnt.containsKey(g)) genreCnt.put(g,0);
            else genreCnt.put(g, genreCnt.get(g));
        }

        return answer;
    }
}
