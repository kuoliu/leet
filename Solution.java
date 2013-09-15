public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x <= 1)
            return x;
        int left = 0;
        int right = x;
        int mid = 0;
        while((right - left) > 1){
            mid = left + (right - left)/2;
            int temp = x/mid;
            if(temp == mid)
                return mid;
            else if(temp > mid)
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}