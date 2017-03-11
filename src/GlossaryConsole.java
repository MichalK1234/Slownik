
import java.util.LinkedList;
import java.util.List;

public class GlossaryConsole extends Glossary {

	private List<String> wordsList = new LinkedList<>();

	@Override
	public void getTranslation() {

		System.out.print("Insert polish word: ");
		String polishWord = Main.sc.nextLine();

		boolean germanWord = true;
		boolean frenchWord = true;
		boolean englishWord = true;

		String germanW = "";
		String frenchW = "";
		String englishW = "";

		String wordSynonym = " ";
		String word = " ";

		do {
			do {
				System.out.print("Which translation would you like to insert (EN,GER,FR)? :");
				wordSynonym = Main.sc.nextLine();
				if ((wordSynonym.toUpperCase().matches("FR") && frenchWord)
						|| (wordSynonym.toUpperCase().matches("EN") && englishWord)
						|| (wordSynonym.toUpperCase().matches("GER") && germanWord)) {
					System.out.print("Insert word in chosen language: ");
					word = Main.sc.nextLine();
				} else {
					System.out.println("Translation already exists");
				}
			} while (!wordSynonym.toUpperCase().matches("EN|GER|FR"));

			if (wordSynonym.toUpperCase().matches("EN") && englishWord) {

				englishW = word;
				englishWord = false;

			}
			if (wordSynonym.toUpperCase().matches("GER") && germanWord) {

				germanW = word;
				germanWord = false;

			}
			if (wordSynonym.toUpperCase().matches("FR") && frenchWord) {

				frenchW = word;
				frenchWord = false;

			} else if (!wordSynonym.toUpperCase().matches("FR|EN|GER")) {
				System.out.println("Translation of selected word already exists in this language");
			}
		} while ((englishWord || frenchWord || germanWord));

		wordsList.add(englishW);
		wordsList.add(germanW);
		wordsList.add(frenchW);

		addToGlossary(polishWord, wordsList);

	}

	@Override
	public void saveTranslation() {

		boolean germanWord = true;
		boolean frenchWord = true;
		boolean englishWord = true;

		String translation = "";

		do {
			do {

				System.out.print("Which translation would you like to display (EN,GER,FR)?: ");

				translation = Main.sc.nextLine();

			} while (!translation.toUpperCase().matches("EN|FR|GER"));

			if (translation.toUpperCase().matches("EN") && englishWord) {

				System.out.println(wordsList.get(0));
				englishWord = false;

			} else if (translation.toUpperCase().matches("GER") && germanWord) {

				System.out.println(wordsList.get(1));
				germanWord = false;

			} else if (translation.toUpperCase().matches("FR") && frenchWord) {

				System.out.println(wordsList.get(2));
				frenchWord = false;

			}

		} while (englishWord || germanWord || frenchWord);

		for (String string : wordsList) {

			System.out.println(string);

		}
	}

}
