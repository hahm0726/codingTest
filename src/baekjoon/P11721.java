package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P11721 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<>();

        String str = br.readLine();

        for(int i=0; i<str.length(); i+=10){
            if(i+10 > str.length()) System.out.println(str.substring(i));
            else System.out.println(str.substring(i,i+10));
        }
    }
}
