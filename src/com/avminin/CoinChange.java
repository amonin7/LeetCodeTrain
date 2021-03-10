package com.avminin;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] change = new int[amount + 1];
        change[0] = 0;
        boolean isArrayChanged = false;
        for (int i = 0; i < coins.length; ++i) {
            if (coins[i] > amount) {
                continue;
            } else if (coins[i] == amount) {
                return 1;
            }
            change[coins[i]] = 1;
            isArrayChanged = true;
        }
        if (!isArrayChanged) {
            return -1;
        }
        for (int i = 1; i < amount + 1; ++i) {
            int current = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                if (change[i - coin] == -1) {
                    continue;
                }
                if (current > (change[i - coin] + 1)) {
                    current = (change[i - coin] + 1);
                }
            }
            if (current == Integer.MAX_VALUE) {
                change[i] = -1;
            } else {
                change[i] = current;
            }
        }
        return change[amount];
    }
}
