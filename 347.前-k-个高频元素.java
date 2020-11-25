import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> data = new HashMap<>();
        for (int num : nums) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int num : data.keySet()) {
            int times = data.get(num);
            if (queue.size() == k) {
                if (times > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{num, times});
                }
            } else {
                queue.offer(new int[]{num, times});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
// @lc code=end

