class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        Map<Character, Integer> s1Freq = new HashMap<>();
        for( char c : s1.toCharArray()){
            if(s1Freq.containsKey(c)) s1Freq.put(c, s1Freq.get(c)+1);
            else s1Freq.put(c, 1);
        }        

        int windowSize = s1.length();
        for (int i = 0; i <= s2.length() - windowSize; i++) {
            Map<Character, Integer> slidingFreq = new HashMap<>();
            for (int j = i; j < i + windowSize; j++) {
                char c = s2.charAt(j);
                if(slidingFreq.containsKey(c)) slidingFreq.put(c, slidingFreq.get(c)+1);
                else slidingFreq.put(c, 1);
            }

            boolean found = true;
            for(Character c : s1Freq.keySet()){
                Integer curs1Freq = s1Freq.get(c);
                if(!slidingFreq.containsKey(c) || !slidingFreq.get(c).equals(curs1Freq)){
                    found = false;
                    break;
                }
            }
            if(found) return found;
        }

        return false;
    }


}
