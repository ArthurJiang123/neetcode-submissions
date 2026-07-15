class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((Integer i1, Integer i2) -> i1 - i2);
        this.k = k;
        for (int num : nums){
            pq.add(num);
        }

        for(int i = pq.size(); i > k; i--){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
