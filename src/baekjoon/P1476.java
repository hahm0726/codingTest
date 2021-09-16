package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1476 날짜 계산 문항
* 결국 나머지에 대한 개념으로 주어진 값들은 15, 28, 19로 나눈 나머지의 값
* 따라서 해당 나머지의 값들을 모두 만족시키는 답을 구할 때까지 단순 반복하면 된다*/

public class P1476 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] year = br.readLine().split(" ");

        int E = Integer.parseInt(year[0]);
        int S = Integer.parseInt(year[1]);
        int M = Integer.parseInt(year[2]);

        int e,s,m,ans;
        ans = e = s = m = 1;

        while(true) {
            if (e == E && s == S && m == M) break;
            ans++;
            e++;
            s++;
            m++;
            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }

        System.out.println(ans);
    }
}

