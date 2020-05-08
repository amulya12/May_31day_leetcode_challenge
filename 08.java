class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // slope formula:
        // m = (y2 - y1) / (double) (x2 - x1)
        if (coor.length < 2) return false;
        int n = coor.length;
        int x1 = coor[0][0];
        int y1 = coor[0][1];
        int x2 = coor[1][0];
        int y2 = coor[1][1];
        
        double slope = calcSlope(x1, y1, x2, y2);
        
        for (int i = 2; i < n; i++) {
            x2 = coor[i][0];
            y2 = coor[i][1];
            double currSlope = calcSlope(x1, y1, x2, y2);
            
            if (slope != currSlope)
                return false;
        }
        
        return true;
    }}
    
    private double calcSlope(int x1, int y1, int x2, int y2) {
        return (y2 - y1) / (double) (x2 - x1);
    }
    
}