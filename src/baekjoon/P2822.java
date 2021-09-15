package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class P2822 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> m = new HashMap<>();
        Integer[] scores = new Integer[8];
        int totalScore = 0;
        int[] usedNum = new int[5];

        for(int i=0; i<8; i++){
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
            m.put(score,i+1);
        }

        Arrays.sort(scores, Collections.reverseOrder());

        for(int i=0; i<5; i++){
            totalScore += scores[i];
            usedNum[i] = m.get(scores[i]);
        }

        Arrays.sort(usedNum);
        System.out.println(totalScore);
        for(int i: usedNum){
            System.out.print(i +" ");
        }
        System.out.println();

    }
}
