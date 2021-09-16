package programmers;

import java.util.*;

public class Solution7 {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int[] dist;
    int maximum;

    void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]= true;
        dist[start]=0;

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int sz=0; sz<qSize; sz++){

                int cur = q.poll();

                for(int next : graph[cur]){
                    if(visited[next]) continue;
                    q.add(next);
                    visited[next] = true;
                    dist[next] = dist[cur]+1;
                    if(dist[next]>maximum) maximum = dist[next];
                }

            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        dist = new int[n];
        maximum = 0;

        for(int[] v : edge){
            int v1 = v[0]-1;
            int v2 = v[1]-1;

            if(graph[v1] == null) graph[v1] = new ArrayList<>();
            if(graph[v2] == null) graph[v2] = new ArrayList<>();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        bfs(0);

        int ans = 0;

        for(int d : dist){
            if(maximum==d) ans++;
        }

        return ans;
    }
}
