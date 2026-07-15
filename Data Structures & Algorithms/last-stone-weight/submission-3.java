class Solution {
    private PriorityQueue<Integer> maxHeap;

    public int lastStoneWeight(int[] stones) {
        maxHeap = new PriorityQueue<>
                (stones.length,
                Collections.reverseOrder());
        
        
        for(int stone: stones) maxHeap.offer(stone);

        int result = 0;

        while(maxHeap.size() > 1){
            int max = maxHeap.poll();
            int max2 = maxHeap.poll();
            if (max == max2) continue;
            maxHeap.offer(max-max2);
        }
        if(maxHeap.size() > 0){
            result = maxHeap.peek();
        }

        return result;
    }
}
