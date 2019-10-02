import java.util.*;

public class minstack{
    Stack<Integer> st ;
    int min;
    minstack(){
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    void push(int val){
        if(st.size()==0){
            st.push(val);
            min = val;
        } else if(val>=min){
            st.push(val);
        } else {
            st.push(val + val - min);
            min = val;
        }
    }

    int size(){
        return st.size();
    }

    int top(){
        if(st.size()==0){
            System.out.println("Empty");
            return -1;
        } else if(st.peek()>=min){
            return st.peek();
        } else {
            return min;
        }
    }

    int min(){
        if(st.size()==0){
            System.out.println("Empty");
            return -1;
        } else {
            return min;
        }
    }

    void pop(){
        if(st.size()==0){
            System.out.println("Empty");
            return ;
        } else if(st.peek()>=min){
            st.pop();
        } else {
            min=2*min-st.peek();
            st.pop();
        }
    }

    public static void main(String[] args) {
        minstack st = new minstack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(5);

        while(st.size()>0){
            System.out.println(st.top() + " " + st.min());
            st.pop();
        }


    }

}