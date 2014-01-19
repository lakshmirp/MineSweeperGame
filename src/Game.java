import java.io.*;

public class Game {
    public static void main(String arg[]) throws IOException {

        int row, column, option;
        Board board = new Board();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        board.displayBoard();

        while (true) {
            System.out.println("Enter the Row No:(From 0 to 9)");
            row = getUserInput(bufferedReader);
            System.out.println("Enter the Col No:(From 0 to 9)");
            column = getUserInput(bufferedReader);
            System.out.println("Do you wish to flag the cell or open it(0 to flag/1 to open)?");
            option = getUserInput(bufferedReader);

            board.checkIfCellHasMine(row, column);
            if(option == 0)
                board.flagCell(row,column);
            else
                board.calculateCellValue(row, column);

            board.displayBoard();
        }
    }

    private static int getUserInput(BufferedReader bufferedReader) throws IOException {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Please Enter a Number");
                continue;
            }
            if (value < 0 || value > 9) {
                System.out.println("Value should be in the range of 0 - 9");
                continue;
            }
            return value;
        }
    }
}