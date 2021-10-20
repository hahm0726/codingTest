package baekjoon;

import java.util.*;

// 기본 그래프 탐색 문항 ==> bfs/dfs 로 구현 가능
// 촌수는 간선을 지날 때마다 +1됨
// 같은 레벨의 케이스는 같은 촌수이기 때문에
// 한 노드에서 추가된 데이터들을 묶어서 다루기 위해 현재의 큐사이즈 만큼씩 꺼내 반복 수행
public class P2644 {
    static List<Integer>[] family;
    static boolean[] visited;

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 전체 인원수
        int t1 = sc.nextInt()-1; // 타겟1
        int t2 = sc.nextInt()-1; // 타겟2
        int m = sc.nextInt();

        family = new List[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            family[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int p1 = sc.nextInt()-1;
            int p2 = sc.nextInt()-1;
            family[p1].add(p2);
            family[p2].add(p1);
        }

        int result = bfs(t1,t2);
        System.out.println(result);
    }

    public static int bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        int result = 0;

        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            result++;
            int q_sz = q.size();
            for(int sz=0; sz< q_sz; sz++) {
                int cur = q.poll();
                for (int i = 0; i < family[cur].size(); i++) {
                    int next = family[cur].get(i);
                    System.out.println("next = " + next);
                    if (visited[next]) continue;
                    if (next == target) return result;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }
}
