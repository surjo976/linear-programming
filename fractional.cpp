
#include<bits/stdc++.h>
using namespace std;
struct item
{
    double value,weight,unit_price;
    
};
bool cmp(item x,item y)
{
	if(x.unit_price=y.unit_price)
	{
		return x.unit_price>y.unit_price;
	}
	return false;
}

int main()
{
	int number,capacity,i;
	double total_value=0;
	cout<<"Enter items number  and capacity : ";
	cin>>number>>capacity;
	item items[number];
	cout<<"Enter weight and value : "<<endl;
	for(i=0;i<number;i++)
	{
		cin>>items[i].weight>>items[i].value;
		items[i].unit_price=items[i].value/items[i].weight;
		}
		
	sort(items,items+number,cmp);
	for(i=0;i<number&&capacity>0;i++)
	{
		if(items[i].weight<=capacity)
		{
			total_value+=items[i].value;
			capacity-=items[i].weight;
		}
		else
		{
			total_value+=items[i].unit_price*capacity;
		}
	}
	
	cout<<" Total maximum knapsack Value is : "<<total_value <<endl;
	
	cout<<" Items after sort :"<<endl;
	cout<<" weight "<<"\t"<<"Value"<<"\t"<<"Unit price"<<endl;
	for(i=0;i<number;i++)
	{
		cout<<items[i].weight<<"\t\t"<<items[i].value<<"\t\t"<<items[i].unit_price<<endl;
		
		}
	return 0;
		
}

