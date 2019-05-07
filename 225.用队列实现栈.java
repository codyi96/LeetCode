import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (this.empty()) {
            return 0;
        }
        Queue<Integer> mainQ;
        Queue<Integer> tmpQ;
        if (!q1.isEmpty()) {
            mainQ = q1;
            tmpQ = q2;
        } else {
            mainQ = q2;
            tmpQ = q1;
        }
        while(mainQ.size() != 1) {
            tmpQ.add(mainQ.remove());
        }
        return mainQ.remove();
    }
    
    /** Get the top element. */
    public int top() {
        if (this.empty()) {
            return 0;
        }
        Queue<Integer> mainQ;
        Queue<Integer> tmpQ;
        int result = 0;
        if (!q1.isEmpty()) {
            mainQ = q1;
            tmpQ = q2;
        } else {
            mainQ = q2;
            tmpQ = q1;
        }
        while(mainQ.size() != 1) {
            tmpQ.add(mainQ.remove());
        }
        result = mainQ.remove();
        tmpQ.add(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

