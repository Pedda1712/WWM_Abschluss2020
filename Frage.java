/*
 * @author Peter Preinesberger
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
public class Frage {
	
	private String[] antworten; /*Speichert die möglichen Antworten antworten[0] ist immer richtig*/
	//private String[] shuffled_antworten;
	private String fragenText;
	private boolean beantwortet = false;
	/*
	 * f -> Fragentext
	 * a1 -> richtige Antwort
	 * a2,a3,a4 -> falsche Antworten
	 * */
	public Frage (String f , String a1, String a2,String a3,String a4){ /*Wenn  die Frage direkt initialisiert werden soll*/
		fragenText = f;
		antworten = new String[4];
		antworten[0] = a1;
		antworten[1] = a2;
		antworten[2] = a3;
		antworten[3] = a4;
		/*
        shuffled_antworten = new String[4];
		shuffled_antworten[0] = a1;
		shuffled_antworten[1] = a2;
		shuffled_antworten[2] = a3;
		shuffled_antworten[3] = a4;
		
        List<String> antwortenList = Arrays.asList(shuffled_antworten);
        Collections.shuffle(antwortenList);
        antwortenList.toArray(shuffled_antworten);
        
	*/
	}
	
	public boolean ueberpruefeAntwort (String a) { /*Ueberprueft die Richtigkeit von a und markiert die Frage als beantwortet*/
		if(a.equals(antworten[0])) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Frage () { /*Wenn die Frage später initialisiert wird*/
		antworten = new String[4];
	}
	
	public String getFragenText() { /*gibt den FragenText als String zurück*/
		return fragenText;
	}
	
	public String[] getAntworten () { /*gibt ein Feld der Größe vier mit den enthaltenen Fragen zurück (das solltest du benutzen und dann die Antworten random zuweisen)*/
		return antworten;
	}
	
	public String[] getShuffledAntworten () {
        String[] shuffled_antworten = antworten.clone();
        List<String> antwortenList = Arrays.asList(shuffled_antworten);
        Collections.shuffle(antwortenList);
        antwortenList.toArray(shuffled_antworten);
        
        return  shuffled_antworten;
        
	}
	
	public void setAntworten (String[] n_antworten) {
		antworten = n_antworten;
	}
	
	public String getAntwort(int i) {
		
		if(i < 4 && i >= 0) {
			return antworten[i];
		}else {
			return "Fehler:( getAntwort(int i) <Pro Frage sind nur 4 Antworten vorhanden> in Frage " + fragenText;
		}
	}
	
	public void setAntwort(int i , String n_a) {
		if(i < 4 && i >= 0) {
			antworten[i] = n_a;
		}
		else {
			System.out.println("Fehler: (setAntwort(int i , String n_a)) <pro Frage sind nur 4 Fragen vorhanden> in Frage " + fragenText);
		}
	}

	public boolean isBeantwortet() {
		return beantwortet;
	}

	public void setBeantwortet(boolean beantwortet) {
		this.beantwortet = beantwortet;
	}

}
