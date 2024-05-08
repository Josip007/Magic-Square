
public class MagicSquareFactory {

    //Siamese method
    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            System.out.println("Please, we must use odd numbers for Siamese method to work.");
            return null;
        }
        MagicSquare square = new MagicSquare(size);

        // Declaring starting variables
        int number = 1;
        int row = 0;
        int col = size / 2;
        int n = size;

        square.placeValue(col, row, number); // Place the first number, it is in MagicSquare class

        for (number = 2; number <= n * n; number++) {
            int newRow = row - 1;
            int newCol = col + 1;

            // Wrapping newRow if it goes out of bounds
            if (newRow < 0) {
                newRow = n - 1;
            }

            // Wrapping newCol if it goes out of bounds
            if (newCol >= n) {
                newCol = 0;
            }

            // If the new cell is already filled, move down from the last filled cell
            if (square.readValue(newCol, newRow) != 0) {
                newRow = row + 1; // Move directly below the current cell
                newCol = col; // Stay in the same column
            }

            // Place the current number
            square.placeValue(newCol, newRow, number);

            // Update current position
            row = newRow;
            col = newCol;
        }

        return square;
    }
}
