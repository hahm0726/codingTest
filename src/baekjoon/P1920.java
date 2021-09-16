package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 1920 수 찾기 문항
* 이분탐색 문항으로 이분탐색법을 사용해 O(log N)으로 풀었지만
* Map을 사용해 푸는 것이 더 빠르다*/
public class P1920 {
    public boolean binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;

            while(left <= right){
                int mid = (left+right)/2;
                if(target == arr[mid]) {
                    return true;
                }
                else if(target < arr[mid]) right = mid-1;
                else if(target > arr[mid]) left = mid+1;
            }
            return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }



        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(A);


        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(A,num)) System.out.println(1);
            else System.out.println(0);
        }
    }
}
