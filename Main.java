import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import org.json.JSONArray;
import org.json.JSONObject;


public class Main {

	public static void main(String[] args) {
		
		/*
		 * String XML_PATH="/webapp/WEB-INF/plugins/";
		 * 
		 
		//Visitors
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorFiles visitFiles = new VisitorFiles();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		VisitorClass visitClass= new VisitorClass();
		VisitorPlugin visitPlugin= new VisitorPlugin();
		
		//Accept Method
		FilesStructure.accept(visitSize, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitCount, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitStatic, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitFiles, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitClass, "D:/Users/beghinb/lutece-dev4");
		FilesStructure.accept(visitPlugin, "D:/Users/beghinb/lutece-dev4/lutece-dev-example");

		//Creation of the HashMaps
		HashMap mapSize = visitSize.getsizeL();
		HashMap mapFile = visitFiles.getfichiers();
		HashMap mapCount = visitCount.getL();
		int T = visitStatic.getstatic();
		int C = visitClass.getclass();

		String[] M = visitPlugin.getplugin();
		for (int k=0; k< M.length; k++){
			if ((M[k]!=null) && k!=0){
				System.out.println(M[k].substring(12, M[k].length()-13));
			}
			else if ((M[k]!=null) && k==0){
				System.out.println(M[k]);
			}
		} 

		
		//JSON

		// Size in JSON
		JSONObject jsonSize = new JSONObject();
		Set<String> sizeSet= mapSize.keySet();
	    String[] stringSize = sizeSet.toArray(new String[sizeSet.size()]);
	    for(int k =0; k < stringSize.length;k++){
	    	Object A = mapSize.get(stringSize[k]);
		    jsonSize.put(stringSize[k], A);
	    }
	    System.out.printf( "\n\nSize: %s", jsonSize.toString(2) );
	    
	    
	    //Line Count in JSON
	    JSONObject jsonCount = new JSONObject();
		Set<String> countSet= mapCount.keySet();
	    String[] stringCount = countSet.toArray(new String[countSet.size()]);
	    for(int k =0; k < stringCount.length;k++){
	    	Object A = mapCount.get(stringCount[k]);
		    jsonCount.put(stringCount[k], A);
	    }
	    System.out.printf( "\n\nLine Count: %s", jsonCount.toString(2) );
	    
	    
	    //File Count in JSON
	    JSONObject jsonFile = new JSONObject();
		Set<String> fileSet= mapFile.keySet();
	    String[] stringFile = fileSet.toArray(new String[fileSet.size()]);
	    for(int k =0; k < stringFile.length;k++){
	    	Object A = mapFile.get(stringFile[k]);

	    	if (A.equals(1)){
	    		jsonFile.put(stringFile[k], A+" fichier");
	    	}else{
	    		jsonFile.put(stringFile[k], A+" fichiers");
	    	}
	    }
	    System.out.printf( "\n\nNumber of files: %s", jsonFile.toString(2) );
	    
	    
	  //Number of Static Class and Class in JSON
	  JSONObject jsonClass = new JSONObject();
	  jsonClass.put("Nombre de méthodes Statiques", T);
	  jsonClass.put("Nombre de classes", C);

	  System.out.printf( "\n\nJSON Classes: %s", jsonClass.toString(2) );

	  
	  //Create a JSON file
	  /*try (FileWriter file = new FileWriter("D:/Users/beghinb/PluginVisitor/FichiersJson/Size.json")) {
			try {
				file.write("Size of files : \n ");
				file.write(jsonSize.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} */
	
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         parser.parse("example.xml", new MyXMLHandler());

	      } catch (DOMException e) {
	         e.printStackTrace();
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (TransformerFactoryConfigurationError e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
		
	
	}

}

