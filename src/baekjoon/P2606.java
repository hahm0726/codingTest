package baekjoon;

import java.io.*;
import java.util.*;

/*
* dfs/bfs 를 활용해 그래프 탐색으로 풀 수 있는 문제
* 컴퓨터 n대가 1번 부터 시작하기 때문에 0 ~ n-1 의 인덱스를 갖도록 공간을 할당 후
* 간선정보를 입력할 때 노드의 번호를 -1씩 해 선언한다
* 그 후 1번 컴퓨터(인덱스 0)를 시작으로 그래프 순회를 시작하면서 거쳐가는 노드의 개수를
* 카운팅하면 된다*/
public class P2606 {

    private boolean[] visited;
    private ArrayList<Integer>[] coms;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        coms = new ArrayList[n];
        this.visited = new boolean[n];
        Arrays.fill(this.visited,false);

        for(int i=0;i<n;i++){
            coms[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            String[] nodeInfo = br.readLine().split(" ");
            int v1 = Integer.parseInt(nodeInfo[0]) -1;
            int v2 = Integer.parseInt(nodeInfo[1]) -1;

            coms[v1].add(v2);
            coms[v2].add(v1);
        }

        int ans = bfs(0);

        System.out.println(ans);
    }

    public int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<coms[cur].size(); i++){
                int next = coms[cur].get(i);

                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
