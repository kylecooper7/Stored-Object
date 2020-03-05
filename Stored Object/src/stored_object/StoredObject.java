package stored_object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoredObject 
{

	private String name;
	private String type;
	private String valueAsString;
	private Object theObject;
  
	static String fileName = "";
	
	public StoredObject(Object o, String name) throws IOException 
  {
		type = o.getClass().getTypeName().toString();
		this.name = name;
		theObject = o;
		checkOutTheFile();
		
  }

	
	
	private void addToFile(Object o) {
		
	}



	private void checkOutTheFile() throws IOException {
		File theFile = new File(fileName);
		boolean skip = false;
			if(! theFile.exists()) {
				theFile.createNewFile();
				skip = true;
			}
		boolean itExists = false;
		ArrayList<String> arrStr = new ArrayList<String>();
		if(! skip) {
		
		arrStr = readLines();
		for(String s: arrStr) {
			if(s.length() > 0 && s.split(": ")[0].equals(name)) {
				itExists = true;
				theObject = getTheObject();
			}
		}
		}
		
		if(! itExists){
			arrStr.add(formatItForStorage());
			updateTextFile(arrStr);
		}
		
		
		
	}
	
	private Object getTheObject() {
		ArrayList<String> someLines = readLines();
		for(String s: someLines) {
			if(s.length() > 0 && s.split(": ")[0].equals(name)) {
				unformatItFromStorage(s);
			}
		}
		return theObject;
	}



	private void unformatItFromStorage(String theLine) {
		// this is where we code how to unformat the object, theObject, from the text file depending on its type.
		
		switch(type) {
		case "": // < the different name for the different types go here (in quotes)
			// theObject = whatever
			break;
		case " ":
			
			break;
		case "  ":
			
			break;
		case "   ":
			
			break;
	
		default:
		
		}
		

	}



	private String formatItForStorage() {
		// this is where we code how to format the object, theObject, in the text file depending on its type.
		String theString = "";
		
		switch(type) {
		case "": // < the different name for the different types go here (in quotes)
			// theString = whatever
			break;
		case " ":
			
			break;
		case "  ":
			
			break;
		case "   ":
			
			break;
	
		default:
		
		}
		
		
		
		return theString;
	}



	private static ArrayList<String> readLines()
	{
		String line = null;
		ArrayList<String> theLines= new ArrayList<String>();
		try
			{
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				while ((line = bufferedReader.readLine()) != null)
					{
						theLines.add(line);
						
					}
				bufferedReader.close();
			} catch (FileNotFoundException ex)
			{
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex)
			{
				System.out.println("Error reading file '" + fileName + "'");
			}
		
		return theLines;

	}
	
	private void updateTextFile(ArrayList<String> theLines) throws FileNotFoundException {
		String toPrint = theLines.get(0);
		for(String s: theLines) {
			toPrint += "\n";
			toPrint += s;
		}
		PrintWriter writer = new PrintWriter(fileName);
        writer.print(toPrint);
        writer.close();
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public void setTheObject(Object theObject) {
		this.theObject = theObject;
	}
	
	
	
	
}
