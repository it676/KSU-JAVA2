/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stack;

/**
 *
 * @author IT676
 */
public class StackDemo {

    public static void main(String[] args) {

        int counter = 1;

        int sum = 0;
        do {

            counter = counter * 2;
            System.out.println(counter);//optional 

            sum = sum + counter;

        } while (counter < 64);

        System.out.println("Sum is : " + sum);

    }

    public static boolean isPalidnrome(String word) {

        Stack<Character> stack = new LinkedStack<>();

        word = word.toUpperCase();

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            stack.push(ch);

        }

        String wordReversed = "";

        while (!stack.isEmpty()) {

            wordReversed += stack.pop();
        }

        return (word.equals(wordReversed));

    }

}
