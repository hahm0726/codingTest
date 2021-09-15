package programmers;

import java.util.*;

public class Solution8 {
    public String solution(int[] numbers) {

        String[] nums = new String[numbers.length];

        for(int i=0; i<nums.length; i++){
            nums[i] = numbers[i] + "";
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String s : nums) {
            sb.append(s);
        }

        String answer = sb.toString();
        return answer;
    }


}
