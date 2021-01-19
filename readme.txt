Main class:
-First I instantiate two Grid objects that pass in the file name of the specific Grids
-Then I instantiate two sudokuExport objects that will export the finished sudoku puzzles

Grid class:
-Within the grid class, I take in the file name("example.csv")
-First I read each number of grid(including null values) into an ArrayList. After that I replaced all null values with 0.
-After this I call the listTo2D method that converts the ArrayList into a 9x9 2D string array. (I was not sure how to directly read the csv file into a 2D array)
-After the 2D array was filled in, I converted it into an int array to make it easier to work with the test functions
-Now that the 2D array was created, I was able to work on the tests. I made methods to check the row, column, and 3x3 matrix of the 2d int array.
-To solve the puzzle, I iterated through each index of the 2d array and if the index was 0, I tested values that work and recursively backtracked until the entire puzzle was solved.

sudokuExport class:
-The default constructor throws an exception if nothing is passed in when making a sudokuExport object
-First I solve the passed in puzzle
-Next, I created a StringBuilder to append the values of the 2d array separted by commas, and starting a new line after the 9th column.
-After the StringBuilder is done the BufferedWriter uses the passed in file name and exports the StringBuilder contents to that newly created file

Notes:
-I started of with this recursive approach because it seemed to be the most intuitive way to solve the puzzle for me.(reminded me of the 8 queens algorithm) After I finished and it worked, I tried to solve it without backtracking. I tried to create an ArrayList of each candidates and then add each ArrayList to a hash map with the key being the row number * the column number of the specific candidates. However, I did not have enough time and decided to hand in the backtracking method.