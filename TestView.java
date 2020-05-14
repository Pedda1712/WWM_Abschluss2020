import java.io.FileNotFoundException;

public class TestView {

	/*
	 * Benutzungsvorschlag:
	 * Lade die Fragen aus einer Datei mit FRAGENSYSTEM.ladeAusDatei(String name) (Baue diese wie die Datei "TestFragen" auf (ist eine Textdatei))
	 * 
	 * Benutze FRAGE = getFrageVonSchwierigkeit um eine Frage zu holen (die Methode gibt nie zweimal die selbe Frage zurück, sondern hintereinander)
	 * wenn keine Fragen einer Schwierigkeit mehr vorhanden sind , wird eine Leere Frage zurückgegeben
	 * 
	 * Jetzt kannst du entweder FRAGE.getAntwort(int antwortnummer) verwenden , oder gleich alle Fragen (Feld der Größe vier) mit 
	 * FRAGE.getAntworten() dir holen, und diese mit JBUTTON<0-3>.setText(antworten[<0-3>]) zuweisen.
	 * 
	 * Fragen ueberpruefen ca. so: boolean istRichtig = FRAGE.ueberpruefeAntwort(JBUTTON.getText()), und dann kannst du anhand des booleans
	 * den JBUTTON einfärben, Punkte vergeben/abziehen
	 * 
	 * und dann die nächste Frage laden usw..
	 * */
	
	public static void main(String[] args) {
		/*Das hier ist nur ein kleines Demonstrationsprogramm */
		FragenSystem m_sys = new FragenSystem();
		try {
			m_sys.ladeAusDatei("TestFragen");
		} catch (FileNotFoundException e) {

			System.out.println("File not found");
		}
		
		Frage f = m_sys.getFrageVonSchwierigkeit("MITTELSCHWER"); /*Hole eine neue Frage */
		System.out.println(f.getFragenText());
		System.out.println("1) "+f.getAntwort(0));
		System.out.println("2) "+f.getAntwort(1));
		System.out.println("3) "+f.getAntwort(2));
		System.out.println("4) "+f.getAntwort(3) + "\n"); /* \n ist nur da , um eine Leerzeile zu schaffen*/
		
		for(int i = 0; i<4;i++) { /*Ueberprüfe die vier Antworten der Frage auf ihre richtigkeit (bei einer muss true stehen)*/
			System.out.println("Überprüfe Antwort <" + f.getAntwort(i) + "> :" + f.ueberpruefeAntwort(f.getAntwort(i)));
		}
		
	}
}
