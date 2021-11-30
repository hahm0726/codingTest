package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 첫번째 입력받는 파일을 StringBuilder 로 입력받은 후
// 다음 오는 파일들에 대해 각 문자를 비교하면서 다른 경우 해당 위치를 ?로 치환
// 변경이 자주 발생하기 때문에 기본 String 클래스가 아닌 StringBuilder 사용
public class P1032 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());

        for (int i = 0; i < n-1; i++) {
            String nextFile = br.readLine();
            for(int j=0; j<nextFile.length(); j++){
                if(sb.charAt(j) != nextFile.charAt(j)){
                    sb.replace(j,j+1,"?");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
