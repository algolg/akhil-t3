package com.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public Queue<Object> tokenize() {
        Queue<Object> calc = new Queue<>();
        Queue<Object> output = new Queue<>();
        for (int i=0; i<this.calc.length(); i++) {
            if (!String.valueOf(this.calc.charAt(i)).equals(" ")) {
                calc.enqueue(String.valueOf(this.calc.charAt(i)));
            }
        }
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            if (isNum(i)) {
                i = fullInt("", calc);
                output.enqueue(Float.parseFloat(i));
            }
            else if (isOp(i)) {
                output.enqueue(i);
                calc.dequeue();
            }
        }
        return output;
    }

    public void calcToRPN() {
        Queue<Object> calc = tokenize();
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            if (isNum(i)) {
                output.enqueue(Float.parseFloat(i));
                calc.dequeue();
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
        }
        while (operators.size()>0) {
            output.enqueue(operators.peek());
            operators.pop();
        }
        // System.out.println(index + "\t" + output);
        // System.out.println(index + "\t" + operators);
    }

    public float compute() {
        ArrayList<String> eq = new ArrayList<>();
        while (output.size() > 0) {
            eq.add(String.valueOf(output.peek()));
            output.dequeue();
        }
        eq = process(eq);
        return Float.parseFloat(eq.get(0));
    }

    public ArrayList<String> process(ArrayList<String> eq) {
        int index = 0;
        for (String i : eq) {
            if (isOp(i)) {
                break;
            }
            index++;
        }
        // System.out.println("\n\n" + eq + "\n\n");
        eq = operate(eq, index);
        boolean done = true;
        for (String i : eq) {
            if (isOp(i)) {
                done = false;
            }
        }
        if (!done) {
            process(eq);
        }
        return eq;

    }

    public ArrayList<String> operate(ArrayList<String> eq, int index) {
        String operator = eq.get(index);
        float result = 0;
        switch (operator) {
            case "+": result = Float.parseFloat(eq.get(index-2)) + Float.parseFloat(eq.get(index-1)); break;
            case "-": result = Float.parseFloat(eq.get(index-2)) - Float.parseFloat(eq.get(index-1)); break;
            case "*": result = Float.parseFloat(eq.get(index-2)) * Float.parseFloat(eq.get(index-1)); break;
            case "/": result = Float.parseFloat(eq.get(index-2)) / Float.parseFloat(eq.get(index-1)); break;
            case "^": result = (float) Math.pow(Float.parseFloat(eq.get(index-2)), Float.parseFloat(eq.get(index-1))); break;
            case "%": result = Float.parseFloat(eq.get(index-2)) % Float.parseFloat(eq.get(index-1));
        }
        // System.out.print(result); ...
        eq.set(index, String.valueOf(result));
        eq.remove(index-1);
        eq.remove(index-2);
        return eq;
    }

    public boolean isNum(String a) {
        try {
            Float.parseFloat(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String fullInt(String num, Queue calc) {
        num += String.valueOf(calc.peek());
        calc.dequeue();
        if (calc.size()>0) {
            if (isNum(String.valueOf(calc.peek())) || calc.peek().equals(".")) {
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
            case "%": return true;
        }
        return false;
    }

    public int precedence(String a) {
        switch (a) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 3;
            case "/": return 3;
            case "^": return 4;
            case "(": return 0;
            case ")": return 0;
            case "%": return 3;
        }
        return 0;
    }

    public boolean association(String a) {
        // Right = False
        // Left = True
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            case "^": return false;
            case "(": return true;
            case ")": return true;
            case "%": return true;
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
            "Tokenized Expression:\t\t" + tokenize().formattedString() + "\n" +
            "Reverse Polish Notation:\t" + getRPN() + "\n" +
            "Computed Equation: \t\t" + compute() + "\n"
        );
    }

    public static void main(String[] args) {
        Calculator simpleMath = new Calculator("100 + 200  * 3");
        System.out.println("Simple Math\n" + simpleMath);

        Calculator parenthesisMath = new Calculator("(100 + 200)  * 3");
        System.out.println("Parenthesis Math\n" + parenthesisMath);

        Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
        System.out.println("All Math\n" + allMath);

        Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
        System.out.println("All Math2\n" + allMath2); 
        
        boolean done = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Type \"DONE\" to exit");
            System.out.print("Type an Expression: ");
            String a = sc.nextLine();
            if (a.equals("DONE")) {
                done = true;
            }
            else {
                Calculator input = new Calculator(a);
                System.out.println(input);
            }
        } while (!done);
    }
}
