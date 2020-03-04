package stored_object;

public class StoredObject 
{
	static String fileName = "";
	private String name;
	private String type;
	private String value;
  
	public StoredObject(Object o, String name) 
  {
		String theList = o.getClass().getTypeName().toString();
		System.out.println(theList);
		
  }
	
	
	
	
	
	
}
