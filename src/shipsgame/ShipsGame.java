/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShipsGame {

    enum choiceNumber{LOGOWANIE,REJESTRACJA,NOWA_GRA,WCZYTAJ_GRE,STATYSTYKI,WCZYTAJ_SAVE,ZAPIS,WYJSCIE};
            
    public static void main(String[] args) throws FileNotFoundException {
       System.out.println("Asystent gry w statki");
	    int gameResult;
            
            //EnumChoice.ChooseNumber choiceNumber = EnumChoice.ChooseNumber.ZERO;
            //choiceNumber choice=ZERO;
            //BattleShips.choiceNumber e=choiceNumber.NOWA_GRA;
	    boolean still=true;
            
	    Player player = new Player(FirstStep());
	    Game game=new Game();
	    while(still)
	    {
                //Menu();
	    switch (Menu()) {
                //switch(e){
        case 1: 
        System.out.println("Nowa gra : ");
        game=new Game();
        game.takeShips();
        game.takeComputerShipsTable();
        gameResult=game.Battle();
        if(gameResult==1)
                player.increaseLoose();
        else if(gameResult==2)
                player.increaseWins();

        		break;
                 
        /*case 2:  System.out.println("Wczytaj gre : ");
        		gameResult=game.Battle();
        		if(gameResult==1)
        			player.increaseLoose();
        		else if(gameResult==2)
        			player.increaseWins();
               break;*/
        case 3:  System.out.println("Statystyki : ");
        		WriteStatistics(player);
 				break;
          
        case 4:  System.out.println("Wczytaj save : ");
        		Scanner read = new Scanner(System.in);
        		System.out.println("Podaj nazwe Save:");
        		game=new Game(read.nextLine());
        		break;
        case 5:  System.out.println("Zapisz gre : ");
        		game.saveGame();
        		break;
        case 6:  System.out.println("Wyjście");
        		still=false;
                        
 				break;
        default: System.out.println("Nie ma takiej opcji do wyboru!");
                 break;
    }
            }
    }
    
    public static String FirstStep() throws FileNotFoundException 
	{
		int choice = 0;
		String Login, Password;
		int logIn=0;
		
		while(logIn==0){
			Scanner read = new Scanner(System.in);
			System.out.println("1. Zaloguj Się.");
			System.out.println("2. Załóż Konto.");
	      if(read.hasNextInt()) {
              choice = read.nextInt();
              }
        switch (choice) {
            case 1:  System.out.println("Wybrałes Logowanie : ");
            System.out.println("Podaj Login: ");
            Login = read.next();
            System.out.println("Podaj Haslo: ");
            Password = read.next();
            logIn=Account.LogIn(Login, Password);
            if(logIn!=0)
            return Login;
            else
                System.out.println("Zły login lub Hasło ! ");
            break;
                     
            case 2:  System.out.println("Wybrałeś Założenie Konta : ");
            Account.CreateAnAccount();
                     break;
       
            default: System.out.println("Nie ma takiej opcji do wybrania ! ");
                     break;
                        }
                                }
		return null;
	}
  
	public static int Menu()
	{
               
                Scanner read = new Scanner(System.in); 
		
		System.out.println("1. Nowa Gra");
		System.out.println("2. Wczytaj Gre");
		System.out.println("3. Statystyki");
		System.out.println("4. Wczytaj Save");
		System.out.println("5. Zapisz");
		System.out.println("6. Wyjdz");
		
		  if(read.hasNextInt())
                  {
                    return read.nextInt();
                  }
		  return 0;	 
	}
	
	public static void WriteStatistics(Player player)
	{
		System.out.println("Twoje wygrane: "+ player.getWins());
		System.out.println("Twoje przegrane: "+ player.getLoose());
	}
}
    
    

