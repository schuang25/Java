import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random rand = new Random();

    public int[] getTenRolls() {
        int[] rolls = new int[10];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = rand.nextInt(20) + 1;
        }
        return rolls;
    }

    public char getRandomletter() {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return alphabet[rand.nextInt(26)];
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomletter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList();
        for (int i = 0; i < length; i++)
            passwords.add(generatePassword());
        return passwords;
    }
}
