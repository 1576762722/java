package blackJack;

import java.util.Arrays;

public class Person {
	Card[] card = new Card[12];
	int point = 0;
	int changer = 0;
	int grades = 10;
	String[] ranks = {"2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K", "A"};
	
    public void addCard(Card newcard)
    {
    	this.card[point] = newcard;
    	if(this.card[point].getRank().equals("A"))changer ++;
    	this.point ++;
    }
    
    
    public int getvalue(String rank)
    {
    	int i;
    	for(i = 0; i < ranks.length; i++)
    	{
    		if(ranks[i].equals(rank))break;
    	}
    	if(i> 8 && i < 12) i = 8;
    	else if(i == 12){
    		i = 9;
    	}
    	return i+2;
    }
	
	public int getsum()
	{
		int sum = 0;
		int change = changer;
		for(int i = 0; i < this.point; i++)
		{
			sum = getvalue(this.card[i].getRank()) + sum;
		}
		
		while(change > 0 && sum > 21 )
		{
			sum = sum - 10;
			change --;
		}
		
		return sum;
	}
    
	void display()
	{
		for(int i = 0; i < point; i++)
		System.out.print(this.card[i] + " ");
		System.out.printf("%13s\n", this.getsum());
	}
	
	public int getGrades() {
		return grades;
	}
	
	public void again()
	{
		point = 0;
		changer = 0;
	}
}
