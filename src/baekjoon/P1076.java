package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 간단한 구현 문제
// 입력되는 문자열로 쉽게 값을 치환하기 위해 Map을 사용
// 그냥 값과 곱을 위한 값을 한번에 매핑하기위해 OhmInfo 클래스를 별도로 생성
// 매핑을 위한 다른 방법으로는 색 문자열과 값만을 일대일로 매핑하고
// 곱셈인 값은 Math.pow(10,value)로 곱셈값을 구하는 방식도 있다
public class P1076 {

    static Map<String,OhmInfo> ohmInfoMap;

    static class OhmInfo{
        int value;
        int multipleValue;

        public OhmInfo(int v, int m){
            this.value = v;
            this.multipleValue = m;
        }
    }

    void ohmInfoMapInit(){
        ohmInfoMap = new HashMap<>();
        ohmInfoMap.put("black",new OhmInfo(0,1));
        ohmInfoMap.put("brown",new OhmInfo(1,10));
        ohmInfoMap.put("red",new OhmInfo(2,100));
        ohmInfoMap.put("orange",new OhmInfo(3,1000));
        ohmInfoMap.put("yellow",new OhmInfo(4,10000));
        ohmInfoMap.put("green",new OhmInfo(5,100000));
        ohmInfoMap.put("blue",new OhmInfo(6,1000000));
        ohmInfoMap.put("violet",new OhmInfo(7,10000000));
        ohmInfoMap.put("grey",new OhmInfo(8,100000000));
        ohmInfoMap.put("white",new OhmInfo(9,1000000000));
    }

    public void solution() throws IOException {
        ohmInfoMapInit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;

        result +=  ohmInfoMap.get(br.readLine()).value*10;
        result +=  ohmInfoMap.get(br.readLine()).value;
        result *=  ohmInfoMap.get(br.readLine()).multipleValue;

        System.out.println(result);
    }
}
