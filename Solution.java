public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null)
            return 0;
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i = 0; i < len; ++ i)
            isPalindrome[i][i] = true;
        for(int i = len - 2; i >= 0; -- i){
            for(int j = i + 1; j < len; ++ j){
                if(((j - i < 2) || isPalindrome[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j))){
                    isPalindrome[i][j] = true;
                }
            }
        }
        for(int i = 0; i < len; ++ i)
            dp[i] = len - i - 1;
        for(int i = len - 2; i >= 0; --i){
            if(isPalindrome[i][len - 1]){
                dp[i] = 0;
                continue;
            }
            for(int j = i + 1; j < len; ++ j){
                if(isPalindrome[i][j - 1])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
}