#include<iostream>
using namespace std;

void fun1(int n)
{
    if(n>0)
    {
        cout<<n<<" ";
        fun1(n-1);
    }
}

int main()
{
    int x=3;
    fun1(3);
    return 0;
}


// output -> 3 2 1