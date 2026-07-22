class Solution {
    public String minWindow(String s, String t) {
        // Step 1: Build freq map of characters in t
        int[] freqNeeded = new int[128];
        for (char c : t.toCharArray()) {
            freqNeeded[c]++;
        }

        int left = 0, start = 0, minLen = Integer.MAX_VALUE;
        int missing = t.length();

        // Step 2: Expand window to the right
        for (int right = 0; right < s.length(); right++) {
            // Step 3: Include character at right pointer
            char r = s.charAt(right);
            freqNeeded[r]--;
            if (freqNeeded[r] >= 0) {
                missing--;
            }

            // Step 4: When all characters are covered, shrink from left
            while (missing == 0) {
                // Step 5: Track the smallest valid window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Step 6: Exclude character at left pointer
                char l = s.charAt(left);
                freqNeeded[l]++;
                if (freqNeeded[l] > 0) {
                    missing++;
                }
                left++;
            }
        }

        // Step 7: Return the smallest window or empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}