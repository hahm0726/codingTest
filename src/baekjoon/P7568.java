package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 덩치 문항
* 사람의 수가 2~50 으로 이중반복 O(n^2)을 해도 2500개로 1초가 걸리지 않음
* n명의 사람에 대해 n번의 반복을 하면서 자신보다 큰 경우를 카운팅
* 자신보다 큰 경우의 수+1 가 등수가 됨
* 모든 등수를 구한 후 차례대로 등수를 출력하면 된다
* */

public class P7568 {

    static class Person{
        private int weight;
        private int height;
        private int rating;

        public Person(int weight, int height, int rating){
            this.weight = weight;
            this.height = height;
            this.rating = rating;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n];

        for(int t=0; t<n; t++){
            String[] bodySpec = br.readLine().split(" ");

            int weight = Integer.parseInt(bodySpec[0]);
            int height = Integer.parseInt(bodySpec[1]);
            persons[t] = new Person(weight,height,0);
        }

        for(int i=0; i<n; i++){
            int biggerCnt = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(persons[i].getWeight() < persons[j].getWeight() && persons[i].getHeight() < persons[j].getHeight())
                    biggerCnt++;
            }
            persons[i].setRating(biggerCnt+1);
        }

        for(int i=0; i<n; i++){
            System.out.print(persons[i].getRating()+" ");
        }
        System.out.println();
    }
}
