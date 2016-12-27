class MyStack {
    Queue<Integer> queueOne = new ArrayDeque<Integer>();
    Queue<Integer> queueTwo = new ArrayDeque<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            queueOne.offer(x);
        } else if (queueOne.isEmpty()) {
            queueOne.offer(x);
            while (!queueTwo.isEmpty()) {
                queueOne.offer(queueTwo.poll());
            }
        } else {
            queueTwo.offer(x);
            while (!queueOne.isEmpty()) {
                queueTwo.offer(queueOne.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queueOne.isEmpty()) {
            queueOne.poll();
        } else {
            queueTwo.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (!queueOne.isEmpty()) {
            return queueOne.peek();
        } else {
            return queueTwo.peek();
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}