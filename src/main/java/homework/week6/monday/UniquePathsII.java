package homework.week6.monday;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) {
            if(obstacleGrid[i][j]==1) {
                dp[j]=0;
                continue;
            }
            if(j-1>0 && obstacleGrid[i][j-1]==0) dp[j]+=dp[j-1];
        }

        return dp[n-1];
    }



}
