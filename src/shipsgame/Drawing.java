/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

public class Drawing {
    
    public Drawing()
    {
    
    }
    
    public void drawMap(int [][] table, int n, int m)
     {           
            System.out.println("    1   2   3   4   5   6   7   8   9  10");
            System.out.println("  -----------------------------------------");
            for(int i=1; i< n-1; i++)
                {
                    System.out.print((char)(64+i)+" | ");
                    for(int j=1; j< m-1; j++)
                        {
                            if(table[i][j]==0)
                                System.out.print((char)32 + " | ");
                            if(table[i][j]==1)
        			System.out.print("X | ");
                            if(table[i][j]==2)
        			System.out.print("* | ");
                        }
    		
            System.out.println("");
            System.out.println("  -----------------------------------------");
                }
     }
    
    public  void drawBattle(int [][] table1, int [][] table2, int [][]table3, int n, int m)
    {
	System.out.println("    1   2   3   4   5   6   7   8   9  10             1   2   3   4   5   6   7   8   9  10");
	System.out.println("  -----------------------------------------         -----------------------------------------");
	for(int i=1; i< n-1; i++)
	{
		System.out.print((char)(64+i)+" | ");
		for(int j=1; j< m-1; j++)
		{
                    if(table1[i][j]+table2[i][j]==0)
			System.out.print((char)32 + " | ");
                    if(table1[i][j]+table2[i][j]==1)
    			System.out.print("X | ");
                    if(table1[i][j]+table2[i][j]==2)
    			System.out.print("* | ");
                    if(table1[i][j]+table2[i][j]==4)
			{
    			System.out.print("@ | ");
                        }
		}
		System.out.print("      "+(char)(64+i)+" | ");
		for(int j=1; j< m-1; j++)
		{
                    if(table3[i][j]==0)
			System.out.print((char)32 + " | ");
                    if(table3[i][j]==2)
    			System.out.print("* | ");
                    if(table3[i][j]==3)
    			System.out.print("X | ");
		}
		System.out.println("");
		System.out.println("  -----------------------------------------         -----------------------------------------");
		
	}
    }
    
     
}
