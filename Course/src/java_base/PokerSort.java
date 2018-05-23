package java_base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Card implements Comparable<Card>
{
	private char flower;
	private String num;
	
	public Card(String num, char flower) {
		// TODO Auto-generated constructor stub
		super();
		this.flower = flower;
		this.num = num;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return flower + num;
	}
	
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if(this.num == o.num)
		{
			return this.flower - o.flower;
		} else
			return this.num.compareTo(o.num);
	}
	
	public char getFlower() {
		return flower;
	}
	
	public void setFlower(char flower) {
		this.flower = flower;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
}
public class PokerSort implements Comparator<Card>{
	
	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		if(o1.getFlower() == o2.getFlower())
		{
			return o1.getNum().compareTo(o2.getNum());
		}
		else
		{
			return o1.getFlower() - o2.getFlower();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card[] pk = new Card[54];
		char[] fa = {'\u2660', '\u2665', '\u2663', '\u2666'};
		String[] na = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k"};
		int k = 0;
		for(char i:fa)
		{
			for(String j:na)
			{
				pk[k] = new Card(j,i);
				k++;
			}
		}
		pk[52] = new Card("小王",' ');
		pk[53] = new Card("大王",' ');
		
		Arrays.sort(pk);
		System.out.println(Arrays.toString(pk));
		
		List<Card> list = Arrays.asList(pk);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list,new PokerSort());
		System.out.println(list);
		
	}

}
