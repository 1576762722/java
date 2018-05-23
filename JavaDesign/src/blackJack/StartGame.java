package blackJack;

import java.util.Scanner;

public class StartGame {
	
	public static void menu()
	{
		System.out.println("*****************************");
		System.out.printf("%13s\n","1.游戏介绍");
		System.out.printf("%13s\n","2.游戏开始");
		System.out.printf("%13s\n","3.退出游戏");
		System.out.println("*****************************");
	}
	
	public static void introGrame()
	{
		System.out.println("游戏介绍略");
	}
	
	public static void perGame(Dealer dealer, Player player)
	{
		int point = 0;
		
		Deck deck = new Deck();
		System.out.println("start game");
		
		
		dealer.addCard(deck.card[point]);
		point ++;
		dealer.addCard(deck.card[point]);
		point ++;
		System.out.print("庄家牌:");
//		dealer.display();
		dealer.dealerDisplay();
		
		
		player.addCard(deck.card[point]);
//		player.addCard(new Card('\u2660', "A"));
		point ++;
		player.addCard(deck.card[point]);
		point ++;
		System.out.print("玩家牌:");
		player.display();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("input Y/N:");
		String option = sc.nextLine();
		while(option.equalsIgnoreCase("Y"))
		{
			player.addCard(deck.card[point]);
			point ++;
			player.display();
			if(player.getsum() >= 21)break;
			System.out.print("input Y/N:");
			option = sc.nextLine();
		}
		
		while(dealer.getsum() <= 16 && player.getsum() < 22)
		{
			dealer.addCard(deck.card[point]);
			point ++;
		}
		
		System.out.print("庄家牌:");
		dealer.display();
		System.out.print("玩家牌:");
		player.display();
		
		if(player.getsum() > 21) {
			System.out.println("dealer win");
			dealer.grades++;
			player.grades--;
		}else if(dealer.getsum() > 21) {
			System.out.println("player win");
			dealer.grades--;
			player.grades++;
		}else if(player.getsum() < dealer.getsum()) {
			System.out.println("dealer win");
			dealer.grades++;
			player.grades--;
		}else if(player.getsum() > dealer.getsum()) {
			System.out.println("player win");
			dealer.grades--;
			player.grades++;
		}else {
			System.out.println("peace");
		}
		System.out.println("庄家积分:");
		System.out.println(dealer.getGrades());
		System.out.println("玩家积分:");
		System.out.println(player.getGrades());
	}
	public static void main(String[] args) {
		
		int option;
		menu();
		Player player = new Player();
		Dealer dealer = new Dealer();
		do {
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			switch(option)
			{
			case 1:introGrame();break;
			case 2:perGame(dealer, player);System.out.println("继续请按2，退出请按3:"); dealer.again(); player.again();break;
			case 3:break;
			}
		}while(option!=3);
	}
}
