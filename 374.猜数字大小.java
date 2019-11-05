/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int from = 1;
        int to = n;
        while (from != to) {
            int iguess = from + (to - from) / 2;
            int guessResult = guess(iguess);
            if (guessResult == 0) {
                return iguess;
            } else if (guessResult == -1) {
                to = iguess - 1;
            } else {
                from = iguess + 1;
            }
        }
        return to;
    }
}
// @lc code=end

