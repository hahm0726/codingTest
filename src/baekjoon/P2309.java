package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
* 일곱 난쟁이 문항
* 9명의 난쟁이의 모든 키를 더한 후 2명을 빼서 100이 되는 경우를 찾으면 됨
* 이중반복(O(n^2))로 2명을 뽑는 경우를 수행하면서 100이 되면 바로 반복을 중단
* 해당 2명의 인덱스를 제외하고 출력*/
public class P2309 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9];
        int totalHeights = 0;
        for(int i=0; i<9; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalHeights += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        for(int i=0; i<8;i++){
            for(int j=i+1; j<9; j++){
                if(totalHeights-dwarfs[i]-dwarfs[j]==100){
                    for(int k=0; k<9;k++){
                        if(k==i || k==j) continue;
                        System.out.println(dwarfs[k]);
                    }
                    return;
                }
            }
        }
    }
}
