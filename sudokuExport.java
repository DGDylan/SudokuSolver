import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sudokuExport {
	
	public sudokuExport() throws Exception {
		throw new Exception("Sudoku Grid and file's name must be passed in!");
	}
	
	//sudokuExport - will take in the Grid and file name and export the solution to a .csv file
	public sudokuExport(Grid puzzle, String fName) throws IOException {
		puzzle.solveSudoku(); //Solve the passed in sudoku
		StringBuilder sb = new StringBuilder(); //String builder to add values to

		//Iterate through solved puzzle and append to StringBuilder
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(puzzle.sudoku[i][j] + ""); //Append values
				if(j < puzzle.sudoku.length) { //Will add a comma after every value until its at the 9th column
					sb.append(",");
				}
			}
			sb.append("\n"); //Creates a new row
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(fName)); //Creates a new csv file
		bw.write(sb.toString()); //Will add the StringBuilder elements to the newly created csv file
		bw.close();
	}
  
}
