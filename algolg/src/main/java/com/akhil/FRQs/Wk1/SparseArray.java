package com.akhil.FRQs.Wk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.akhil.Constants;
import com.akhil.FRQs.Wk1.SparseArrayEntry;

public class SparseArray {
    private int numRows;
    private int numCols;

    private List<SparseArrayEntry> entries;

    public SparseArray() {
        entries = new ArrayList<SparseArrayEntry>();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getValueAt(int row, int col) {
        for (SparseArrayEntry i : entries)
            if (i.getRow() == row && i.getCol() == col)
                return i.getValue();
        return 0;
    }

    public void removeColumn(int col) {
        ArrayList<SparseArrayEntry> newCols = new ArrayList<>();
        for (int i=0; i < entries.size(); i++) {
            if (entries.get(i).getCol() == col) {
                entries.remove(i);
                i--;
            }
            else if (entries.get(i).getCol() > col) {
                int r = entries.get(i).getRow();
                int c = entries.get(i).getCol() - 1;
                int v = entries.get(i).getValue();
                newCols.add(new SparseArrayEntry(r, c, v));
                entries.remove(i);
                i--;
            }
        }
        for (SparseArrayEntry i : newCols) {
            entries.add(i);
        }
        this.numCols--;
    }

    public void addEntry(SparseArrayEntry entry) {
        entries.add(entry);
        if (entry.getRow() > (numRows-1))
            numRows = entry.getRow()+1;
        if (entry.getCol() > (numCols-1))
            numCols = entry.getCol()+1;
    }

    public String toString() {
        int array[][] = new int[numRows][numCols];
        String output = "";
        for (int[] i : array) {
            for (int j : i) {
                j = 0;
            }
        }
        for (SparseArrayEntry i : entries) {
            array[i.getRow()][i.getCol()] = i.getValue();
        }
        for (int[] i : array) {
            for (int j : i) {
                if (j != 0) {
                    output += Constants.ANSI_GREEN + j + Constants.ANSI_RESET + " ";
                }
                else {
                    output += j + " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        SparseArray sparse_array = new SparseArray();
        int r, c, v, i;

        for (i=0; i < 5; i++) {
            r = (int) (Math.random()*5+1);
            c = (int) (Math.random()*5+1);
            v = (int) (Math.random()*5+1);
            sparse_array.addEntry(new SparseArrayEntry(r, c, v));
        }

        System.out.println("Randomly Generated Sparse Array\n" + sparse_array);

        String input = "";
        boolean done = false;
        while (!done) {
            if (!(sparse_array.getNumRows() > 1) || !(sparse_array.getNumCols() > 1)) {
                break;
            }
            Scanner a = new Scanner(System.in);
            System.out.println("Type 'EXIT' to exit");
            System.out.println("Valid Commands: 'remove', 'get'");
            System.out.print("# ");
            input = a.nextLine();
            switch (input) {
                case "remove":
                    System.out.print("Which column? ");
                    sparse_array.removeColumn(a.nextInt());
                    System.out.println(sparse_array);
                    break;
                case "get":
                    System.out.print("Format: 'row,col' ");
                    String[] coords = a.nextLine().split(",");
                    System.out.println(
                        sparse_array.getValueAt(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]))
                    );
                    break;
                case "EXIT":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

}
