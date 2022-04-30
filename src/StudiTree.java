/**
 * Diese Klasse repräsentiert den Baum und seine Elemente nach außen.
 * @author serefbolat
 *
 */
public class StudiTree {
	
	private Node rootNode;
	
	public StudiTree (Node _rootNode) 
	{
		this.rootNode=_rootNode;
	}
	
	
	public void insert (Studi _payload)
	{
			
		if (rootNode==null)// Wenn der Baum leer ist, dann setze den neuen Knoten als Wurzel
		{
			rootNode=new Node(_payload);
		}
		else // Wenn der Baum nicht leer ist, dann füge den neuen Knoten ab der Wurzel ein.
		{
			rootNode.insert();
		}
	}
	
	
	/**
	 * Diese Klasse organisiert die Verknüpfungen der Nutzlasten.
	 * @author serefbolat
	 *
	 */
	public class Node {
		
		
		
		/**
		 * Beschreibt die Knoten, die kleiner als Ziel-Objekt ist.
		 */
		private Node smaller;
		/**
		 *  Beschreibt die Knoten, die grösser als Ziel-Objekt ist.
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
		public Node (Studi _payload) 
		{
			this.payload=_payload;
		}
		
		
		public void insert()
		{
			
		}
		
		/**
		 * 
		 * @return 
		 */
		public String toString() 
		{
			return this.toString();
		}
		
		
	}


}
