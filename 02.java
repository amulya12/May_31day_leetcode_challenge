class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> m=new HashMap<Character,Integer>();
        for(char c : S.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for(char c : J.toCharArray()){
            if(m.containsKey(c)){
                count = count + m.get(c);
            }
        }
        return count;
    }
}