//Approach : with the use of a map I count the frequency of each jewel and add the total frequency.
class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> m=new HashMap<Character,Integer>();
        // first I read each character in string S and store it in map as keys and theirs values are occurances.
        for(char c : S.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        //now i read the characters of jeweles, if a character in jewels is present in map, then I add the value to my tootal count.
        for(char c : J.toCharArray()){
            if(m.containsKey(c)){
                count = count + m.get(c);
            }
        }
        return count;
    }
}
