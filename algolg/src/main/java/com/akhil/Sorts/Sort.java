package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class Sort {
    protected Queue<Integer> data = new Queue<>();
    
    public void generateData() {
        for (int i=0; i<data.size(); i++) {
            data.enqueue( (int) (Math.random()*1000) );
        }
    }

}
