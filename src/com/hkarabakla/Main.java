package com.hkarabakla;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        String input = "({}[({})])";
        checkBrackets(input, true);

        System.out.println("");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Your input (in order to quit press 'q'): ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("q")) {
                return;
            } else {
                checkBrackets(input, true);
            }
        }
    }

    private static void checkBrackets(final String input, final boolean printDebugLog) {
        HashMap<Character, Character> brackets = new HashMap<>(6);
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Stack<Character> walkThroughStack = new Stack<>();

        IntStream.range(0, input.length())
                .forEach(index -> {

                    if (printDebugLog) {
                        System.out.println(String.format("Step: %d, Bracket: %s, Stack: %s", index + 1, input.charAt(index), walkThroughStack));
                    }

                    if (walkThroughStack.empty()) {
                        walkThroughStack.push(input.charAt(index));
                    } else if (walkThroughStack.peek().equals(brackets.get(input.charAt(index)))) {
                        walkThroughStack.pop();
                    } else {
                        walkThroughStack.push(input.charAt(index));
                    }
                });

        if (walkThroughStack.isEmpty()) {
            System.out.println(input + " is valid.");
        } else {
            System.out.println(input + " is not valid.");
        }
    }
}
