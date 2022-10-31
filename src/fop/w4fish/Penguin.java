package fop.w4fish;

public class Penguin extends MiniJava {

    public static int visitedField = 5;

    public static int[][] landMovesArr = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static int[][] iceMovesArr = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };
    public static int[][] waterMovesArr = { { 3, 3 }, { -3, 3 }, { 3, -3 }, { -3, -3 } };

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {

        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                switch (world[i][j]) {
                    case 0:
                        System.out.print("L");
                        break;
                    case 1:
                        System.out.print("I");
                        break;
                    case 2:
                        System.out.print("W");
                        break;
                    case 3:
                        System.out.print("S");
                        break;
                    case 4:
                        System.out.print("F");
                        break;
                    default:
                        break;
                }
                if (i == pinguColumn && j == pinguRow) {
                    System.out.print("(P)");
                }
                if (j < world[i].length - 1) {
                    System.out.print("\t");
                }

            }
            System.out.println();
        }
    }

    public static boolean landMoves(int[][] world, int pinguRow, int pinguColumn) {
        for (int i = 0; i < landMovesArr.length; i++) {
            if (pinguColumn + landMovesArr[i][1] >= 0 && pinguColumn + landMovesArr[i][1] < world.length
                    && pinguRow + landMovesArr[i][0] >= 0 && pinguRow + landMovesArr[i][0] < world[0].length
                    && world[pinguColumn + landMovesArr[i][1]][pinguRow + landMovesArr[i][0]] != visitedField
                    && world[pinguColumn + landMovesArr[i][1]][pinguRow + landMovesArr[i][0]] != 3) {
                if (isFishReachable(world, pinguRow + landMovesArr[i][0], pinguColumn + landMovesArr[i][1])) {
                    return true;

                }

            }
        }
        return false;
    }

    public static boolean waterMoves(int[][] world, int pinguRow, int pinguColumn) {
        for (int i = 0; i < waterMovesArr.length; i++) {
            if (pinguColumn + waterMovesArr[i][1] >= 0 && pinguColumn + waterMovesArr[i][1] < world.length
                    && pinguRow + waterMovesArr[i][0] >= 0 && pinguRow + waterMovesArr[i][0] < world[0].length
                    && world[pinguColumn + waterMovesArr[i][1]][pinguRow + waterMovesArr[i][0]] != visitedField
                    && world[pinguColumn + waterMovesArr[i][1]][pinguRow + waterMovesArr[i][0]] != 3) {
                if (isFishReachable(world, pinguRow + waterMovesArr[i][0], pinguColumn + waterMovesArr[i][1])) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean iceMoves(int[][] world, int pinguRow, int pinguColumn) {
        for (int i = 0; i < iceMovesArr.length; i++) {
            if (pinguColumn + iceMovesArr[i][1] >= 0 && pinguColumn + iceMovesArr[i][1] < world.length
                    && pinguRow + iceMovesArr[i][0] >= 0 && pinguRow + iceMovesArr[i][0] < world[0].length
                    && world[pinguColumn + iceMovesArr[i][1]][pinguRow + iceMovesArr[i][0]] != visitedField
                    && world[pinguColumn + iceMovesArr[i][1]][pinguRow + iceMovesArr[i][0]] != 3) {

                if (isFishReachable(world, pinguRow + iceMovesArr[i][0], pinguColumn + iceMovesArr[i][1])) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        switch (world[pinguColumn][pinguRow]) {
            case 4:
                return true;
            case 0:
                world[pinguColumn][pinguRow] = visitedField;
                return landMoves(world, pinguRow, pinguColumn);
            case 1:
                world[pinguColumn][pinguRow] = visitedField;
                return iceMoves(world, pinguRow, pinguColumn);
            case 2:
                world[pinguColumn][pinguRow] = visitedField;
                return waterMoves(world, pinguRow, pinguColumn);

            default:
                break;

        }
        return false;
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * 
     * @return An example world
     */
    public static int[][] generateExampleWorldOne() {
        return new int[][] { { 2, 3, 3, 3, 3, 3 }, { 3, 0, 3, 3, 4, 3 }, { 3, 3, 3, 3, 3, 1 }, { 3, 3, 3, 0, 1, 3 },
                { 3, 3, 3, 3, 3, 3 } };
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * 
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo() {
        return new int[][] { { 0, 0, 0, 2 }, { 0, 0, 0, 1 }, { 0, 1, 3, 4 }, { 3, 4, 3, 3 } };
    }

    /**
     * You may use the main method for testing your program.
     */
    public static void main(String[] args) {
        int pinguRow = 1;
        int pinguColumn = 2;
        int[][] world = generateExampleWorldTwo();

        printWorld(world, pinguRow, pinguColumn);
        write("" + isFishReachable(world, pinguRow, pinguColumn));
    }

}
