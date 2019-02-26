/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Game {
        
        private int n = 12, m = 12;
        private final int[][] gamerShips = new int[n][m];
	private final int[][] gamerShots = new int[n][m];
	private final int[][] computerShips = new int[n][m];
	private final int[][] computerShots = new int[n][m];
	private final int[] shipsSize = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
	private int gamerCounter, computerCounter;
        private final Drawing dr = new Drawing();
        private final Checks ch = new Checks();
        

	public Game() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				gamerShips[i][j] = 0;
				gamerShots[i][j] = 0;
				computerShips[i][j] = 0;
				computerShots[i][j] = 0;

			}
		}
		for (int i = 0; i < n; i++) {

			gamerShips[0][i] = 9;
			gamerShots[0][i] = 9;
			computerShips[0][i] = 9;
			computerShots[0][i] = 9;
			gamerShips[n-1][i] = 9;
			gamerShots[n-1][i] = 9;
			computerShips[n-1][i] = 9;
			computerShots[n-1][i] = 9;

			gamerShips[i][0] = 9;
			gamerShots[i][0] = 9;
			computerShips[i][0] = 9;
			computerShots[i][0] = 9;
			gamerShips[i][m-1] = 9;
			gamerShots[i][m-1] = 9;
			computerShips[i][m-1] = 9;
			computerShots[i][m-1] = 9;

		}
		gamerCounter=0;
		computerCounter=0;
	}
	
	public Game(String save) throws FileNotFoundException {
			
            
            File file = new File("Player "+save+".txt"); 
		if(file.isFile())
                    {
			Scanner read = new Scanner(file);
			for (int i = 0; i < n; i++)
                        {
                            
                            for (int j = 0; j < m; j++) 
                            {  
                                gamerShips[i][j]=read.nextInt();
                            }	
			}
			for (int i = 0; i < n; i++) 
                        {
                            for (int j = 0; j < m; j++) 
                            {
				computerShips[i][j]=read.nextInt();
                            }
			}
			for (int i = 0; i < n; i++) 
                        {
                            for (int j = 0; j < m; j++) 
                            {
				gamerShots[i][j]=read.nextInt();
                            }
			}
			for (int i = 0; i < n; i++)
                        {
                            for (int j = 0; j < m; j++)
                            {
				computerShots[i][j]=read.nextInt();
                            }
			}
			gamerCounter=read.nextInt();
			computerCounter=read.nextInt();
					
			System.out.println("Zapisano");
                    }
		else
                    System.out.println("Błąd zapisu");
		} 
        
        public void setShipsTable(Point pt, int length, int target, int [][] table)
        {
            switch (target) {
		case 1:
			for (int i = 0; i < length; i++) {
				table[pt.getX()][pt.getY() + i] = 1;
			}
			break;

		case 2:
			for (int i = 0; i < length; i++) {
				table[pt.getX() - i][pt.getY()] = 1;
			}
			break;
		case 3:
			for (int i = 0; i < length; i++) {
				table[pt.getX()][pt.getY() - i] = 1;
			}
			break;

		case 4:
			for (int i = 0; i < length; i++) {
				table[pt.getX() + i][pt.getY()] = 1;
			}
			break;
		}
        }
       
	public void takeShips() {
		Point temporary = new Point();
                dr.drawMap(gamerShips, n, m);
		int[] directionTable = new int[4];
		for (int i = 0; i < shipsSize.length; i++) {
			do {
				System.out.println("Podaj poczatek statku " + shipsSize[i] + "- elementowego");
                                temporary.takePointGamer(0);
				directionTable[0] = ch.checkRightSide(temporary, shipsSize[i], gamerShips);
				directionTable[1] = ch.checkUpSide(temporary, shipsSize[i], gamerShips);
				directionTable[2] = ch.checkLeftSide(temporary, shipsSize[i], gamerShips);
                                directionTable[3] = ch.checkDownSide(temporary, shipsSize[i], gamerShips);
				if (directionTable[0] == 0 && directionTable[1] == 0 && directionTable[2] == 0
						&& directionTable[3] == 0) {
					System.out.println("Nie mażna wstawic tutaj statku");
				}
			} while (directionTable[0] == 0 && directionTable[1] == 0 && directionTable[2] == 0
					&& directionTable[3] == 0);
			if (shipsSize[i] != 1) {
				while (true) {
					System.out.println("Wybierz kierunek statku:");
					if (directionTable[0] == 1)
						System.out.println("1. W Prawo");
					if (directionTable[1] == 1)
						System.out.println("2. W Gore");
					if (directionTable[2] == 1)
						System.out.println("3. W Lewo");
                                        if (directionTable[3] == 1)
						System.out.println("4. W Dol");

					int choice;
					Scanner read = new Scanner(System.in);
					if (read.hasNextInt()) {
						choice = read.nextInt();

						if (choice > 0 && choice < 5 && directionTable[choice - 1] == 1) {
                                                        setShipsTable(temporary, shipsSize[i], choice, gamerShips);
							break;
						} else {
							System.out.println("Niepoprawny kierunek , sprobuj jeszcze raz");
						}
					}
                                        else 
                                        {
                                            System.out.println("Nie ma takiej możliwości ! ");
					}
				}
			} else
                                setShipsTable(temporary, shipsSize[i], 1, gamerShips);
                        dr.drawMap(gamerShips, n, m);
		}

	}

        public void takeComputerShipsTable() {
            Point temporary = new Point();
            int[] directionTable = new int[4];
            for (int i = 0; i < shipsSize.length; i++) {
		do {
                        temporary.takePointComputer();
			directionTable[0] = ch.checkRightSide(temporary, shipsSize[i], computerShips);
			directionTable[1] = ch.checkUpSide(temporary, shipsSize[i], computerShips);
			directionTable[2] = ch.checkLeftSide(temporary, shipsSize[i], computerShips);
			directionTable[3] = ch.checkDownSide(temporary, shipsSize[i], computerShips);
		} while (directionTable[0] == 0 && directionTable[1] == 0 && directionTable[2] == 0
				&& directionTable[3] == 0);
		if (shipsSize[i] != 1) {
			while (true) {
				
				Random gen = new Random();
				int choice=gen.nextInt(4);
                                if (choice > 0 && choice < 5 && directionTable[choice - 1] == 1)
                                    {
                                        setShipsTable(temporary, shipsSize[i], choice, computerShips);
                                        dr.drawMap(computerShips, n, m);
					break;
                                    }
                                    }   
                                        }
		else
		   {
                        setShipsTable(temporary, shipsSize[i], 2, computerShips);
                        dr.drawMap(computerShips, n, m);
		   }
                }
        }

        public int Battle()
        {
            dr.drawBattle(gamerShips, computerShots, gamerShots, n, m);
        
            while(true)
            {
		System.out.println("Podaj punkt:");
		Point aimPoint=new Point();
                aimPoint.takePointGamer(1);
                if(aimPoint.getX()==100)
                {
                    return 0;
                }
                if(computerShips[aimPoint.getX()][aimPoint.getY()]==1)
		{
                    gamerShots[aimPoint.getX()][aimPoint.getY()]=3;
                    gamerCounter++;
		}
		else
		{
                    gamerShots[aimPoint.getX()][aimPoint.getY()]=2;
		}
		dr.drawBattle(gamerShips, computerShots, gamerShots, n, m);
		if(gamerCounter==20)
		{
                    System.out.println("WYGRANA!!!!!");
                    return 2; 	
		}
		
                aimPoint.takePointComputer();
		if(gamerShips[aimPoint.getX()][aimPoint.getY()]==1)
		{
			computerShots[aimPoint.getX()][aimPoint.getY()]=3;
			computerCounter++;
		}
		else
		{
			computerShots[aimPoint.getX()][aimPoint.getY()]=2;
		}
		dr.drawBattle(gamerShips, computerShots, gamerShots,n , m);
               
		if(computerCounter==20)
		{
			System.out.println("PRZEGRANA!!!!!");
			return 1;
		}
            }
        }

        public void save(PrintWriter save, int [] [] table,int n, int m)
        {
            for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			save.print(table[i][j]);
			save.print(" ");
		}
			
            }
            System.out.println(" ");
        }
        public void saveGame()
        {
            Scanner read = new Scanner(System.in);
            System.out.println("Podaj nazwe:");
            String record = read.nextLine();
            PrintWriter saveGame;
            try {
		saveGame = new PrintWriter("Player "+record+".txt");
		
                save(saveGame,gamerShips,n,m);
		
                save(saveGame,computerShips,n,m);
		
                save(saveGame,gamerShots,n,m);
		
                save(saveGame,computerShots,n,m);
		saveGame.print(gamerCounter);
		saveGame.print("");
		saveGame.print(computerCounter);
                saveGame.close();
            } 
            catch (FileNotFoundException e) {
		//e.printStackTrace();
                System.out.println("Nie znaleziono takiego pliku");
            }
        } 
}

