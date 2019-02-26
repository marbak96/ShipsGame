/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

import java.util.Random;
import java.util.Scanner;


public class Point {
    
    private int x;
    private int y;
	
    public Point()
    {
	this.x=0;
	this.y=0;
    }
	
    public void setPoint(int x, int y)
    {
	this.x=x;
	this.y=y;
    }
	
    public int getX()
    {
	return x;
    }
	
    public int getY()
    {
	return y;
    }
	
    public void takePointGamer(int sign)
    {
	while(true) {
            x=0;
            y=0;
            Scanner read = new Scanner(System.in);
            String tempStr;
            tempStr= read.nextLine();
            if(tempStr.equals("exit")&& sign==1) {
		x=100;
		break;
		}
            x=Character.getNumericValue(tempStr.charAt(0))-9;
            if(tempStr.length()==2 && x>0 && x<11) {
		y= Character.getNumericValue(tempStr.charAt(1));
                if(y>0 && y<11)
		    break;
            }
            else if(tempStr.length()==3 && x>0 && x<11)
            {
		y+=10* Character.getNumericValue(tempStr.charAt(1));
		y+= Character.getNumericValue(tempStr.charAt(2));
		if(y>0 && y<11)
		    break;
            }
                    System.out.println("podano zala wartosc, sprobuj jeszcze raz");		
		}   
    }

    public void takePointComputer()
    {
	Random gen = new Random();
		
	x=gen.nextInt(10)+1;
	y=gen.nextInt(10)+1;	
    }   
}
