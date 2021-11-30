package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1009 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(lastDataComNum(a,b));
        }
    }

    public int lastDataComNum(int a,int b){
        int result=1;

        for(int i=0;i<b;i++){
            result = (result*a) % 10;
        }

        if(result==0) result=10;
        return result;
    }
}
