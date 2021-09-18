package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 백준 행렬 문항
* A행렬을 B행렬로 만드는 데 최소 수행으로 가능하려면
* (i,j)의 값이 A와B 가 다른 모든 경우 한번씩 뒤집어서 만들어야함
*
* */

public class P1080 {
    public boolean isPossible(int r, int c, int n, int m){
        if(r+2 < n && c+2 < m) return true;
        return false;
    }

    public void initMatrix(int[][] mat, int n, int m) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                mat[i][j] = row.charAt(j);
            }
        }
    }

    public boolean isMatrixSame(int[][] mat1, int[][] mat2){
        for(int i=0; i<mat1.length;i++){
            for(int j=0; j<mat1[0].length; j++){
                if(mat1[i][j] != mat2[i][j]) return false;
            }
        }
        return true;
    }

    public void reverse(int[][] mat, int r, int c){
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(mat[i][j]==0) mat[i][j]=1;
                else mat[i][j]=0;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n<3 || m<3) System.out.println(-1);

        int[][] A = new int [n][m];
        int[][] B = new int [n][m];

        initMatrix(A,n,m);
        initMatrix(B,n,m);

        int cnt = 0;
        for(int i=0;i<n-2;i++){
            for(int j=0; j<m-2; j++){
                if(A[i][j] != B[i][j]){
                    if(isPossible(i,j,n,m)){
                        reverse(A,i,j);
                        cnt++;
                    }
                }
            }
        }

        if(isMatrixSame(A,B)) System.out.println(cnt);
        else System.out.println(-1);
    }
}
