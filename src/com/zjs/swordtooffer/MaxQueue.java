package com.zjs.swordtooffer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> values;
    Deque<Integer> maxs;
    
    public MaxQueue() {
        values = new LinkedList<>();
        maxs = new LinkedList<>();
    }

    public int max_value() {
        if (maxs.size() == 0)
            return -1;
        return maxs.peek();
    }

    public void push_back(int value) {
        //首先将value加入到values中:
        values.offer(value);
        //根据value对最大值队列进行相应的变更；
        while (maxs.size() != 0) {
            if (value > maxs.peekLast())
                maxs.poll();
        }
        maxs.offer(value);
    }

    public int pop_front() {
        if (values.size() == 0)
            return -1;
        //首先将values队列中的元素弹出来
        int popElement = values.poll();
        //根据弹出的元素来对最大值队列进行相应的变更
        if (popElement == maxs.peek())
            maxs.poll();
        return popElement;
    }
}
