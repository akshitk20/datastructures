package com.practice.leetcode.daily.feb25;

public class PunishmentNumber2698_15 {

    // O(n * 2^logbase10n)
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1 ; i <=n ; i++) {
            int x = i * i;
            String str = String.valueOf(x);
            if (isPossible(i, 0, str)) {
                ans += x;
            }
        }
        return ans;
    }

    public boolean isPossible(int target, int idx, String str) {
        if (str.length() == idx) return target == 0;

        int sum = 0;
        for (int i = idx ; i < str.length() ; i++) {
            //int num = Integer.valueOf(str.substring(idx,i+1));
            sum = sum * 10 + (str.charAt(i)-'0');
            //sum += num;
            if (sum > target) return false;
            if (isPossible(target-sum, i+1, str)) {
                return true;
            }
        }
        return false;
    }


}
