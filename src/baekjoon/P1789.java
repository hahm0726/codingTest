package baekjoon;


/*
 * 수들의 합
 * 서로 다른 자연수 N개를 더해 주어진 수를 구하는 N의 최대값은
 * 가장 작은 자연수 1부터 더해서 주어진 수를 넘는 경우의 숫자 바로 전까지의 수가
 * 이를 만족하는 N의 최대값이 된다
 * 그 이유는 해당 N개를 넘는 순간 무조건 주어진 수를 넘어가기 때문*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1789 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        for(long i=1;i<=num;i++){
            if((1+i)*i/2 > num){
                System.out.println(i-1);
                break;
            }
        }
    }
}
