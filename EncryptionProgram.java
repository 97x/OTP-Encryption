import java.sql.Array;
import java.util.*;

public class EncryptionProgram {
	private Scanner scanner;
	private Random random;
	private  ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;

	// Constructor
	EncryptionProgram() {
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList<>();
		shuffledList = new ArrayList<>();
		character = ' ';

		newKey();
		askQuestion();
	}

	private void askQuestion() {
		while(true) {
			System.out.println();
			System.out.println("[Options]:");
			System.out.println("[N]ew key, [G]et key, [E]ncrypt, [D]ecrypt, [Q]uit.");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));

			switch (response) {
				case 'N' -> newKey();
				case 'G' -> getKey();
				case 'E' -> encrypt();
				case 'D' -> decrypt();
				case 'Q' -> quit();
				default -> System.out.println("[Invalid response. Please enter N, G, E, D, or Q.]");
			}
		}
	}

	private void newKey() {

		character = ' ';
		list.clear();
		shuffledList.clear();

		// Loop through ASCII table values 32-127
		for(int i = 32; i < 127; i++) {
			list.add(character);
			character++;
		}

		// Copy of array list
		shuffledList = new ArrayList<>(list);
		// Shuffle the ArrayList
		Collections.shuffle((shuffledList));
		System.out.println("[Your key has been generated.]");
	}

	private void getKey() {
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void encrypt() {
		System.out.println("Enter a message to be encrypted: ");
		String message = scanner.nextLine();

		letters = message.toCharArray();

		// Searches for the letter in the same position in each list
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void decrypt() {
		System.out.println("Enter a message to be decrypted: ");
		String message = scanner.nextLine();

		letters = message.toCharArray();

		// Searches for the letter in the same position in each list
		for(int i = 0; i < letters.length; i++) {
			for(int j = 0; j < list.size(); j++) {
				if(letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void quit() {
		System.out.println(
				"              _                 \n" +
				"             | |                \n" +
				"             | |__  _   _  ___  \n" +
				"             | '_ \\| | | |/ _ \\ \n" +
				"  _   _   _  | |_) | |_| |  __/ \n" +
				" (_) (_) (_) |_.__/ \\__, |\\___| \n" +
				"                     __/ |      \n" +
				"                    |___/       "
		);
		System.exit(0);
	}
}
