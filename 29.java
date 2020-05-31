// There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0. So it is possible.

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] course = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) 
            course[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            course[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if 
            (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: course[bfs.get(i)])
                if (--degree[j] == 0) 
                    bfs.add(j);
        return bfs.size() == n;
    }
}