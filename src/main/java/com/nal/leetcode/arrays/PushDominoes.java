package com.nal.leetcode.arrays;

/**
 * Created by nishant on 13/03/20.
 * 838. Push Dominoes
 * here are N dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * Return a string representing the final state.
 * Example 1:
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() == 0)
            return dominoes;

        int[] force = new int[dominoes.length()];

        int counter = 0;
        for(int i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) == 'R') {
                counter = dominoes.length();
            }
            else if(dominoes.charAt(i) == 'L') {
                counter = 0;
            }
            force[i] = counter == 0 ? 0 : counter--;
        }

        counter = 0;
        for(int i = dominoes.length() - 1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') {
                counter = dominoes.length();
            }
            else if(dominoes.charAt(i) == 'R') {
                counter = 0;
            }
            force[i] -= counter == 0 ? 0 : counter--;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < force.length; i++) {
            if(force[i] > 0)
                result.append('R');
            else if(force[i] < 0)
                result.append('L');
            else
                result.append('.');
        }
        return result.toString();
    }
}
