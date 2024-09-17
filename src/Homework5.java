import java.util.Stack;

public class Homework5 {

    public static void main(String[] args) {
        System.out.println(pow(8, 3));

        Integer[][] possibleMoves = new Integer[8][8];

        for (int i = 0; i < 8; i++) {
            for (int t = 0; t < 8; t++) {
                possibleMoves[i][t] = 1;
            }
        }

        horseMove(new Integer[] {0, 0}, possibleMoves, new Stack<>());
    }

    public static int pow(int i, int pow) {
        System.out.println(pow);
        if ( pow >= 1) {
            return i * pow(i, pow - 1);
        } else {
            return 1;
        }
    }

    public static void horseMove(Integer[] currentCoords, Integer[][] possibleMoves, Stack<Integer[]> previousCoords) {
        int x = currentCoords[0];
        int y = currentCoords[1];

        System.out.println("moved to " + x + " / " + y);
        printField(possibleMoves);
        if (!horseFinished(possibleMoves)) {
            if (isValidCoord(x + 1, y + 2, possibleMoves)) {
                possibleMoves[x + 1][y + 2] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x + 1, y + 2}, possibleMoves, previousCoords);
            } else if (isValidCoord(x - 1, y + 2, possibleMoves)) {
                possibleMoves[x - 1][y + 2] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x - 1, y + 2}, possibleMoves, previousCoords);
            } else if (isValidCoord(x - 2, y + 1, possibleMoves)) {
                possibleMoves[x - 2][y + 1] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x - 2, y + 1}, possibleMoves, previousCoords);
            } else if (isValidCoord(x - 2, y - 1, possibleMoves)) {
                possibleMoves[x - 2][y - 1] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x - 2, y - 1}, possibleMoves, previousCoords);
            } else if (isValidCoord(x - 1, y - 2, possibleMoves)) {
                possibleMoves[x - 1][y - 2] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x - 1, y - 2}, possibleMoves, previousCoords);
            } else if (isValidCoord(x + 1, y - 2, possibleMoves)) {
                possibleMoves[x + 1][y - 2] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x + 1, y - 2}, possibleMoves, previousCoords);
            } else if (isValidCoord(x + 2, y - 1, possibleMoves)) {
                possibleMoves[x + 2][y - 1] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x + 2, y - 1}, possibleMoves, previousCoords);
            } else if (isValidCoord(x + 2, y + 1, possibleMoves)) {
                possibleMoves[x + 2][y + 1] = 0;
                previousCoords.push(currentCoords);
                horseMove(new Integer[]{x + 2, y + 1}, possibleMoves, previousCoords);
            } else {
                Integer[] previousMove = previousCoords.pop();
                horseMove(previousMove, possibleMoves, previousCoords);
            }
        } else {
            System.out.println("I finished!");
        }

    }

    private static boolean isValidCoord(Integer x, Integer y, Integer[][] possibleMoves) {
        return x >= 0 && x < 8 && y >= 0 && y < 8 && possibleMoves[x][y] != 0;
    }

    private static boolean horseFinished(Integer[][] possibleMoves) {
        for (int i = 0; i < 8; i++) {
            for (int t = 0; t < 8; t++) {
                if (possibleMoves[i][t] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printField(Integer[][] possibleMoves) {
        for (int i = 0; i < 8; i++) {
            System.out.println("");
            for (int t = 0; t < 8; t++) {
                System.out.print(possibleMoves[i][t] +" ");
            }
        }
    }
}
