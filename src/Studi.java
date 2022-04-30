/**
 * Diese Klasse beschreibt die Nutzlasten der StudiTreee.
 * @author serefbolat
 *
 */
public class Studi {
	
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

	
}
