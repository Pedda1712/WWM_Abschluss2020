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
		
		Frage f = m_sys.getFrageVonSchwierigkeit(1); /*Hole eine neue Frage */
		
		String[] moegliche_antworten = f.getShuffledAntworten();
		
		System.out.println(f.getFragenText());
		System.out.println("1) "+moegliche_antworten[0]+" | "+ f.ueberpruefeAntwort(moegliche_antworten[0]));
		System.out.println("2) "+moegliche_antworten[1]+" | "+ f.ueberpruefeAntwort(moegliche_antworten[1]));
		System.out.println("3) "+moegliche_antworten[2]+" | "+ f.ueberpruefeAntwort(moegliche_antworten[2]));
		System.out.println("4) "+moegliche_antworten[3]+" | "+ f.ueberpruefeAntwort(moegliche_antworten[3])  + "\n"); /* \n ist nur da , um eine Leerzeile zu schaffen*/

		
	}
}
