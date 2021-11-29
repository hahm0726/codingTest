package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


//1. 좌표값을 담기 위한 Position 객체 선언
//2. 움직임들(R, L, T, B, RT, LT, RB, LB)의 값을 Map<String, Postion> 형태로 우선 저장
//3. 들어오는 시작 왕의 위치, 돌의 위치를 포지션 객체로 변환
//4. 왕의 다음 움직임이 돌과 겹치면 안되고, 8*8 영역을 벗어나면 안되는 2가지 조건 주의
//4-1. 우선적으로 돌의 위치와 왕의 다음 위치 확인. 돌이 움직일 수 있다면 조건대로 움직임
//4-2. 돌의 위치와 왕의 다음 위치가 같지 않다면, 왕의 위치가 영역을 벗어나는지 체크 후 가능하면 움직임
public class P1063 {

    Map<String, Position> moveMap;
    int maxPos = 8;
    int minPos = 1;

    public void solution() throws IOException {

        moveMapInit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] solutionInfo = br.readLine().split(" ");

        Position kingPos = covertToPosition(solutionInfo[0]);
        Position stonePos = covertToPosition(solutionInfo[1]);
        int n = Integer.parseInt(solutionInfo[2]);

        for (int i = 0; i < n; i++) {
            Position move = moveMap.get(br.readLine());
            Position nextKingPos = new Position(kingPos.r + move.r, kingPos.c + move.c);

            if (nextKingPos.equals(stonePos)) {
                Position nextStonePos = new Position(stonePos.r + move.r, stonePos.c + move.c);
                if(isPossible(nextStonePos)){
                    kingPos = nextKingPos;
                    stonePos = nextStonePos;
                }
            } else{
                if(isPossible(nextKingPos)) kingPos = nextKingPos;
            }
        }

        System.out.println(kingPos.posToString());
        System.out.println(stonePos.posToString());
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private String posToString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toChars(this.c -1 + 'A'));
            sb.append(Character.toChars(this.r + '0'));

            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return this.r == position.r && this.c == position.c;
        }
    }

    //움직임 문자열 값 매핑
    void moveMapInit() {
        moveMap = new HashMap<String, Position>();
        moveMap.put("R", new Position(0, 1));
        moveMap.put("L", new Position(0, -1));
        moveMap.put("B", new Position(-1, 0));
        moveMap.put("T", new Position(1, 0));
        moveMap.put("RT", new Position(1, 1));
        moveMap.put("LT", new Position(1, -1));
        moveMap.put("RB", new Position(-1, 1));
        moveMap.put("LB", new Position(-1, -1));

    }

    //문자열 위치 정보를 바탕으로 Position 객체 생성
    public Position covertToPosition(String str) {
        int row = str.charAt(1) - '0';
        int col = str.charAt(0) - 'A' + 1;

        return new Position(row, col);
    }

    //해당 위치가 가능한 위치인지 판단
    public boolean isPossible(Position pos){
        if(pos.r > maxPos || pos.r <minPos || pos.c >maxPos || pos.c <minPos) return false;
        return true;
    }
}
