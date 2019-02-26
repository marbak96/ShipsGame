/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsgame;

public class Checks {
    
    public Checks()
    {
    
    }
    
    
    public  int checkLeftSide(Point temporary, int length, int [] [] shipsTable) {
		int free = 0;
		int free2 = 0;

		for (int y = temporary.getY(); y > temporary.getY() - length; y--) {

			if (y >= 1 && y <= 10 && shipsTable[temporary.getX()][y] == 0) {
				free++;
			}
		}
               

		if (free == length) {
			for (int i = temporary.getX() - 1; i < (temporary.getX() + 2); i++) {
				for (int j = temporary.getY() + 1; j > temporary.getY() - length - 1; j--) {
					if (shipsTable[i][j] == 0 || shipsTable[i][j] == 9) {
						free2++;
					}
				}
			}

			if (free2 == (6 + 3 * length)) {
				return 1;
			}
		}
		return 0;
	}

	public  int checkRightSide(Point temporary, int length, int [] [] shipsTable) {
		int free = 0;
		int free2 = 0;

		for (int y = temporary.getY(); y < temporary.getY() + length; y++) {
			if (y >= 1 && y <= 10 && shipsTable[temporary.getX()][y] == 0) {
				free++;
			}
		}
		if (free == length) {
			for (int i = temporary.getX() - 1; i < (temporary.getX() + 2); i++) {
				for (int j = temporary.getY() - 1; j < temporary.getY() + length + 1; j++) {
					if (shipsTable[i][j] == 0 || shipsTable[i][j] == 9) {
						free2++;
					}
				}
			}

			if (free2 == (6 + 3 * length)) 
                        {
                            return 1;
			}
		}
		return 0;
	}

	public  int checkDownSide(Point temporary, int length, int [] [] shipsTable) {
		int free = 0;
		int free2 = 0;

		for (int x = temporary.getX(); x < temporary.getX() + length; x++) {
			if (x >= 1 && x <= 10 && shipsTable[x][temporary.getY()] == 0) {
				free++;
			}
		}

		if (free == length) {
			for (int i = temporary.getY() - 1; i < (temporary.getY() + 2); i++) {
				for (int j = temporary.getX() - 1; j < temporary.getX() + length + 1; j++) {
					if (shipsTable[j][i] == 0 || shipsTable[j][i] == 9) {
						free2++;
					}
				}
			}

			if (free2 == (6 + 3 * length)) {
				
				return 1;
			}
		}
		return 0;
	}

	public  int checkUpSide(Point temporary, int length, int [] [] shipsTable) {
		int free = 0;
		int free2 = 0;

		for (int x = temporary.getX(); x > temporary.getX() - length; x--) {
			if (x >= 1 && x <= 10 && shipsTable[x][temporary.getY()] == 0) {
				free++;
			}
		}

		if (free == length) {
			for (int i = temporary.getY() - 1; i < (temporary.getY() + 2); i++) {
				for (int j = temporary.getX() + 1; j > temporary.getX() - length - 1; j--) {
					if (shipsTable[j][i] == 0 || shipsTable[j][i] == 9) {
						free2++;
					}
				}
			}

			if (free2 == (6 + 3 * length)) {
				
				return 1;
			}
		}
		return 0;
	}
    
}