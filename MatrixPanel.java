package lifeGame;

//GUI for life matrix

import javax.swing.*;
import java.awt.*;

public class MatrixPanel extends JPanel {
	
	private static int width, length;
	private static final boolean ALIVE = true;
	private JPanel[][] cells; //matrix of JPanels, each JPanel represents a cell in the game matrix
	private static GridLayout matGrid;
	
	// Contractor for matrix panel
	public MatrixPanel(LifeMatrix mat, int i, int j)
	{
		width = i; length = j;
		cells = new JPanel[width][length];
		matGrid = new GridLayout(width, length);
		setLayout(matGrid);
		
		//initiate cells - all blank with a gray border
		for (int l = 0; l < width ; l++)
			for (int k = 0; k < length; k++)
			{
				cells[l][k] = new JPanel();
				cells[l][k].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			}
		
	} // end of constructor
	
	// set grid layout so each JPanel will be either black (if representing an alive cell) or white (representing a dead cell)
	public void setPanel(LifeMatrix mat)
	{
		for (int i = 0; i < width ; i++)
		{
			for (int j = 0; j < length ; j++)
			{				
				if (mat.getCell(i, j) == ALIVE)
					cells[i][j].setBackground(Color.BLACK);
				
				else
					cells[i][j].setBackground(Color.WHITE);
				
				add(cells[i][j]);
			}
		}
	} // end of set panel
	

} // end of class
