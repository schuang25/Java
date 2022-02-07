public class TestPuzzle {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        int[] rolls = puzzle.getTenRolls();
        for (int i = 0; i < rolls.length; i++)
            System.out.print(rolls[i] + " ");
        System.out.println();
        
        System.out.println(puzzle.getNewPasswordSet(5));
    }
}
