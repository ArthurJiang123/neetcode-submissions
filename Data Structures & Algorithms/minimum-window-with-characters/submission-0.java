class Solution {
    public String minWindow(String s, String t) {
    int[] freq = new int[128];
    for (int i = 0; i < t.length(); i++) freq[t.charAt(i)]++;

    int left = 0, start = 0, minLen = Integer.MAX_VALUE, need = t.length();

    for (int right = 0; right < s.length(); right++) {
        freq[s.charAt(right)]--;
        if (freq[s.charAt(right)] >= 0) need--; // found needed char

        while (need == 0) { // window valid
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
            }
            freq[s.charAt(left)]++;
            if (freq[s.charAt(left)] > 0) need++; // lost needed char
            left++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}
}
