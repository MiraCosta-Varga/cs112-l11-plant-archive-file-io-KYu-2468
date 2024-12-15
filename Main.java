
// TODO: Step 2 - Import file input statements here
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// TEST FOR STEP 1 (you can delete/comment this out after completing step 1)
		Plant test = new Plant("Stinging Nettle,65,anti-inflammatory and culinary");
		System.out.println("test plant:\n" + test + "\n\n");

		// TODO: Step 2 - Declare + initialize variables for file input here
		ArrayList<Plant> plants = new ArrayList<>();
		Scanner fileScanner = null;

		// TODO: Step 2 - Connect input stream to file (dont forget the try/catch!)
		try {
			fileScanner = new Scanner(new FileInputStream("Forage.csv"));

			// TODO: Step 2 - create loop to read through whole file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				try {
					// TODO: Step 3 - build Plant Objects and store into ArrayList
					Plant plant = new Plant(line);
					plants.add(plant);
				} catch (IllegalArgumentException e) {
					System.out.println("Skipping invalid line: " + line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: Forage.csv");
		} finally {
			if (fileScanner != null) {
				// TODO: Step 2 - close the input stream
				fileScanner.close();
			}
		}
		// TODO: Step 3 - print contents of ArrayList
		System.out.println("\nLoaded plants:");
		for (Plant plant : plants) {
			System.out.println(plant);
			System.out.println();
		}
	}
}