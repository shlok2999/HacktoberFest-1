#include<iostream>
using namespace std;

int fun(int n)
{
    static int x=0; //Static Variable
    if(n>0)
    {
        x++;
        return fun(n-1)+x;
    }
    else
    {
        return 0;
    }
}

int main()
{
    int a=5;
    printf("%d",fun(a));
    return 0;
}

//Output -> 25
