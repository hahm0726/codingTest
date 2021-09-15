package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
* 전화번호 목록 문항 */
public class P5052 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc< t; tc++){
            int n = Integer.parseInt(br.readLine());
            boolean result = true;
            String[] nums = new String[n];

            for(int i=0; i<n; i++){
                nums[i] = br.readLine();
            }

            Arrays.sort(nums);

            for(int i=0; i<n-1; i++){
                if(nums[i+1].startsWith(nums[i])) {
                    result=false;
                    break;
                }
            }

            if(!result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public void trieSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc< t; tc++){
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            List<String> keys = new ArrayList<>();
            boolean isConain = false;

            for(int i=0; i<n; i++){
                String num = br.readLine();
                trie.insert(num);
                keys.add(num);
            }

            for(String key : keys){
                if(trie.contains(key)){
                    isConain = true;
                    break;
                }
            }

            if(isConain) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    static class Trie{

        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        public void insert(String word){
            TrieNode tempNode = this.rootNode;

            for(int i=0; i<word.length(); i++){
                //childNode의 Key가 charAt(i) 이면 c를 리턴, 없으면 -> 다음 작성한 new TrieNode 함수 실행 후 그 결과값 리턴
                //즉 두 값이 다르면 새로운 Node 생성
                tempNode = tempNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }

            tempNode.setLastChar(true);
        }

        public boolean contains(String word){
            TrieNode tempNode = this.rootNode;

            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                TrieNode node = tempNode.childNodes.get(ch);
                if(node == null) return false;

                tempNode = node;
            }

            //해당 문자로 종료하는 문자가 있는 경우 중 자기 자신과 같은 단어일 경우 false
            //조건에 전화번호가 완전 같은 두 값은 존재X 라고 했기 때문
            if(tempNode.isLastChar()){
                if(tempNode.getChildNodes().isEmpty()) return false;
            }

            return true;
        }


    }

    static class TrieNode{
        //자식 노드 맵
        Map<Character, TrieNode> childNodes = new HashMap<>();

        //마지막 글자인지 여부
        private boolean isLastChar;

        //자식 노드 맵 getter
        Map<Character, TrieNode> getChildNodes(){
            return this.childNodes;
        }

        // 마지막 글자인지 상태 getter
        boolean isLastChar() {
            return this.isLastChar;
        }

        void setLastChar(boolean isLastChar){
            this.isLastChar = isLastChar;
        }
    }
}
