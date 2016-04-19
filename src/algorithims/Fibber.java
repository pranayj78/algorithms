/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithims;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pranay
 */
public class Fibber {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int fib(int n) {

        // edge case
        if (n < 0) {
            throw new IllegalArgumentException("Index was negative. No such thing as a negative index in a series.");

        // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }

        // see if we've already calculated this
        if (memo.containsKey(n)) {
            System.out.println("grabbing memo[" + n + "]");
            return memo.get(n);
        }

        System.out.println("computing fib(" + n + ")");
        int result = fib(n-1) + fib(n-2);

        // memoize
        memo.put(n, result);

        return result;
    }
}
