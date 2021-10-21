package baekjoon;

import java.util.*;


// 백트래킹으로 풀 수 있었음
// 문자가 사전순으로 늦은 문자가 빠른 문자앞에 올 수 없다는 조건 => 처음 문자들을 사전순으로 정렬한다
// 원하는 암호길이가 될 때까지 문자를 1개씩 추가하면서 트래킹 반복
// 이 때 해당 문자의  모음과 자음인지에 따라 모음 자음 각각 카운팅
// 문자열이 원하는 암호길이 됐을 때 모음이 1개 이상, 자음이 2개이상으로 이루어졌는지 체크
// 조건을 만족하면 결과에 추가
public class P1759 {

    static List<String> result;
    static char[] chars;
    static int l;
    static int c;

    public void solution() {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();

        chars = new char[c];
        for (int i = 0; i < c; i++) {
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars);

        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(sb, 0, 0,0,0);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public void solve(StringBuilder str, int cnt, int prev, int vowelsCnt, int consonCnt) {
        if (cnt == l) {
            if (vowelsCnt >= 1 && consonCnt >= 2) {
                result.add(str.toString());
            }
            return;
        }

        for (int i = prev; i < chars.length; i++) {
            str.append(chars[i]);
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u')
                solve(str, cnt + 1, i + 1, vowelsCnt + 1, consonCnt);
            else
                solve(str, cnt + 1, i + 1, vowelsCnt, consonCnt+1);
            str.delete(cnt, cnt + 1);
        }
    }


}
