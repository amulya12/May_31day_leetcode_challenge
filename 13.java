// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

// Note:
// The length of num is less than 10002 and will be = k.
// The given num does not contain any leading zero.
// Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        int pull = len - k;
        if (pull == 0)
            return "0";
        int lpr = 0;
        int rpr = 0;
        int[] counts = new int[10];
        boolean zero = true;
        StringBuilder sb = new StringBuilder(pull);
        while (pull > 0) {
            // populate counts in the entire range
            while(rpr <= (len - pull)) {
                counts[num.charAt(rpr) - '0']++;
                rpr++;
            }
            // get lowest digit move lptr to +1 of it
            int i = 0;
            for (; i < 10; i++) {
                if (counts[i] > 0) {
                    char c = (char)('0' + i);
                    zero = zero && i == 0;
                    if (!zero)
                        sb.append(c);
                    // navigate lpr
                    while(num.charAt(lpr) != c) {
                        counts[num.charAt(lpr) - '0']--;
                        lpr++;
                    }
                    counts[i]--;
                    lpr++;
                    pull--;
                    break;
                }
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}