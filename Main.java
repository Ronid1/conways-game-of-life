package lifeGame;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args)
	{
		
		String message = "Do you want to load next generation?"; //text for dialog panel
		
		ConwayGameOfLife game = new ConwayGameOfLife();
		game.StartGame();
		
		//show question panel
		int answer = JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
		
		while (answer == JOptionPane.YES_OPTION)
		{
			game.repaint();
			answer = JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
		}
	}

}
