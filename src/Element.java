public class Element {
    private int min, max;

    public int getMin() {
        return min;
    }

    public void setMinMax(int value) {
        if (value > 0 && value < 9) {
            min = value - 1;
            max = value + 1;
        }
    }

    public int getMax() {
        return max;
    }

    public void checkFirst(int value) {
        if (value == 0) {
            min = value;
            max = value + 1;
        }
    }

    public void checkLast(int value) {
        if (value == 9) {
            min = value - 1;
            max = value;
        }
    }
}