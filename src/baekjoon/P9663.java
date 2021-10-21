package baekjoon;

import java.util.Scanner;


// 백트래킹 알고리즘으로 접근
// cols의 배열을 활용해 해당 해당 칼럼에 row값을 매칭시킨다
// 윗줄부터 행마다 모든 열에 대해 반복을 수행하면서 가능한지를 체크
// 가능하다면 해당 열의 정보(cols[i])에 해당 행의 번호를 삽입
// 넣고자하는 퀸의 개수가 만족될 때까지 반복
// 퀸이 가능한 위치는 수직과, 대각선에 다른 퀸이 없어야함
// 수직을 체크하기 위해 이전 행들의 칼럼값과 비교하면서 다른지 체크
// 대각선을 체크하기 위해 이전 행들의 칼럼과 행과 이번 행의 칼럼의 좌표 x,y의 차이가 다른지 체크
public class P9663 {

    static int result;
    static int[] cols;

    public void solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        cols = new int[n];

        result=0;
        nQueen(0,n);

        System.out.println(result);
    }

    public void nQueen(int col, int n){
        if(n==col) {
            result++;
            return;
        }
        for(int i=0 ;i<n;i++){
            cols[col] =i;
            if(isPosible(col)){
                nQueen(col+1,n);
            }
        }
    }

    private boolean isPosible(int col) {
        for(int i=0; i<col; i++){
            if(cols[i]==cols[col] || Math.abs(cols[i]-cols[col])==Math.abs(i-col))
                return false;
        }
        return true;
    }
}
