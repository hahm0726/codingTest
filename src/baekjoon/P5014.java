package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS 와 그리디로 접근 가능하다고 생각 ==> BFS를 활용해서 문제 접근
// 각층을 1개의 정점으로 생각하고 u와 d를 간선 이동의 방식으로 생각
// 최소가 돼야하기 때문에 이를 최단거리로 해석. 따라서 방문한 층은 다시 방문하지 않도록 체크
// 따라서 BFS알고리즘을 사용할 수 있다고 판단

public class P5014 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();

        boolean[] visited = new boolean[f + 1];

        int result = bfs(s, g, u, d, f, visited);
        if (result < 0) System.out.println("use the stairs");
        else System.out.println(result);
    }

    public int bfs(int start, int target, int u, int d, int max, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int q_sz = q.size();
            for(int sz=0; sz<q_sz; sz++){
                int cur = q.poll();
                if (cur == target) return cnt;

                //위로 가는 케이스
                if (cur + u <= max) {
                    int next = cur + u;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }

                //아래로 가는 케이스
                if (cur - d > 0) {
                    int next = cur - d;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}
