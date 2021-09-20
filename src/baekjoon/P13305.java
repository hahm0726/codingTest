package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13305 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] prices = new long[n];
        long[] distances = new long[n-1];


        //주유소 거리 입력
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<n-1; i++){
            distances[i] = Long.parseLong(temp[i]);
        }

        //오일 가격 입력
        temp =br.readLine().split(" ");
        for(int i=0; i<n; i++){
            prices[i] = Long.parseLong(temp[i]);
        }

        long minPrice = prices[0]; //현재까지의 위치에서 가장 낮은 기름 가격
        long ret = 0; //현재까지의 가장 낮게 계산된 비용

        //현재위치까지에서 현재위치의 주유소 기름 가격이 가장 낮으면
        //minPrice를 현재위치의 기름 가격으로 변경해 다음 주유소까지 이동
        //이렇게 되면 처음 위치의 기름이 가장 저렴한 경우
        //처음 가격으로 모든 주유소를 가는 방법이 된다
        for(int i=0; i<n-1; i++){
            if(prices[i]< minPrice) minPrice = prices[i];
            ret = ret + (minPrice * distances[i]);
        }

        System.out.println(ret);
    }
}
