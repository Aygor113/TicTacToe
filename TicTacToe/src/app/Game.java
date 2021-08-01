package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Random;


public class Game {
	char playerMark = 'x';
	char computerMark = 'o';
	int signsToWin = 3;
	int size = 3;			// ZMIENIC na konstruktor
	char[][] tableBoard = new char[3][3];
	
	// Creates empty board
	public char[][] createEmptyArray(int size)
	{
		char[][] array = new char[size][size];
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<3; j++)
			{
				array[i][j] = ' ';
			}
		}
		return array;
	}
	
	// Returns TRUE if move is valid
	public boolean checkMove(int[] moveArr, char[][] boardArr)
	{
		boolean valid;
		if(boardArr[moveArr[0]][moveArr[1]] == ' ' )
		{
			valid = true;
		}
		else
		{
			valid = false;
		}
		return valid;
	}
	
	// Function to get players move
	public char[][] playerMove(char[][] array, char sign)
	{
		int xPos=0, yPos =0;
		// Player move
		if(sign == playerMark)
		{
			System.out.print("Enter position for your " + sign +" : ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();    // get the entire line after the prompt 
			String[] numbers = input.split(" "); // split by spaces
			xPos = Integer.parseInt(numbers[0]);
			yPos = Integer.parseInt(numbers[1]);
			
			boolean validMove = false; 
			while(validMove == false)
			{
				int[] moveArr = new int[2];
				moveArr[0] = xPos;
				moveArr[1] = yPos;
				if(checkMove(moveArr, array) == true)
				{
					array[xPos][yPos] = sign;
					validMove = true;
					break;
				}
				else
				{
					System.out.println("Move is invalid!! Try again");

				}
			}
	     //scanner.close();
		}
		
		
		// Computer move
		if(sign == computerMark)
		{
			boolean validMove = false; 
			while(validMove == false)
			{
				//MiniMaxAlg miniMax = new MiniMaxAlg();		// ??
				Random rand = new Random();
				xPos = rand.nextInt(size);
				yPos = rand.nextInt(size);
				int[] moveArr = new int[2];
				moveArr[0] = xPos;
				moveArr[1] = yPos;

				if(checkMove(moveArr, array) == true)
				{
					array[xPos][yPos] = sign;
					validMove = true;
					break;
				}
			}
		}
		/*
		int[] moveCoord = new int[2];
		moveCoord[0] = xPos;
		moveCoord[1] = yPos;

		if(checkMove(moveCoord, array))
		{
			array[xPos][yPos] = sign;
		}
		else
		{
			System.out.print("Move is invalid!! Try again");
			System.out.println("");

		}
		*/
		return array;
	}
	

	
	public void printBoard(char[][] array)
	{
			System.out.println("|-----------|");
			System.out.println("| " + array[0][0] + " | " + array[0][1] +
					" | " + array[0][2] + " |");
			System.out.println("|-----------|");
			System.out.println("| " + array[1][0] + " | " + array[1][1] +
					" | " + array[1][2] + " |");			
			System.out.println("|-----------|");
			System.out.println("| " + array[2][0] + " | " + array[2][1] +
					" | " + array[2][2] + " |");			
			System.out.println("|-----------|");
	}
	
	public char checkRows(char[][] array)
	{
		char result = '-';
		int xCounter = 0;
		int yCounter = 0;
		for(int i=0; i<3; i++)
		{
			if(array[i][0] == playerMark && array[i][1] == playerMark && array[i][2] == playerMark)
			{
				result = 'x';
				xCounter=3;
			}
			
			if(array[i][0] == computerMark && array[i][1] == computerMark && array[i][2] == computerMark)
			{
				result = 'x';
				xCounter=3;
			}
				
				if(xCounter == signsToWin)
				{
					result = 'x';
				}
				if(yCounter == signsToWin)
				{
					result = 'y';
				}
				xCounter = 0;
				yCounter = 0;
		}

		return result;
	}
	
	public char checkColumns(char[][] array)
	{
		char result = '-';
		int xCounter = 0;
		int yCounter = 0;
		for(int i=0; i<3; i++)
		{
				if(array[0][i] == 'x' && array[1][i] == 'x' && array[2][i] == 'x')
				{
					xCounter=3;
				}
	
				if(array[0][i] == computerMark && array[1][i] == computerMark && array[2][i] == computerMark)
				{
					yCounter=3;
				}
				
				if(xCounter == signsToWin)
				{
					result = 'x';
				}
				if(yCounter == signsToWin)
				{
					result = 'y';
				}
				xCounter = 0;
				yCounter = 0;
		}
		return result;
	}
	
	public char checkDiagonals(char[][] array)
	{
		char result = '-';

		if(array[0][0] == 'x' && array[1][1] == 'x' && array[2][2] == 'x')
		{
			result = 'x';
		}
		if(array[0][2] == 'x' && array[1][1] == 'x' && array[2][0] == 'x')
		{
			result = 'x';
;
		}
		if(array[0][0] == 'y' && array[1][1] == 'y' && array[2][2] == 'y')
		{
			result = 'y';
;
		}
		if(array[0][2] == 'y' && array[1][1] == 'y' && array[2][0] == 'y')
		{
			result = 'y';

		}
		//System.out.println("Result of diagonal chceck: " + result);
		return result;
	}
	
	public char checkDraw(char[][] array)
	{
		boolean draw = false;
		char result = '-';
		int takenPosCounter = 0;
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(array[i][j] != ' ')
				{
					takenPosCounter++;
				}
			}
		}
		System.out.print("ZAJETE: " + takenPosCounter);

		if(takenPosCounter == size*size)
		{
			result =  'd';
		}
		else
		{
			result =  '-';
		}
		System.out.print("WYNIK: " + takenPosCounter);
		return result;
	}
	
	public char checkResult(char[][] array)
	{
		char finalResult = '-';
		
		if(checkRows(array) != '-')
		{
			finalResult = checkRows(array);
		}
		if(checkColumns(array) != '-')
		{
			finalResult = checkColumns(array);
		}
		if(checkDiagonals(array) != '-')
		{
			finalResult = checkDiagonals(array);
		}
		if(checkDraw(array) != '-')
		{
			finalResult = checkDraw(array);
		}
		return finalResult;
	}

}
