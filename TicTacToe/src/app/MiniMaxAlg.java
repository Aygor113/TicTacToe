package app;

public class MiniMaxAlg extends Game{
	private int depth;
	private int alfa;
	private int beta;
	
	int[] minimax(char[][] array, int depth, int alfa, int beta)
	{
		int score=0;	/////////////////////////////////////////////////////
		int[] move = new int[2];

		for(int i=0; i< size; i++)
		{
			for(int j=0; j<size; j++)
				if(array[i][j] == '-')
				{
					array[i][j] = computerMark;
					int tempScore = searchMax(array, depth-1, alfa, beta);
					{
						if(tempScore < score)
						{
							score = tempScore;
							move[0] = i;
							move[1] = j;
						}
					}
				}
		}
		return move;
	}
	
	int searchMax(char[][] array, int depth, int alfa, int beta)
	{
		if(checkResult(array) == playerMark) {return 10;}
		else if(checkResult(array) == computerMark) {return -10;}
		else if(checkResult(array) == 'd') {return 0;}
		else if(depth == 0) {return 0;}
		
		int score=0;		////////////////////////////////////
		
		 for (int i = 0; i < size; i++)
	        {
	            for (int j = 0; j < size; j++)
	            {
	                if (array[i][j] == '-')
	                {
	                    array[i][j] = playerMark;
	                    score = Math.max(score, searchMin(array, depth-1, alfa, beta));
	                    array[i][j] = '-';

	                    int alfa2 = Math.max(alfa, score);
	                    if(beta<=alfa2)
	                    {
	                        break;
	                    }
	                    array[i][j] = '-';
	                }
	            }
	        }
	        return score;		
	}
	
	
	int searchMin(char[][] array, int depth, int alfa, int beta)
    {
        if (checkResult(array) == playerMark) { return 10; }
        else if (checkResult(array) == computerMark) { return -10; }
        else if (checkResult(array)  =='d') { return 0; }
        else if (depth == 0) { return 0; }

        int score = std::numeric_limits<int>::max();	//////////////////////////////

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (array[i][j] == '-')
                {
                    array[i][j] = 'o';
                    score = Math.min(wynik, seachMax(array, depth-1, alfa, beta));
                    plansza[i][j] = '-';

                    int beta2 = Math.min(beta, wynik);
                    if(beta2<=alfa)
                    {
                        break;
                    }
                }
            }
        }

        return score;
    }
}
