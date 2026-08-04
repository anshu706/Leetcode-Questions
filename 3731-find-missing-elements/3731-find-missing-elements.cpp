class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        vector<int> res;

        sort(nums.begin(), nums.end());
        int currEle = nums[0];

        for(int i = 0 ; i < nums.size() ; currEle++, i++){
            if(currEle < nums[i]){
                res.push_back(currEle);
                i--;
            }
        }

        return res;
        
    }
};