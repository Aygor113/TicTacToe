package app;

public class main {

	public static void main(String[] args) {
		Game game = new Game();
		int size = 3;		// board dimension
		char[][] gameArray = new char[size][size];
		
		gameArray = game.createEmptyArray(size);
	//	gameArray = game.playerMove(gameArray, game.playerMark);
	//	game.printBoard(gameArray);
	//	gameArray = game.playerMove(gameArray, game.computerMark);
	//	game.printBoard(gameArray);
		
		boolean exit = false;
		while(exit != true)
		{
			System.out.println();
			game.printBoard(gameArray);
			gameArray = game.playerMove(gameArray, game.playerMark);
			if(game.checkResult(gameArray) != '-')
			{
				exit = true;
				break;
			}
			
			game.printBoard(gameArray);
			gameArray = game.playerMove(gameArray, game.computerMark);
			if(game.checkResult(gameArray) != '-')
			{
				exit = true;
				break;
			}
			game.printBoard(gameArray);
		}
		game.printBoard(gameArray);
		System.out.println("GAME IS FINISHED");
	}

}
