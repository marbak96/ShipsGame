/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Player extends Person{
    
    private int win;
    private int loose;
    
    public Player(){
    
    }
    
    public Player(String Login) 
	{	
            try{
            File file = new File("Player "+Login+".txt");
		if(file.isFile())
                    {
			Scanner read = new Scanner(file);
			password=read.nextLine();
			login=read.nextLine();
			win=read.nextInt();
                        loose=read.nextInt();
			System.out.println("wczytano dane");	
						
                    }
		else
                    System.out.println("Błąd wczytania danych");
        }
            catch (FileNotFoundException e) 
		 {
                    //e.printStackTrace();
                     System.out.println("Nie znaleziono takiego pliku");
		 }
        }
	
	public  int getWins()
	{
            return win;
	}
	public  void increaseWins()
	{
            win++;
	}
	
	public  int getLoose()
	{
            return loose;
	}
	public  void increaseLoose()
	{
            loose++;
	}
    
}
