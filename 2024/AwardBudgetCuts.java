/*
The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing. Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won’t be impacted.
Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).
Analyze the time and space complexities of your solution.
Example:


input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190

output: 47 # and given this cap the new grants array would be
           # [2, 47, 47, 47, 47]. Notice that the sum of the
           # new grants is indeed 190
Constraints:
[time limit] 5000ms
[input] array.double grantsArray
0 ≤ grantsArray.length ≤ 20
0 ≤ grantsArray[i]
[input] double newBudget
[output] double
 */

import java.util.*;

class AwardBudgetCuts {
    static double findGrantsCap(double[] grants, double budget) {
        double left = 0;
        double right = Arrays.stream(grants).sum();
        double ans = left;
        double epsilon = 1e-6;  // Small precision for binary search: 1 times 10 to the power -6, or 0.000001.
        
        /**
         * For floating-point numbers, we need to stop when the range becomes very narrow, 
         * because values may never become equal due to precision. 
         * So, the condition becomes while (right - left > epsilon) to terminate the search when the difference 
         * between left and right is smaller than the tolerance (epsilon).
         * 
         * Basically, left <= right may lead to endless loops, because left and right may be very close but never exactly equal
         */
        while (right-left > epsilon) {   // break the two values are "close enough" that continuing the search won't yield significantly different results.
            double mid = left + (right-left)/2;
            if (isPossible(grants, mid, budget)) {
                ans = mid;
                left = mid;  // If we increment left by 1 (as we do with integers), we might miss valid floating-point values between (mid, mid+1).
            } else {
                right = mid;
            }
        }
        // If the cap is computed as 123.45, rounding it to 123 or 124 (whole numbers) may result in grants that overshoot or undershoot the total budget
        // Rounding to 2 decimal places since Math.round(double d) for ans = 4.678 will return 5. This might be too coarse
        return Math.round(ans * 100.0) / 100.0;  
    }

    private static boolean isPossible(double[] grants, double cap, double budget) {
        double total = 0;
        for (int i=0; i<grants.length; i++) {
            total += Math.min(grants[i], cap);
        }

        return total <= budget;
    }

    public static void main(String[] args) {
        System.out.println(findGrantsCap(new double[] {2, 100, 50, 120, 1000}, 190));
    }
}
 