//Dylan Rambarran
//CS313 Project 2
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
    //Creating new Grids
		Grid easy0 = new Grid("easy0.csv");
		Grid easy1 = new Grid("easy1.csv");

    //Instantiate object to export solved sudoku to .csv file
		sudokuExport p = new sudokuExport(easy0, "easy0_solution.csv");
    sudokuExport p1 = new sudokuExport(easy1, "easy1_solution.csv");
		
	}
	
}