

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Glossary {

	private Map<String, List<String>> map;
	

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public Glossary() {
		map = new HashMap<>();
	}

	public void showMapContent() {

		map.entrySet().forEach(f -> {

			System.out.println(f.getKey() + " " + f.getValue());
			
		});

	}

	public void addToGlossary(String s, List<String> list) {

		map.put(s, list);
	}

	

	@Override
	public String toString() {
		return "Glossary [map=" + map + "]";
	}

	public abstract void getTranslation();

	public abstract void saveTranslation();

}
