package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// bfs(너비 우선 탐색)을 통해 주변의 케이스를 규칙에 따라 확인
// 왼쪽 방향과 뒤쪽방향을 계산하기 위해 북(0),동(1),남(2),서(3)의 인덱스를 활용
// 0->3, 1->0, 2->1, 3->2 ==> (dir+3)%4 의 결과가 왼쪽방향이 됨
// 0->2, 1->3, 2->0, 3->1 ==> (dir+2)%4 의 결과가 뒷쪽방향이 됨
// 현재위치에서 왼쪽방향이 청소되는 경우 해당 케이스는 종료이기 때문에
// 왼쪽방향을 다음 청소구역으로 설정하고 반복을 종료한다
// 만약 현재 위치에서 네방향 모두가 allClean한 상태이면 뒤로 한칸 후진하고 clean을 진행
// 후진으로 이동이 불가하면 종료
// 결국 규칙을 잘 이해하고 적용하면 풀 수 있는 문제

public class P14503 {

    static int n, m;
    static int[][] arr;
    static int cnt;
    static int[] dr = {-1, 0, 1, 0}; //북동남서 순서
    static int[] dc = {0, 1, 0, -1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        //맵
        arr = new int[n][m];

        //로봇의 현재좌표와 방향
        str = br.readLine().split(" ");
        int rr = Integer.parseInt(str[0]);
        int rc = Integer.parseInt(str[1]);
        int rd = Integer.parseInt(str[2]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        cnt = 0;
        clean(rr, rc, rd);
        System.out.println(cnt);
    }

    public void clean(int curR, int curC, int curDir) {
        // 현재 위치 청소 수행
        if (arr[curR][curC] == 0) {
            arr[curR][curC] = 2;
            cnt++;
        }

        int originDir = curDir; //네방향을 모두 체크 후 원래의 방향을 사용하기 위해 현재의 방향을 미리 저장
        boolean allClean = true; //네 방향이 모두 청소되어있거나 벽인 경우 false
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + 3) % 4;
            int nextR = curR + dr[nextDir];
            int nextC = curC + dc[nextDir];
            if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m) {
                if (arr[nextR][nextC] == 0) {
                    clean(nextR, nextC, nextDir);
                    allClean = false;
                    break;
                }
            }
            curDir = (curDir + 3) % 4;
        }

        //현재위치에서 네 방향모두 청소할 게 없는 경우(1 or 2)
        if (allClean) {
            int nextDir = (originDir + 2) % 4;
            int nextR = curR + dr[nextDir];
            int nextC = curC + dc[nextDir];
            if (nextR >= 0 && nextC >= 0 && nextR < n && nextC < m) {
                if (arr[nextR][nextC] != 1) clean(nextR, nextC, originDir);
            }
        }
    }
}
