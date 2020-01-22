package lifeGame;

import javax.swing.*;
import java.util.Random;

// Class representing Conways game of life

public class ConwayGameOfLife {
	
	private static final boolean ALIVE = true;
	private static final Random random = new Random();
	private static final int MAT_SIZE = 10;	
	private static LifeMatrix lifeMat = new LifeMatrix(MAT_SIZE,MAT_SIZE);
	JFrame frame = new JFrame("Conways Game of Life");
	private static MatrixPanel matPanel;
	
	//start a new game
	public void StartGame()
	{
		//initiate GUI
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		matPanel = new MatrixPanel(lifeMat, MAT_SIZE, MAT_SIZE);
		frame.add(matPanel);
		frame.setVisible(true);
		
		//initiate game with a random number of alive cells in random locations
		 int aliveCells =  random.nextInt(MAT_SIZE*MAT_SIZE);
		 int thisCell, x,y;

		 for (int i = 0; i < aliveCells; i++)
		 {
			 
			//find a cell to set as alive
			 thisCell = random.nextInt(MAT_SIZE*MAT_SIZE);
			 y = thisCell % MAT_SIZE;
			 x = thisCell / MAT_SIZE;

			 //if cell hasn't been set yet - set as alive
			 if (!lifeMat.getCell(x, y))
				 lifeMat.setCell(x, y, ALIVE);
			 
			//if cell has already been set - try again
			 else
				 i--;
		 }

		 // update GUI
		 matPanel.setPanel(lifeMat);
		 
	}// end of start games
	
	//get next generation of the current board
	public void repaint()
	{
		lifeMat.nextGeneration();
		matPanel.setPanel(lifeMat);
	}

}
