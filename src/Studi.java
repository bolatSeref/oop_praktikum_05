//Aufgabe 06.01 Definitionen von benötigte Klassen
/**
 * Diese Klasse beschreibt die Nutzlasten der StudiTreee.
 * @author serefbolat
 *
 */
public class Studi implements java.lang.Comparable {
	
	//Name der Studi-Objekt
	private String name;
	
	//Matrikulationnummer von Studi-Objekt
	private int matriculationNumber;
	
	
	/**
	 * 
	 * @param _name
	 * @param _matriculationNumber
	 */
	public Studi (String _name, int _matriculationNumber) 
	{
		this.name=_name;
		this.matriculationNumber=_matriculationNumber;
	}
	
	
	/**
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		return this.toString().compareTo(o.toString());
	}
	
	/**
	 * 
	 * @return Name und Matrikelnummer von Studi-Objekt
	 */
	public String toString() 
	{
		return "Name ist: " + this.name + ", Matrikel Nummer ist: " + this.matriculationNumber;
	}

	
}
