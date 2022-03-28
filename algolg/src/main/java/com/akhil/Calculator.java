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
        Queue<Object> calc = new Queue<>();
        for (int i=0; i<this.calc.length(); i++) {
            calc.enqueue(String.valueOf(this.calc.charAt(i)));
        }
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            if (!i.equals(" ")) {
                if (isInt(i)) {
                    output.enqueue(Integer.parseInt(i));
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
            calc.dequeue();
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

    public String fullInt(String num, Queue calc) {
        if (calc.size()>0) {
            if (isInt(String.valueOf(calc.peek()))) {
                num += String.valueOf(calc.peek());
                calc.dequeue();
                fullInt(num, calc);
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
        Calculator simple = new Calculator("3*4+5*6");
        simple.calcToRPN();
        System.out.println(simple.getOutput());
    }
}
