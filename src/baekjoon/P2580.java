package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 스도쿠를 백트래킹하면서 만약 모든 행을 확인하고 트래킹회수가 9가 완성됐을 경우 스도쿠 완성
// 1. 같은 열 확인 필요
// 2. 같은 행 확인 필요
// 3. 같은 구역 확인 필요
// 1,2,3 조건을 만족하는 경우 다음 열로 넘어감
// 모든열이 수행됐을 때(col==9)인 경우 다음 행, 첫번쨰 열부터 반복 수행
// 모든 행이 왼료(row==9)인 경우 System.exit(0)으로 프로그램 종료
public class P2580 {

    static int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        sudoku(0,0);
    }

    public void sudoku(int row, int col) {
        //마지막 열까지 확인된 경우 다음 행, 첫번째 열부터 수행
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        //끝 행까지 반복을 마친 경우
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        // 현재 행,열 위치값이 빈칸
        if (map[row][col] == 0) {
            //1~9를 넣어보면서 가능한지 체크
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            map[row][col] = 0;
            return;
        }

        //해당 위치가 빈칸이 아닌 경우 다음 열 수행
        sudoku(row,col+1);
    }

    //현재 행,열 위치에 num이 들어올 수 있는지 체크
    boolean isPossible(int row, int col, int num) {
        //같은 행 검사
        for (int c = 0; c < 9; c++) {
            if (map[row][c] == num) return false;
        }
        //같은 열 검사
        for (int r = 0; r < 9; r++) {
            if (map[r][col] == num) return false;
        }
        //같은 구역 검사
        int areaR = (row / 3) * 3;
        int areaC = (col / 3) * 3;

        for(int i=areaR; i<areaR+3;i++){
            for(int j=areaC;j<areaC+3;j++){
                if(map[i][j]== num) return false;
            }
        }
        return true;
    }
}
