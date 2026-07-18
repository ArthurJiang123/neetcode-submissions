class Solution {

    /*
    Idea: Use a fixed-size sliding window over s2. 
    Track the character frequencies in the current window. 
    At each step, compare the window's character frequencies to s1's character frequencies.
    Return true if they match exactly.
    */

    // time: O(26 × n) = O(n) | space: O(1) — 2 fixed-size arrays
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1Freq = new int[26];     // s1's frequency (never changes)
        int[] windowFreq = new int[26]; // current window's frequency (updated as we slide)

        // 1. Count s1's characters
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // 2. Build the first window (first m characters of s2)
        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // 3. Check the first window
        if (matches(s1Freq, windowFreq)) return true;

        // 4. Slide the window
        // i = index of the character being removed
        // i + s1.length() = index of the character being added
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            char leftChar = s2.charAt(i);    // leaving the window
            char rightChar = s2.charAt(i + s1.length());  // entering the window

            windowFreq[leftChar - 'a']--;   // remove left
            windowFreq[rightChar - 'a']++;  // add right

            if (matches(s1Freq, windowFreq)) return true;
        }

        return false;
    }

    // Check if two frequency arrays are identical
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
