class Solution {
    
    public String encode(List<String> strs) {
        if(strs == null||strs.size() == 0) return null;

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs.size(); i++){
        sb.append(strs.get(i));
        if(i < strs.size()-1)sb.append("/");
        }  
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        char[] arr = str.toCharArray();
        int pt1 = 0, pt2 = 0;
        while(pt2 <= arr.length){
            if(pt2 == arr.length || arr[pt2] == '/'){
                String word = str.substring(pt1, pt2);
                pt1 = pt2+1;
                ans.add(word);
            }
            pt2++;
        }
        return ans;
    }
}
