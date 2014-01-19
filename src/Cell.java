public class Cell {
    private int cell[][] = new int[10][10];
    private int totalMines = 10;
    private int mine = 9;

    public void fillCells() {
        int random, row, column;
        while (totalMines > 0) {
            random = (int) (Math.random() * 99);
            row = random / 10;
            column = random % 10;
            totalMines = setMineOnCell(row, column, totalMines);
        }
    }

    public int setMineOnCell(int row, int column, int totalMines) {
        if (cell[row][column] != mine) {
            cell[row][column] = mine;
            totalMines = totalMines - 1;
        }
        return totalMines;
    }

    private void countAdjacentMines(int row, int column) {
        Element elements = new Element();
        elements.setMinMax(row);
        elements.checkFirst(row);
        elements.checkLast(row);

        for (int i = elements.getMin(); i <= elements.getMax(); i++)
            setLocalMinesCount(i, column);
    }

    private void setLocalMinesCount(int row, int column) {
        Element elements = new Element();
        elements.setMinMax(column);
        elements.checkFirst(column);
        elements.checkLast(column);

        for (int j = elements.getMin(); j <= elements.getMax(); j++)
            if (cell[row][column] != mine)
                cell[row][column] += 1;
    }

    public int getCell(int row, int column) {
        return cell[row][column];
    }
}