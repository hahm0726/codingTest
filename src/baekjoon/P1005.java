package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 위상정렬이 필요한 문항 => indegree를 활용해 풀이
// 위상정렬이 가능한 조건 => DAG(Directed Acyclic Graph) 그래프여야 함
// 출발점은 자신으로 들어오는 간선이 없는 곳부터 시작해야함 => 이를 위해 그래프를 구성할 때 본인에게 들어오는 간선을 indegree 배열로 저장
// 위상정렬 시작 시 진입차수(Indegree)가 0인 것들을 찾아 큐에 삽입
// 큐에서 한개씩 꺼내면서 연결된 노드를 확인
// 연결된 노드에 확인하면서 진입차수-1, 현재 노드까지 온 것이 가장 큰 수인지 확인 => 현재 노드를 만들기 위해 이전 것들이 모두 완료되어야함
// 따라서 이전 것들 중 가장 time이 큰 것의 영향을 받기 때문에 가장 큰 수인지 매번 확인 필요
// 이 때 진입차수가 0이 되는 것을 다시 큐에 삽입 => 진입 차수가 0이라는 것은 이전 것들이 모두 완료됐다는 뜻
// 이런 식으로 모든 노드들에 대해 가장 오래걸린 시간들을 result라는 배열에 담아 반환
// 마지막으로 타겟위치의 값을 출력
public class P1005 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t > 0){
            t--;
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            
            //그래프
            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int i=0; i<n; i++){
                graph[i] = new ArrayList<>();
            }

            //자신에 이어진 간선 개수(건물수만큼 할당)
            int[] indegree = new int[n];

            //빌딩만드는데 걸리는 시간
            int[] time = new int[n];
            str = br.readLine().split(" ");
            for(int i=0; i<n;i++){
                time[i]= Integer.parseInt(str[i]);
            }

            for(int i=0; i<k; i++){
                str = br.readLine().split(" ");
                int v1 = Integer.parseInt(str[0])-1;
                int v2 = Integer.parseInt(str[1])-1;
                graph[v1].add(v2);
                indegree[v2]++;
            }


            int target = Integer.parseInt(br.readLine())-1;

            int[] result = topological(graph,indegree,time);

            System.out.println(result[target]);
        }
    }

    private int[] topological(ArrayList<Integer>[] graph, int[] indegree, int[] time){
        Queue<Integer> q = new LinkedList<>();
        int len = indegree.length;
        int[] result = new int[len];
        for(int i=0; i<len; i++){
            if(indegree[i]==0) {
                q.add(i);
                result[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur]+time[next]);
                if(indegree[next]==0) q.add(next);
            }
        }

        return result;
    }
}
