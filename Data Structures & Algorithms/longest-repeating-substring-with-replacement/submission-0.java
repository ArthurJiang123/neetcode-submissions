class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()){
            charSet.add(c);
        }
        for(char c : charSet){
            int cCount = 0;
            int left = 0;
            for(int right = 0; right < s.length(); right++){
                if(s.charAt(right) == c) cCount++;

                while((right - left + 1) - cCount > k){
                    if(s.charAt(left) == c){
                        cCount--;
                    }
                    left++;
                }

                answer = Math.max(answer, right - left + 1);
            }
        }
        return answer;
    }
}
