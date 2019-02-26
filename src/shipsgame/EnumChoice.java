/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

public class EnumChoice {
    
    public enum ChooseNumber {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;
	}
    
    private ChooseNumber choiceNumber;
    
    public EnumChoice(ChooseNumber choiceNumber){
        this.choiceNumber = choiceNumber;
}
    
}

