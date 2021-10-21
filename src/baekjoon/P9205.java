package baekjoon;

import java.util.*;

// 그래프를 만들기 위해 각 점들 완전탐색으로 비교해도 n의 최대가 100
// 따라서 n^2을 수행해도 10000의 반복
// bfs의 경우 O(n+v) n은 노드, v는 간선 수라 충분히 가능
// 그래프를 만들기 위해 맨하튼 거리로 간선의 역할을 수행해내고
// 이후 목적지에 도착할 수 있는지 bfs 알고리즘을 수행하면 됨
public class P9205 {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            Dot[] points = new Dot[n + 2]; //0 집, 1~n 편의점, n+1 펜타포트
            List<Integer>[] graph = new List[n + 2];
            for (int i = 0; i < n + 2; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n + 2; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                points[i] = new Dot(r, c);
            }

            //맨해튼 거리를 활용해 거리가 1000 이하인 두 지점을 그래프로 만들어줌
            for (int i = 0; i < n + 2; i++) {
                Dot v1 = points[i];
                for (int j = i + 1; j < n + 2; j++) {
                    Dot v2 = points[j];
                    if (Math.abs(v1.getX() - v2.getX()) + Math.abs(v1.getY() - v2.getY()) <= 1000) {
                       graph[i].add(j);
                       graph[j].add(i);
                    }
                }
            }

            boolean[] visited = new boolean[n+2];
            boolean result = bfs(0,n+1, graph, visited);

            if(result) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public boolean bfs(int start, int target, List<Integer>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == target) return true;
            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);

                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }

        return false;
    }

    static class Dot {
        private int x;
        private int y;

        public Dot() {
        }

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
