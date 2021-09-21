package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1202 {

    //보석 정보를 위한 class
    // m은 무게, v는 가격
    public static class Jewel implements Comparable{
        private int m;
        private int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        @Override
        public int compareTo(Object o) {
            Jewel j = (Jewel) o;
            return this.getM() - j.getM();
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        Jewel[] jewels = new Jewel[n];
        Integer[] c = new Integer[k];

        //n개의 보석 정보 입력
        for(int i=0; i<n; i++){
            in = br.readLine().split(" ");
            Jewel jewel = new Jewel(Integer.parseInt(in[0]),Integer.parseInt(in[1]));
            jewels[i] = jewel;
        }

        //k개의 가방 정보 입력
        for(int i=0; i<k; i++){
            c[i] = Integer.parseInt(br.readLine());
        }

        //n개의 보석과 k개의 가방 오름차순 정렬
        Arrays.sort(jewels);
        Arrays.sort(c);

        long ans = 0;

        //오름차순으로 정렬된 k개의 가방을 순차적으로 돌면서
        //오름차순으로 정렬된 n개의 보석 중 i번째 가방에 담을 수 있는 모든 경우
        //즉 i번째 가방의 수용무게 보다 무게가 낮은 보석들의 가격들을
        //costs 우선순위 큐에 넣어 내림차순 정렬을 함
        //가능한 경우를 모두 담은 경우 costs에 값이 존재한다면 poll()을 통해
        //가장 높은 가격의 보석이 i번째 가방에 배정되게 함
        //즉 O(N+M)의 시간복잡도로 문제를 해결할 수 있음
        PriorityQueue<Integer> costs = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        for(int i=0; i<k; i++){

            while(j<n && jewels[j].getM() <= c[i]){
                costs.add(jewels[j].getV());
                j++;
            }

            if(!costs.isEmpty()){
                ans += costs.poll();
            }
        }

        System.out.println(ans);
    }
}
