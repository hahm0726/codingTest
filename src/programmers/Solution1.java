package programmers;


/*
* 프로그래머스 여행경로 문항
* 항상 "ICN" 공항에서 출발, 방문하는 공항 경로를 배열에 담아 반환
* 모든 공항 알파벳 대문자 3글자로 통일
* ticket = [a,b]  a->b 로 갈 수 있음을 의미
* 만약 가능 경로가 2개 이상인 경우 알파벳 순서가 앞서는 경로로 return
* !!!!!!모든 티켓을 다 사용해야한다!!!!!!!
*
* [접근 방식]
* - backtracking 방식을 사용하면서 순회
* - 아직 사용하지 않은 티켓이고, 현재 공항이 출발지인 티켓인 경우 backtracking 수행
* - 순회하면서 모든 티켓이 사용된 경우(cnt == tickets.length) 이 때의 경로를 routes에 저장
* - 가능한 모든 경로를 찾은 후 저장되어있던 routes 리스트를 정렬해 사전순으로 가장 빠른 경로를 찾는다
* */

import java.util.*;

class Solution1 {

    ArrayList<String> routes;
    boolean[] visited;

    public void backtracking(String cur, int cnt, String route, String[][] tickets){
        if(cnt == tickets.length){
            routes.add(route);
            return;
        }
        for(int i=0;i<tickets.length; i++){
            if(visited[i]==false && tickets[i][0].equals(cur)){
                visited[i]=true;
                backtracking(tickets[i][1], cnt+1, route+ " " + tickets[i][1], tickets);
                visited[i]=false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        routes = new ArrayList<>();
        visited = new boolean[tickets.length]; //티켓 사용 여부

        backtracking("ICN",0,"ICN", tickets);
        Collections.sort(routes);
        String[] ret = routes.get(0).split(" ");
        return ret;
    }
}