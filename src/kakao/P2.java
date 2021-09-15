package kakao;

public class P2 {

    public boolean isPrime(long n){
        if(n==1) return false;

        for (long i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String convertIntoK(int n, int k){
        StringBuilder sb = new StringBuilder();

        while(n / k != 0){
            int remain = n % k;
            n /= k;
            sb.insert(0,Integer.toString(remain));
        }
        sb.insert(0,Integer.toString(n));

        return sb.toString();
    }

    public boolean conditionCheck(int start, int end, String str){
        if(start ==0 && end == str.length()-1) return true;

        if(start == 0){
            if(str.charAt(end+1) == '0') return true;
        }

        if(end == str.length()-1){
            if(str.charAt(start-1) == '0') return true;
        }

        if(str.charAt(end+1) == '0' && str.charAt(start-1) == '0') return true;

        return false;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String convertToK = convertIntoK(n,k);

        int start=0;

        while(start != convertToK.length()){
            if(convertToK.charAt(start) == '0'){
                start++;
                continue;
            }
            else{
                int end = start;
                while(end+1 < convertToK.length()){
                    //0이 아닌 경우 다음값으로 넘어감
                    if(convertToK.charAt(end+1) == '0') break;
                    end++;
                }
                String tmp = convertToK.substring(start,end+1);
                if(isPrime(Long.parseLong(tmp))){
                    if(conditionCheck(start,end,convertToK)) answer++;
                }
                start = end + 1;
            }
        }
        return answer;
    }
}
