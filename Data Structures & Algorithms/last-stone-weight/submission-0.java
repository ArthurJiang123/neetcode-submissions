class Solution {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1,a2) -> a2 - a1);

    public int lastStoneWeight(int[] stones) {
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
