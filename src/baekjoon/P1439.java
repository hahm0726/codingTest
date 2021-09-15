package baekjoon;

/*
* 뒤집기 문항
* 0과 1 각각 연속되는 경우의 회수를 카운트
* 둘 중 낮은 값이 답*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int oneCnt = 0;
        int zeroCnt = 0;
        char prevChar = str.charAt(0);

        if (prevChar == '0') zeroCnt++;
        else oneCnt++;

        for(int i=1; i<str.length(); i++){
            if(prevChar == str.charAt(i)) continue;
            else{
                if(prevChar == '0') {
                    oneCnt++;
                    prevChar = '1';
                } else {
                    zeroCnt++;
                    prevChar = '0';
                }
            }
        }

        System.out.println(Math.min(oneCnt,zeroCnt));
    }
}
