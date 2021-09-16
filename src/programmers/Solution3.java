package programmers;

/* 프로그래머스 Level1 체육복
* */

import java.util.Arrays;

public class Solution3 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] have = new int[n+1];

        Arrays.fill(have,1);

        for(int l : lost){
            have[l]--;
        }

        for(int r : reserve){
            have[r]++;
        }

        for(int r : reserve){
            if(r-1 >0 && have[r]==2){
                if(have[r-1] == 0){
                    have[r-1]=1;
                    have[r]=1;
                }
            }
            if(r+1<=n && have[r]==2){
                if(have[r+1] ==0){
                    have[r-1]=1;
                    have[r]=1;
                }
            }
        }

        int noHave = 0;
        for(int h : have){
            if(h == 0){
                noHave++;
            }
        }

        int answer = n-noHave;
        return answer;
    }
}
