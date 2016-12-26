class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> num_map;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            map<int,int>::iterator it = num_map.find(complement);
            if (it != num_map.end()) {
                result.push_back(it->second);
                result.push_back(i);
                return result;
            }
            num_map.insert(pair<int, int>(nums[i], i));
        }
        return result;
    }
};