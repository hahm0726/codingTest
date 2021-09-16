package programmers;

/*
* 조이스틱 level2
*
* - 알파벳 A에서 A-Z 까지 도달할 수 있는 최소값을 diff 배열로 정의
* - up & down : name 각 자리의 알파벳과 A의 차이값을 인덱스로 하여 diff 값들을 모두 더해준다
* - left & right : A가 연속되는 길이가 중요  */

import java.util.Arrays;

public class Solution4 {

    public int solution(String name) {
        int[] diff = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int answer = 0;

        for(char c : name.toCharArray()){
            answer += diff[c-'A'];
        }

        for(int i=0;i<name.length();i++){

        }

        return answer;
    }


}
