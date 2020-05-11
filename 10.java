// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
// Example 1:
// Input: N = 2, trust = [[1,2]]
// Output: 2

// Example 2:
// Input: N = 3, trust = [[1,3],[2,3]]
// Output: 3



class Solution {
    public int findJudge(int N, int[][] trust) {
        int judge = -1;
        if (trust == null || trust.length == 0) return N;

        int[] sendingtrust = new int[N+1];
        int[] receivingtrust = new int[N+1];
//calculating the sending trust and receiving trust and storing individual in an array.
        for (int[] pair : trust){
            sendingtrust[pair[0]]++;
            receivingtrust[pair[1]]++;
        }
//to be a judge the person should not trust anyone so sendingtrust from him shouls be 0.
//to be a judge the person should have n-1 people trusting him.(expect him)
        for (int i = 1; i <= N; i++) {
            if (sendingtrust[i] == 0 && receivingtrust[i] == N -1){
                judge = i;
                break;
            }
        }

        return judge;
    }
}