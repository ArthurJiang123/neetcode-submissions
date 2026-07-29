class Solution {

    // binary search
    /*
        1. find the max in piles
        2. let speed range = [1, max(piles)]
        3. binary search the speed range:
            If total hours < h -> 
                update the valid speed
                speed can get smaller, search left
            If total hours > h ->
                speed must get bigger, search right
        4. search until 2 pointers meeting in the midSpeeddle
        5. return the recorded valid speed
    */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int max = piles[0];
        for(int pile: piles) max = pile > max ? pile : max;
        
        int midSpeed;
        int result = 0;

        while(left <= max){
            midSpeed = (left + max) / 2;
            long totalH = 0;
            for(int pile : piles){
                totalH += Math.ceil((double)pile/midSpeed);
            }
            if(totalH <= h){
                max = midSpeed - 1;
                result = midSpeed;
            }else {
                left = midSpeed + 1;
            }
        }
        return result;
    }
}
