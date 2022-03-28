package com.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.akhil.DataTypes.Stack;
import com.akhil.DataTypes.Queue;

public class Calculator {
    private String calc;
    private Queue<Object> output = new Queue<>();
    private Stack<String> operators = new Stack<>();

    public Calculator(String calc) {
        this.calc = calc;
    }

    public void calcToRPN() {
        String[] calc = new String[this.calc.length()];
        for (int i=0; i<this.calc.length(); i++) {
            calc[i] = String.valueOf(this.calc.charAt(i));
        }
        int index = 0;
        for (String i : calc) {
            if (!i.equals(" ")) {
                if (isInt(i)) {
                    i = fullInt(i, index);
                    output.enqueue(Integer.parseInt(i));
                    index += i.length()-1;
                }
                if (isOp(i)) {
                    if (!operators.isEmpty()) {
                        if (precedence(i) > precedence(operators.peek())) {
                            operators.push(i);
                        }
                        else {
                            output.enqueue(operators.peek());
                            operators.pop();
                            operators.push(i);
                        }
                    }
                    else {
                        operators.push(i);
                    }
                }
            }
            index++;
        }
        if (operators.size()>0) {
            for (int i=0; i<=operators.size(); i++) {
                output.enqueue(operators.peek());
                operators.pop();
            }
        }
    }

    public boolean isInt(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String fullInt(String num, int index) {
        if (index < (calc.length()-1)) {
            if (isInt(String.valueOf(calc.charAt(index+1)))) {
                fullInt(num+String.valueOf(calc.charAt(index+1)), index+1);
            }
        }
        System.out.println(num);
        return num;
    }

    public boolean isOp(String a) {
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
        }
        return false;
    }

    public int precedence(String a) {
        switch (a) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
        }
        return 0;
    }

    public Queue<Object> getOutput() {
        return output;
    }

    public String toString() {
        return output.toString();
    }

    public static void main(String[] args) {
        Calculator simple = new Calculator("123");
        simple.calcToRPN();
        System.out.println(simple.getOutput());
    }
}
