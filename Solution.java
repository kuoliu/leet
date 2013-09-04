public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null)
            return 0;
        int min = s.length() - 1;
        int i = 0;
        for(;i <=min ; ++ i){
           if(isOK(i, s))
            break;
        }
        if(i < min)
            min = i;
        return min;
    }
    
    private boolean isOK(int i, String s){
        if(i >= s.length())
            return false;
        if(i == 0){
        	if(isPalindrome(s))
        		return true;
        	else
        		return false;
        }
        int len = s.length();
        int end = len - i;
        for(int index = 1; index <= end; ++ index){
            String substr = s.substring(0, index);
            if(isPalindrome(substr) && isOK(i - 1, s.substring(index, len)))
                return true;
        }
        return false;
    }
    
    private boolean isPalindrome(String s){
        String r_s = new StringBuffer(s).reverse().toString();
        if(r_s.equals(s))
            return true;
        return false;
    }
    
    public static void main(String[] args){
    	System.out.println(new Solution().minCut("ab"));
    }
}