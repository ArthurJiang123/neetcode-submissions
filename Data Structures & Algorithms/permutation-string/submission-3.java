class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length() < s1.length()) return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for(char c : s1.toCharArray()){
            s1Freq[c-'a'] +=1;
        }

        for(int i = 0; i < s1.length(); i++){
            windowFreq[s2.charAt(i) - 'a']+=1;
        } 

        if(matches(s1Freq, windowFreq)) return true;

        for(int i = 0; i < s2.length() - s1.length(); i++){
            int leftChar = s2.charAt(i); // leaving the window;
            int rightChar = s2.charAt(i+s1.length()); // entering the window;
            windowFreq[leftChar - 'a']-=1;
            windowFreq[rightChar - 'a']+=1;
            if(matches(s1Freq, windowFreq)) return true;
            
        }
        return false;
        
    }
    private boolean matches(int[] a, int[] b){
        for(int i =0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
