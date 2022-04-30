
//Aufgabe 06.01 Definitionen von benötigte Klassen
/**
 * Diese Klasse repräsentiert den Baum und seine Elemente nach außen.
 * 
 * @author serefbolat
 *
 */
public class StudiTree {

	private Node rootNode;

	public StudiTree() {
		rootNode = null;
	}

	public static void main(String[] args) {
		Studi s1 = new Studi("Egon", 5);
		Studi s2 = new Studi("Charles", 3);
		Studi s3 = new Studi("Heinz", 8);
		Studi s4 = new Studi("Bob", 2);
		Studi s5 = new Studi("Fred", 6);
		Studi s6 = new Studi("Chris", 9);

		StudiTree mStudiTree = new StudiTree();
		mStudiTree.insert(s1);
		mStudiTree.insert(s2);
		mStudiTree.insert(s3);
		mStudiTree.insert(s4);
		mStudiTree.insert(s5);
		mStudiTree.insert(s6);

		System.out.println("*****    Aufgabe 06.03C Darstellung als String - TEST ******  ");

		mStudiTree.inOrder();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("*****    Aufgabe 06.04B Contains - TEST ******  ");
		System.out.println("Ist Studi-Objekt schon vorhanden: " + mStudiTree.contains(s3));

	}

	// Aufgabe 06.02 Sortiert einfügen, implementierung insert Methode in Äußere-Klasse

	/**
	 * Diese Methode fügt Nutzlasten sortiert ein.
	 * @param _payload
	 */
	public void insert(Studi _payload) {
		Node newNode = new Node(_payload);
		if (rootNode == null)// Wenn der Baum leer ist, dann setze den neuen Knoten als Wurzel
		{
			rootNode = newNode;
		} else // Wenn der Baum nicht leer ist, dann füge den neuen Knoten ab der Wurzel ein.
		{
			rootNode.insert(_payload);
		}
	}

	// Aufgabe 06.03A Darstellung als String, implementierung inOrder Methode in Äußere-Klasse
	/**
	 * Diese Methode gibt alle Knoten-Objekte auf die Konsole aus, die der Baum
	 * beinhaltet.
	 * 
	 * @return return null wenn der Baum leer ist, wenn nicht fäng mit Wurzel an und
	 *         mach weiter.
	 */
	public void inOrder() {
		if (rootNode != null) {
			rootNode.inOrder();
		} else
			return;
	}
	// Aufgabe 06.04A Suchen in Äußere-Klasse

	/**
	 * Diese Methode sucht eingegebene Studi-Objekt ins Baum
	 * 
	 * @param _searchStudi
	 */
	public boolean contains(Studi _searchStudi) {
		if (this.rootNode == null) {
			return false;
		} else {
			return this.rootNode.contains(_searchStudi);
		}
	}
	
	//Aufgabe 06.01 Definitionen von benötigte Klassen
	/**
	 * Diese Klasse organisiert die Verknüpfungen der Nutzlasten.
	 * 
	 * @author serefbolat
	 *
	 */
	private class Node {

		/**
		 * Beschreibt die Knoten, die kleiner als Ziel-Objekt ist.
		 */
		private Node smaller;
		/**
		 * Beschreibt die Knoten, die grösser als Ziel-Objekt ist.
		 */
		private Node bigger;

		private Studi payload;

		/**
		 * @return Gib Ziel-Objekt als String zurück.
		 */

		/**
		 * 
		 * @param _payload
		 */
		public Node(Studi _payload) {
			this.payload = _payload;
			this.bigger = null;
			this.smaller = null;
		}
		
		// Aufgabe 06.04A Suchen in Innere-Klasse

		/**
		 * Diese Methode untersucht ob als Parameter gegebene Studi-Objekt
		 * ins Baum vorhanden ist.
		 * @param _searchStudi
		 * @return  Gib true wenn Studi-Objekt ins Baum vorhanden ist, wenn nicht gib false zurück.
		 */
		private boolean contains (Studi _searchStudi)
		{
			int compareResult = _searchStudi.compareTo(this.payload);
			
			if (compareResult==0) // Das heißt Studi-Objekt ist vorhanden
			{
				return true;
			}
			
			if (compareResult<0)  // Untersuch zunäcst kleinere Teilbaum
			{
				if(this.smaller==null) // Wenn kein kleine Teilbaum gibt, such nicht mehr
				{
					return false;
				}
				else // Wenn ein kleineres Teilbaum vorhanden ist such weiter ab dieses Baum
				{
					return this.smaller.contains(_searchStudi);
				}
				
			}
			
			if (compareResult>0) // Untersuch größeres Teilbaum
			{
				if (this.bigger == null) // Wenn kein kleines Teilbaum gibt, such nicht mehr.
				{ 
					return false;
				} else // Wenn ein kleineres Teilbaum vorhanden ist such weiter ab dieses Baum.
				{
					return this.bigger.contains(_searchStudi);
				}
			}		
			return false;
		}
		
		// Aufgabe 06.02 Sortiert einfügen, implementierung insert Methode in Innere-Klasse
		/**
		 * Diese Methode vergleicht die Nutzlasten mit hilfe der CompareTo Methode, dann
		 * fügt die Knoten sortiert ein.
		 * 
		 * @param _payload
		 */
		private void insert(Studi _newStudi) {
			int compareResult = _newStudi.compareTo(this.payload);

			if (compareResult == 0) // wenn compareResult 0 ist dann mach nix
			{
				return;
			}
			if (compareResult > 0) // wenn compareResult >0 ist dann vergleiche mit grössere Knoten-Objekt

			{
				if (this.bigger == null) {
					this.bigger = new Node(_newStudi);
				} else {
					this.bigger.insert(_newStudi);
				}
			}
			if (compareResult < 0) // wenn compareResult <0 ist dann vergleice mit kleinere Knoten-Objekt

			{
				if (this.smaller == null) {
					this.smaller = new Node(_newStudi);
				} else {
					this.smaller.insert(_newStudi);
				}
			}

		}
		// Aufgabe 06.03A Darstellung als String, implementierung inOrder Methode in Innere-Klasse

		/**
		 * 
		 * 
		 */
		private void inOrder() {
			if (this.smaller != null) 
			{ // Wenn ein kleiner Knoten-Objekt gibt, dann fängt mit dem an.
				this.smaller.inOrder();
			}
			System.out.println(this.payload.toString());

			if (this.bigger != null) 
			{
				this.bigger.inOrder();
			}

		}

		/**
		 * 
		 * @return
		 */
		public String toString() {
			return this.payload.toString();
		}

	}

}
