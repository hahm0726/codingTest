package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 제한조건 단어의 개수 최대 50개, 문자열의 최대길이 50
// 모든 단어들에 대해 이중반복을 통해 접두어인지 계산하는 케이스 125,000
// 따라서 시간복잡도가 O(n^2)로 접근해도 충분히 가능
// 단어의 길이가 보다 짧은 것만이 다른 단어에 접두어가 될 수 있음
// 따라서 단어를 우선 정렬을 해 짧은 순서대로 비교가 가능하게 함
// 접두어인 단어들을 cnt로 카운팅해 전체 단어 수에서 빼면 접두어가 없는 단어의 집합을 구할 수 있음
// 이때 반복되는 단어가 등장해도 문제없음 => 반복되는 단어들의 개수가 n개이면 n-1개는 빠지고 1개만 살아남기 때문
// 1.단어를 길이순으로 정렬
// 2.접두어인 경우의 개수를 cnt로 카운팅
// 3.단어의 전체 개수 n에서 cnt를 뺌

public class P1141 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];

        for(int i=0; i<n; i++){
            words[i] = br.readLine();
        }
        Arrays.sort(words);
        int cnt =0;

        for(int i=0; i<n;i++){
            for(int j=i+1; j<n;j ++){
                if(words[j].startsWith(words[i])){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(n-cnt);
    }
}
