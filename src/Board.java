import static java.lang.Character.*;

public class Board {
    private char[][] result = new char[10][10];
    private int mine = 9;
    private Cell box = new Cell();

    public Board() {
        fillBoard();
        box.fillCells();
    }

    public void checkIfCellHasMine(int row, int column) {
        if (box.getCell(row, column) == mine) {
            System.out.println("Sorry..You stepped on a Mine...\nGame Over");
            System.exit(0);
        }
    }

    public void calculateCellValue(int row, int column) {
        int cellValue = box.getCell(row, column);
        if (cellValue != mine) {
            result[row][column] = forDigit(cellValue, 10);
        }
    }

    public void displayBoard() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void fillBoard() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                result[i][j] = '*';
            }
        }
    }

    public void flagCell(int row, int column) {
        if(result[row][column] == '*')
            result[row][column] = 'f';
        else
            System.out.println("Please enter a location which is not already opened");
    }
}