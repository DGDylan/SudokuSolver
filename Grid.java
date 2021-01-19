import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grid {
	
	//Variables used throughout the class
	ArrayList<String> values = new ArrayList<String>();
	String[] numbers = null;
	String[][] grid = new String[9][9];
	int[][] sudoku = new int[9][9];
	
	//Grid class that takes in the file name and reads the values into an ArrayList
	public Grid(String fName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fName));
		String line = null;
		
		//Read numbers into ArrayList
		while((line = br.readLine()) != null) {
			String[] numbers = line.split(",", -1);
			for(int i = 0; i < numbers.length; i++) {
				String number = numbers[i];
				values.add(number);
			}
		}
		
		br.close();

		//Replace null characters in ArrayList with 0
		for(int i = 0; i < values.size(); i++) {
			if(values.get(i).equals("")) {
				values.set(i, "0");
			}
		}
		
		listTo2D(); //Function call to turn list into 2D array
	}
	
	//Method to turn ArrayList of values into a 2D String array
	public void listTo2D() {
		int i = 0;
		int j = 0;
		String[][] g = new String[9][9];
		
		for(String x : values) {
			g[i][j] = x;
			j++;
			if(j > 8) {
				i++;
				j = 0;
			}
		}
		grid = g;
		
		//Turn the 2D string array into a 2D integer array
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				sudoku[r][c] = Integer.parseInt(grid[r][c]);
			}
		}	
	}	
		
	//***************************TESTS***************************
	
	//rowTest - takes in row and value, if the value shows up more than once in the same row it will return false, otherwise it will return true
	public boolean rowTest(int row, int val) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[row][i] == val) {
				return false;
			}
		}
		return true;
	}
	
	//colTest - takes in column and value, if the value shows up more than once in the same column it will return false, otherwise it will return true
	public boolean colTest(int col, int val) {
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][col] == val) {
				return false;
			}
		}
		return true;	
	}
	
	/*
	 * boxTest - will take in row, column, and value
	 * In the nested for loop we will start at the row number and column number of the specific box and then go to the last row and column of the 3x3 box using the row and col values + 3
	 * Within the 3x3 matrix, if the value shows up more than once it will return false, otherwise it will return true
	 */
	public boolean boxTest(int r, int c, int val) {
		int row = r - r  % 3;
		int col = c - c % 3;
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if(sudoku[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
	
	//ok - will combine all the tests into one function call using daisy chaining
	public boolean ok(int row, int col, int val) {
		return rowTest(row, val) && colTest(col, val) && boxTest(row, col, val);
	}
	
	/*
	 * solveSudoku - method to solve the sudoku puzzle
	 * Use a nested for loop to iterate through the 2D int array, and if the value is 0 we will use the tests on that specific index and recursively backtrack to solve the sudoku
	 */
	public boolean solveSudoku() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(sudoku[i][j] == 0) {
					for(int k = 1; k < 10; k++) { //This for loop will go from 1 -> 9 for possible candidates of the empty spot
						if(ok(i, j, k)) {
							sudoku[i][j] = k;
							if(solveSudoku()) { //Recursive call
								return true;
							}
							
							else { //If there isn't a solution, we set it back to 0 and try again
								sudoku[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true; //The sudoku will be solved by this point
	}
	
}
