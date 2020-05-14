import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
 * @author Peter Preinesberger
 * */
public class FragenSystem {
	
	private Map<String,ArrayList<Frage>> tab = new HashMap<String,ArrayList<Frage>>();
	private String fachName;
	
	public FragenSystem () {}
	
	public void ladeAusDatei (String datei) throws FileNotFoundException {
		File fragenFile = new File(datei);
		Scanner fileScanner = new Scanner(fragenFile);
		while(fileScanner.hasNextLine()) {
			String currentLine = fileScanner.nextLine();
			switch(currentLine) {
				case "[FACHNAME]":{fachName = fileScanner.nextLine();break;}
				case "[FRAGE]":{
					String diff = fileScanner.nextLine();
					String text = fileScanner.nextLine();
					String a1 = fileScanner.nextLine();
					String a2 = fileScanner.nextLine();
					String a3 = fileScanner.nextLine();
					String a4 = fileScanner.nextLine();
					addFrageVonSchwierigkeit(diff,new Frage(text,a1,a2,a3,a4));
					break;
				}
			}
		}
	}
	
	public Frage getFrageVonSchwierigkeit(String s) { /*"Verbraucht" eine Frage und gibt sie zurück"*/
		if(tab.containsKey(s)){
			for(int i = 0; i < tab.get(s).size();i++) {
				if(!tab.get(s).get(i).isBeantwortet()) {
					tab.get(s).get(i).setBeantwortet(true);
					return tab.get(s).get(i);
				}
			}
		}
		System.out.println("Es sind keine Fragen von Schwierigkeit " + s + " (mehr) vorhanden");
		
		return new Frage("Leer","aw1","aw2","aw3","aw4");
		
	}
	
	private void addFrageVonSchwierigkeit(String s,Frage f) { /*Fügt eine Frage hinzu*/
		if(tab.containsKey(s)) {
			tab.get(s).add(f);
		}else {
			tab.put(s, new ArrayList<Frage>());
			tab.get(s).add(f);
		}
	}

	public String getFachName() {
		return fachName;
	}

	public void setFachName(String fachName) {
		this.fachName = fachName;
	}
}
