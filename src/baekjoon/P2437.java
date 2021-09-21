package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2437 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] weights = new int[n];

        //추들의 무게 int 로 변환
        for(int i=0; i< n; i++){
            weights[i] = Integer.parseInt(temp[i]);
        }

        //추들의 무게 오름차순 정렬
        Arrays.sort(weights);

        //현재까지 추들의 무게를 더한 값 sum
        //sum + 1 < i번째 추 인 경우
        //sum+1의 경우는 만들 수 없다
        //추 중 최소값들을 더해 sum을 만들기 때문에
        //현재 더하려는 추의 무게가 sum+1 보다크면 sum+1은 만들 수 없게 되기 때문
        int sum=0;
        for(int i=0; i<n; i++){
            if(weights[i] > sum + 1) break;
            sum += weights[i];
        }

        System.out.println(sum+1);
    }
}
