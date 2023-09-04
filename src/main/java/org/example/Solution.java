package org.example;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final double EPSILON = 1e-6;

    public String find24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        String result = findExpression(nums);
        return result == null ? "Can not get 24" : result;
    }

    private String findExpression(List<Double> nums) {
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0) - 24) < EPSILON) {
                return String.valueOf(nums.get(0));
            }
            return null;
        }

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            next.add(nums.get(k));
                        }
                    }

                    for (String operation : new String[]{"+", "-", "*", "/"}) {
                        for (double result : calculate(nums.get(i), nums.get(j), operation)) {
                            next.add(result);
                            String expression = "(" + nums.get(i) + " " + operation + " " + nums.get(j) + ")";
                            String subExpression = findExpression(next);
                            if (subExpression != null) {
                                return expression + subExpression;
                            }
                            next.remove(next.size() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    private List<Double> calculate(double a, double b, String operation) {
        List<Double> results = new ArrayList<>();
        if (operation.equals("+")) {
            results.add(a + b);
        } else if (operation.equals("-")) {
            results.add(a - b);
            results.add(b - a);
        } else if (operation.equals("*")) {
            results.add(a * b);
        } else if (operation.equals("/")) {
            if (Math.abs(b) > EPSILON) {
                results.add(a / b);
            }
            if (Math.abs(a) > EPSILON) {
                results.add(b / a);
            }
        }
        return results;
    }
}
