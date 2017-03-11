
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GlossaryFile extends Glossary {

	public void generateTxtFile(String s) {

		try (FileWriter fw = new FileWriter("noweTlumaczenie.txt", true); PrintWriter pw = new PrintWriter(fw)) {

			pw.print(s + " ");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void getTranslation() {

		File plik = new File("jezyki.txt");
		try (Scanner sc = new Scanner(plik)) {
			while (sc.hasNextLine()) {
				String[] tab = sc.nextLine().split("\\.\\s");

				List<String> temporaryList = new ArrayList<>();
				for (String string : tab) {
					for (String s : string.split(" ")) {
						temporaryList.add(s);
					}

				}

				List<String> temporaryList2 = new LinkedList<>();

				String polishWord = temporaryList.stream().filter(f -> f.endsWith("_pl")).collect(Collectors.toList())
						.get(0);
				String germanWord = temporaryList.stream().filter(f -> f.startsWith("GER_"))
						.collect(Collectors.toList()).get(0);
				String frenchWord = temporaryList.stream().filter(f -> f.startsWith("FR_")).collect(Collectors.toList())
						.get(0);
				String englishWord = temporaryList.stream().filter(f -> f.startsWith("EN_"))
						.collect(Collectors.toList()).get(0);

				temporaryList2.add(englishWord.substring(3, englishWord.length()));
				temporaryList2.add(germanWord.substring(4, germanWord.length()));
				temporaryList2.add(frenchWord.substring(3, frenchWord.length()));

				addToGlossary(polishWord.substring(0, polishWord.length() - 3), temporaryList2);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void saveTranslation() {

		getMap().entrySet().stream().forEach(f -> {
			generateTxtFile(f.getKey().toUpperCase());
			f.getValue().forEach(v -> {
				generateTxtFile(v.toUpperCase());
				generateTxtFile("\n");
			});

		});

	}

}
