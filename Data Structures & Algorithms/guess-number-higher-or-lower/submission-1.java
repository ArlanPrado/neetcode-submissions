/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int result = n;
        while (left <= right) {
            int g = ((right - left) / 2) + left;
            result = guess(g);
            if (result == 0) {
                return g;
            } else if (result == -1) {
                right = g - 1;
            } else if (result == 1) {
                left = g + 1;
            }
        }
        return result;
    }
}