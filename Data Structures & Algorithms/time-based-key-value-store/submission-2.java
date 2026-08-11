class TimeMap {

    class Node<K, V>{
        K k;
        V v;
        Node(K k, V v){
            this.k = k;
            this.v = v;
        }
    }

    Map<String, List<Node<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node<Integer, String>> list;
        
        if(!map.containsKey(key)){
            list = new ArrayList<>();
            list.add(new Node(timestamp, value));
            map.put(key, list);
        }else{
            list = map.get(key);
            list.add(new Node(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Node<Integer, String>> list = map.get(key);
        int left = 0, right = list.size()-1;
        String result = "";
        while(left <= right){
            int mid = (left + right) / 2;
            Node<Integer, String> node = list.get(mid);
            if(node.k <= timestamp) {
                result = node.v;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return result;
    }
}
