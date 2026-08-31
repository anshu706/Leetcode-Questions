// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int answer=0;
//         Arrays.sort(coins);
//         for(int i=coins.length-1;i>=0;i--){
//             int sum=0;
//             answer=0;
//             while(sum+coins[i]<=amount){
//                     sum+=coins[i];
//                 answer++;
                
//             }
//             if(sum==amount){
//                 return answer;
//             }
//             if(amount<0){ return -1;}
//             if(amount==0){
//                 return 0;
//             }
//             System.out.println(sum);
//             for(int j=i-1;j>=0;j--){
//                while(sum+coins[j]<amount){
//                  if(sum+coins[j]==amount){
//                     answer++;
//                     return answer;
//                 }
                
//                }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i=0; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                int wt = coins[j];
                if (i-wt >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-wt] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}