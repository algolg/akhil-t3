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
        calcToRPN();
    }

    public String tokenize() {
        Queue<Object> calc = new Queue<>();
        for (int i=0; i<this.calc.length(); i++) {
            if (!String.valueOf(this.calc.charAt(i)).equals(" ")) {
                calc.enqueue(String.valueOf(this.calc.charAt(i)));
            }
        }
        return calc.formattedString();
    }

    public void calcToRPN() {
        Queue<Object> calc = new Queue<>();
        for (int i=0; i<this.calc.length(); i++) {
            if (!String.valueOf(this.calc.charAt(i)).equals(" ")) {
                calc.enqueue(String.valueOf(this.calc.charAt(i)));
            }
        }
        int index = 0;
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            if (isInt(i)) {
                i = fullInt("", calc);
                output.enqueue(Integer.parseInt(i));
            }
            else if (isOp(i)) {
                if (operators.size() > 0) {
                    if (i.equals(")")) {
                        if (operators.size()>0) {
                            while (!operators.peek().equals("(")) {
                                output.enqueue(operators.peek());
                                operators.pop();
                            }
                            operators.pop();
                        }
                    }
                    else if (i.equals("(")) {
                        operators.push(i);
                    }
                    else {
                        if (precedence(i) > precedence(operators.peek()) || (precedence(i) >= precedence(operators.peek()) && !association(i))) {
                            operators.push(i);
                        }
                        else {
                            output.enqueue(operators.peek());
                            operators.pop();
                            operators.push(i);
                        }
                    }
                }
                else {
                    operators.push(i);
                }
                if (calc.size() > 0) {
                    calc.dequeue();
                }
            }
            else {
                calc.dequeue();
            }
            // System.out.println(index + "\t" + output);
            // System.out.println(index + "\t" + operators);
            index++;
        }
        while (operators.size()>0) {
            output.enqueue(operators.peek());
            operators.pop();
        }
        // System.out.println(index + "\t" + output);
        // System.out.println(index + "\t" + operators);
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
        num += String.valueOf(calc.peek());
        calc.dequeue();
        if (calc.size()>0) {
            if (isInt(String.valueOf(calc.peek()))) {
                num = fullInt(num, calc);
            }
        }
        return num;
    }

    public boolean isOp(String a) {
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            case "^": return true;
            case "(": return true;
            case ")": return true;
        }
        return false;
    }

    public int precedence(String a) {
        switch (a) {
            case "+": return 2;
            case "-": return 2;
            case "*": return 3;
            case "/": return 3;
            case "^": return 4;
            case "(": return 0;
            case ")": return 0;
        }
        return 0;
    }

    public boolean association(String a) {
        // Right = True
        // Left = False
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            case "^": return false;
            case "(": return true;
            case ")": return true;
        }
        return false;
    }

    public String getRPN() {
        return output.formattedString();
    }

    public String toString() {
        return (
            "\n" +
            "Original Expression:\t\t" + this.calc + "\n" +
            "Tokenized Expression:\t\t" + tokenize() + "\n" +
            "Reverse Polish Notation:\t" + getRPN() + "\n"
        );
    }

    public static void main(String[] args) {
        Calculator simple = new Calculator("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
        System.out.println(simple);
    }
}
