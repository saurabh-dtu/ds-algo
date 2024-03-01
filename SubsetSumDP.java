public class SubsetSumDP {
    public boolean canPartition(int[] nums, int target) {
        int n = nums.length;

        // dp[i][j] represents whether a subset with sum j can be formed using the first i elements of nums
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: An empty subset can always form a subset with sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // If the current element is greater than the target sum, exclude it
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include the current element and check if a subset with the remaining sum can be formed
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // The final result is stored in the bottom-right cell of the dp table
        return dp[n][target];
    }

    public static void main(String[] args) {
        SubsetSumDP solution = new SubsetSumDP();
        int[] nums = {1, 5, 11, 5};
        int target = 11;
        System.out.println(solution.canPartition(nums, target)); // Output: true
    }
}
