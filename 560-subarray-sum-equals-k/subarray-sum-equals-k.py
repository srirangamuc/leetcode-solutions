class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        current_running_sum = 0
        prefix_sums = defaultdict(int)
        prefix_sums[0] = 1
        for num in nums:
            current_running_sum += num
            diff = current_running_sum - k
            if diff in prefix_sums:
                count += prefix_sums[diff]
            prefix_sums[current_running_sum] += 1
        return count