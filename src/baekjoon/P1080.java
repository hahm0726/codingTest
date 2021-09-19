package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 백준 행렬 문항
* A행렬을 B행렬로 만드는 데 최소 수행으로 가능하려면
* (i,j)의 값이 A와B 가 다른 모든 경우에 (i,j)에서 시작하는 3*3 사이즈를 한번씩 뒤집어서 만들어야함
* 따라서 A,B의 (i,j)가 다른 경우 뒤집어 가면서 모든 시행을 한 뒤
* 최후로 A와 B가 다른 경우 -1 출력
* 같은 경우 reverse를 수행한 횟수인 cnt 를 출력
*
* */

public class P1080 {
    public boolean isSameMatrix(int[][] mat1, int[][] mat2,int n,int m){
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(mat1[i][j] != mat2[i][j]) return false;
            }
        }
        return true;
    }

    public void reverse(int[][] mat, int r, int c){
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(mat[i][j] == 0) mat[i][j]=1;
                else mat[i][j]=0;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);


        int[][] A = new int [n][m];
        int[][] B = new int [n][m];

        for(int i=0; i<n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = row.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = row.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i=0; i <= n-3;i++){
            for(int j=0; j <= m-3; j++){
                if(A[i][j] != B[i][j]) {
                    reverse(A, i, j);
                    cnt++;
                }
            }
        }


        if(isSameMatrix(A,B,n,m)) System.out.println(cnt);
        else System.out.println(-1);
    }
}
