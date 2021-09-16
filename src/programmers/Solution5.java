package programmers;

/*
*  전화번호 목록 Level2*/

import java.util.*;

public class Solution5 {
    public boolean solution(String[] phoneBook) {
        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0; i< phoneBook.length; i++){
            hash.put(phoneBook[i],i);
        }
        for(int i=0;i< phoneBook.length; i++){
            for(int j=0; j<phoneBook[i].length(); j++){
                if(hash.containsKey(phoneBook[i].substring(0,i))) return false;
            }
        }
        return true;
    }
}
