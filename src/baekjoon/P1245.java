package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P1245 {

    int n, m;
    int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    int[][] map;
    boolean[][] visited;
    boolean isPeak;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int result = 0;

        //맵 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;
                isPeak = true;
                bfs(i, j);
                if (isPeak) result++;
            }
        }

        System.out.println(result);
    }

    void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point curP = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = curP.r + dr[i];
                int nc = curP.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (map[nr][nc] > map[curP.r][curP.c]) isPeak = false;
                if (visited[nr][nc] || map[nr][nc] == 0) continue;
                if (map[nr][nc] == map[curP.r][curP.c]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }
}