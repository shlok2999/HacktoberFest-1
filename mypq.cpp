#include<iostream>
#include<vector>

using namespace std;

class mypq {
    vector<int> list;

    void upheapify(int idx){
        if(idx==0){
            return ;
        }
        int parent = (idx - 1)/2;
        if(isHigherPriority(idx,parent)){
            swap(list[idx],list[parent]);
            upheapify(parent);
        } 
    }

    void downheapify(int idx){
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        int hpi = idx;
        if(left < list.size() && isHigherPriority(left,hpi)){
            hpi = left;
        }
        if(right < list.size() && isHigherPriority(right,hpi)){
            hpi = right;
        }
        if(hpi!=idx){
            swap(list[idx],list[hpi]);
            downheapify(hpi);
        }
    }

    bool isHigherPriority(int i,int j){
        
        if(minormax){
            // min
            return list[i] < list[j]; 
        } else {
            // max
            return list[i] > list[j];
        }
    }

    bool minormax ;

    public:

    mypq(bool flag){
        minormax = flag;
    }

    mypq(bool flag,vector<int>& data){
        minormax = flag;
        for(int i = 0 ; i < data.size() ; i++){
            list.push_back(data[i]);
        }
        for(int i = list.size()/2 - 1 ; i >=0 ; i--){
            downheapify(i);
        }
    }

    void push(int val){
        list.push_back(val);
        upheapify(list.size()-1);
    }

    void pop(){
        swap(list[0],list[list.size()-1]);
        list.pop_back();
        downheapify(0);
    }

    int top(){
        return list[0];
    }

    int size(){
        return list.size();
    }

};

int main(int argc, char const *argv[])
{
    vector<int> data {44,10,50,60,7,2};
    mypq pq(true,data);
    while(pq.size()>0){
        cout<<pq.top()<<" ";
        pq.pop();
    }
    cout<<endl;
    return 0;
}
