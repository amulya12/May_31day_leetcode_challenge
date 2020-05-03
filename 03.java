// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

// Each letter in the magazine string can only be used once in your ransom note.

// Note:
// You may assume that both strings contain only lowercase letters.
// Example:
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(char c : magazine.toCharArray())
            letters[c-'a']++;
        
        for(char c : ransomNote.toCharArray()){
            letters[c-'a']--;
            
            if(letters[c-'a'] < 0)
                return false;
        }
        
        return true;
    }
}
