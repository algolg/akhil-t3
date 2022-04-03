package com.akhil.Sorts;

import com.akhil.DataTypes.Queue;

public class Sort {
    protected Queue<Integer> data = new Queue<>();
    
    public void generateData() {
        for (int i=0; i<10; i++) {
            // data.enqueue( (int) (Math.random()*1000) );
            data.enqueue( (int) (Math.random()*10) );
        }
    }

}
