package blackJack;

public class Dealer extends Person {
	
	public void dealerDisplay()
	{
		System.out.print("xx ");
		for(int i = 1; i < point; i++)
			System.out.print(this.card[i] + " ");
//		System.out.println(this.getsum());
		System.out.println();
	}
}
