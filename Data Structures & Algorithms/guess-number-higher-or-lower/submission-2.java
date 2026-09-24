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
            // find the midway then add the offset to make sure we're in the right half
            int g = ((right - left) / 2) + left;
            result = guess(g);
            if (result == 0) {
                return g;
            } else if (result == -1) {
                right = g - 1;  // if the guess was too big then change right to be smaller than the guess
            } else if (result == 1) {
                left = g + 1;   // if the guess was too big then change left to be bigger than the guess
            }
        }
        return result;
    }
    /*
    Time Complexity: O(log(n)) since it goes by half each time and shrinks the search bounds by half each iteration
    Space Complexity: O(1) only stores the guess and the search bounds
    */
}