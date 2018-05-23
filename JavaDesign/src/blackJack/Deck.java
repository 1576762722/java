package blackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Card{
	private char color;
	private String rank;
	
	public Card(char color, String rank) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(color) + rank;
	}
	
	public char getColor() {
		return color;
	}
	
	public String getRank() {
		return rank;
	}
	
	
}

public class Deck {
	
	Card[] card = new Card[52];
	
	public Deck() {
		// TODO Auto-generated constructor stub
		char[] colors = {'\u2660', '\u2665', '\u2663', '\u2666'};
		String[] ranks = {"2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K", "A"};
		
		int k = 0;
		for(int i = 0; i < colors.length; i++)
			for(int j = 0; j < ranks.length; j++)
			{
				card[k] = new Card(colors[i], ranks[j]);
				k++;
			}
		List<Card> list = Arrays.asList(card);
		Collections.shuffle(list);
		System.out.println("已经洗好牌了");
	}
}
