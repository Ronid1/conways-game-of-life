package lifeGame;

// Class representing logics of a life matrix

public class LifeMatrix {
	
	private static final boolean ALIVE = true;
	private static final boolean DEAD = false;
	private static boolean[][] lifeMat; // boolean matrix used for game logic
	private static boolean[][] temp; // boolean matrix used for class functions
	private static int width, length;

	
	// Constructor for a i*j life matrix 
	public LifeMatrix(int i, int j)
	{
		width = i; length = j;
		lifeMat = new boolean[width][length];
	}
	
	// set one  matrix cell to live or dead
	public void setCell(int i, int j, boolean state)
	{
		lifeMat[i][j] = state;
	}
	
	public boolean getCell(int i, int j)
	{
		return lifeMat[i][j];
	}
	
	// Get matrixes next generation
	public void nextGeneration()
	{
		temp = new boolean[width][length];
		
		//Iterate over matrix and find next generation by game rules. make changes in temp matrix.
		for (int i = 0; i < width ; i++)
		{
			for (int j = 0; j < length; j++)
			{
				int count = this.countNeighbors(i,j);
				
				if (lifeMat[i][j] == ALIVE)
				{
					if (count < 2 || count > 3)
						temp[i][j] = DEAD;

					else if (count == 2 || count == 3)
						temp[i][j] = ALIVE;
				}
				
				else
				{
					if (count == 3)
						temp[i][j] = ALIVE;

					else
						temp[i][j] = DEAD;
				}

			}//for loop 2
		}//for loop 1
		
		//copy new generation from temp matrix to game matrix
		for (int i = 0; i < width ; i++)
		{
			for (int j = 0; j < length; j++)
			{
				if (temp[i][j] == ALIVE)
					lifeMat[i][j] = ALIVE;
				
				else
					lifeMat[i][j] = DEAD;;
			}
		}
		
	}//end of nextGeneration
	
	//return number of alive neighbors for mat[i][j]
	private int countNeighbors(int i, int j)
	{
		int count = 0;
		
		if (i-1 >= 0 && lifeMat[i-1][j] == ALIVE)
			count++;
		
		if (i-1 >= 0 && j-1 >= 0 && lifeMat[i-1][j-1] == ALIVE )
			count++;
		
		if (i-1 >= 0 && j+1 < length && lifeMat[i-1][j+1] == ALIVE )
			count++;
		
		if (i+1 < width && lifeMat[i+1][j] == ALIVE)
			count++;
		
		if ( i+1 < width && j-1 >= 0 && lifeMat[i+1][j-1] == ALIVE )
			count++;
		
		if ( i+1 < width && j+1 < length && lifeMat[i+1][j+1] == ALIVE)
			count++;
		
		if (j+1 < length && lifeMat[i][j+1] == ALIVE)
			count++;
		
		if (j-1 >= 0 && lifeMat[i][j-1] == ALIVE )
			count++;
		
		
		return count;
	}
}
