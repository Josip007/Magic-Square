
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.*;

public class MagicSquare {

    private final int[][] square;

    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            int sumsOfRow = 0;
            for (int j = 0; j < square[i].length; j++) {
                sumsOfRow += square[i][j];
            }
            list.add(sumsOfRow);
        }
        return list;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            int sumsOfCol = 0;
            for (int j = 0; j < square[i].length; j++) {
                sumsOfCol += square[j][i];
            }
            list.add(sumsOfCol);
        }
        return list;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> list = new ArrayList<>();
        int primaryDia = 0;
        int secondaryDia = 0;

        for (int i = 0; i < square.length; i++) {
            primaryDia += square[i][i];
            secondaryDia += square[i][square.length - 1 - i];
        }

        list.add(primaryDia);
        list.add(secondaryDia);
        return list;
    }

    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (Objects.equals(numbers.get(i - 1), numbers.get(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (!Objects.equals(sums.get(i - 1), sums.get(i))) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
