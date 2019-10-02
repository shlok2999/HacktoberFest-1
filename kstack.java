import java.util.*;
// K stacks in one array
public class kstack {
    
    private int[] da;
    private int[] na;
    private int[] ta;
    private int free;

    kstack(int k,int cap){
        da = new int[cap];
        na = new int[cap];
        ta = new int[k];
        free = 0;
        for(int i = 0 ; i < ta.length ; i++){
            ta[i] = -1;
        }
        for(int i = 0 ; i < na.length - 1 ; i++){
            na[i] = i+1;
        }
        na[na.length-1] = -1;
    }

    void push(int i,int val){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        // Remove first from free
        int temp = free;
        free = na[free];
        na[temp] = -1;

        // Add first to stack
        na[temp] = ta[i];
        ta[i] = temp;
        da[temp] = val;

    }

    void pop(int i){
        if(isEmpty(i)){
            System.out.println("Stack is Empty");
            return;
        }
        
        // Remove first from stack
        int temp = ta[i];
        ta[i] = na[ta[i]];
        na[temp] = -1;

        // add First to free
        da[temp] = 0;
        na[temp] = free;
        free = temp;

    }

    int top(int i){
        if(isEmpty(i)){
            System.out.println("Stack is Empty");
            return -1;
        }
        return da[ta[i]];
    }

    boolean isEmpty(int i){
        return ta[i] == -1 ;
    }

    boolean isFull(){
        return free == -1;
    }

    public static void main(String[] args) {
        kstack st = new kstack(4,12);
        st.push(0,10);
        st.push(1,20);
        st.push(2,30);
        st.push(2,80);
        st.pop(1);
        st.push(3,40);
        st.push(3,50);
        st.pop(3);
        st.push(2,70);
        st.push(1,90);
        st.push(0, 100);
        st.push(1,110);
        st.push(2,120);
        st.push(3,60);
        st.push(2, 130);
        st.push(1,140);

        for(int i = 0 ; i < 4 ;i++){
            while(!st.isEmpty(i)){
                System.out.print(st.top(i)+" , ");
                st.pop(i);
            }
            System.out.println();
        }

    }

}