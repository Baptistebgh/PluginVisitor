import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;


import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;




public class Main {

	public static void main(String[] args) {
		
		
		// Creation of the Visitors
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorFiles visitFiles = new VisitorFiles();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		VisitorClass visitClass= new VisitorClass();
		VisitorPlugin visitPlugin= new VisitorPlugin();
		
		// Find Current Repertory
		String repCourant = new String(new java.io.File("").getAbsolutePath());
		int v=repCourant.length();
		
		//PluginVisitor.size=13
		repCourant=repCourant.substring(0,v-13);
		
		// Accept visitors
		FilesStructure.accept(visitSize, repCourant);
		FilesStructure.accept(visitCount, repCourant);
		FilesStructure.accept(visitStatic, repCourant);
		FilesStructure.accept(visitFiles, repCourant);
		FilesStructure.accept(visitClass, repCourant);
		FilesStructure.accept(visitPlugin,repCourant);

		
		// Creation of the HashMaps
		HashMap mapSize = visitSize.getsizeL();
		HashMap mapFile = visitFiles.getfichiers();
		HashMap mapCount = visitCount.getL();
		int T = visitStatic.getstatic();
		int C = visitClass.getclass();
		
		// 
		String[] M = visitPlugin.getplugin();
		
		String G =M[0].substring(19, M[0].length()-13)+".xml";		
		
		// JSON

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

	    System.out.printf( "\n\nJSON Classes: %s\n", jsonClass.toString(2) );


	    //SAX PARSING
	    VisitorSax xmlH = new VisitorSax();
	    try {

	    	SAXParserFactory factory = SAXParserFactory.newInstance();

	    	SAXParser parser = factory.newSAXParser();
         
         
                  
	    	parser.parse("../webapp/WEB-INF/plugins/"+G, xmlH);
	    	//parser.parse("example.xml", xmlH);
         
	    	System.out.println("Nombre de Xpages : "+xmlH.compteur);


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
	  
	  
	  	// DATABASE
	  
	  	/* Database Connection*/
      	String url = "jdbc:mysql://localhost/lutece_test2?autoReconnect=true&useUnicode=yes&characterEncoding=utf8";
      
      	
      	// Oscar
      	/*
      	String utilisateur = "root";
      	String motDePasse = "root";
      	*/
      	
      	// Baptiste
      	
      	String utilisateur = "root";
      	String motDePasse = "motdepasse";
      	
      	
      	
      	Connection connexion = null;
      	Statement statement = null;
      	int resultat =0;
      	try {

    	    try {
				Class.forName( "com.mysql.jdbc.Driver" );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

          /* Cr�ation de l'objet g�rant les requ�tes */
          statement = connexion.createStatement();
          String V =G.substring(0, G.length()-4);
          //if(statement.executeQuery("SELECT metric_value FROM lutece_visitor WHERE plugin_name='"+V+"' AND metric_type=Xpages" )==null){
          // Add Size in Database
          Set<String> L= mapSize.keySet();
          String[] S = L.toArray(new String[L.size()]);
          for(int k =0; k<S.length;k++){
        	  float h = (float)mapSize.get(S[k]);

        	  resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Size (ko)', '"+S[k]+"','"+h/1024+"');" );
      
          }
      

          // Add Line Number in Database
          Set<String> P= mapCount.keySet();
          String[] Q = P.toArray(new String[L.size()]);
          for(int k =0; k<Q.length;k++){
        	  float d = (float)mapCount.get(Q[k]);

        	  resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Line Number', '"+Q[k]+"','"+d+"');" );
      
          }
      

          // Add File Number in Database
        Set<String> FileSet= mapFile.keySet();
      	String[] QQ = FileSet.toArray(new String[L.size()]);
      	for(int k =0; k<QQ.length;k++){
      		int d = (int)mapFile.get(QQ[k]);

      		resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'File Number', '"+QQ[k]+"','"+d+"');" );
      
      	}
      	

      	// Add Number of Static Methods in Database
      	resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Number of Static Methods', '"+"Static Method"+"','"+T+"');" );
      

      	// Add Number of Classes in Database
      	resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Number of Classes', '"+"Classes"+"','"+C+"');" );
      

      	// Add Number of Xpages in Database
      	resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Number of Xpages', '"+"Xpages"+"','"+xmlH.compteur+"');" );
      
      	// Add Name of Xpages in Database
      	for(int k =0; k<xmlH.compteur;k++){
      		float d = (float)mapCount.get(QQ[k]);

      		resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Xpage Name', '"+xmlH.test[k]+"','"+(k+1)+"');" );
      	}
      	resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Number of Adminfeatures', '"+"Admin"+"','"+xmlH.nombre+"');" );
      	
      	for(int k =0; k<xmlH.nombre;k++){
      		float d = (float)mapCount.get(QQ[k]);

      		resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Admin features', '"+xmlH.test[100+k]+"','"+(k+1)+"');" );
      	}
      	
            resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Number of css-stylesheet', '"+"css"+"','"+xmlH.css+"');" );
      	
      	for(int k =0; k<xmlH.css;k++){
      		float d = (float)mapCount.get(QQ[k]);

      		resultat = statement.executeUpdate( "INSERT INTO lutece_visitor ( plugin_name, metric_name, metric_type, metric_value) VALUES ('"+V+"', 'Css-stylesheet', '"+xmlH.test[200+k]+"','"+(k+1)+"');" );
      	}

      	 }catch (SQLException e) {
    	  //TODO Auto-generated catch block
    	  e.printStackTrace();
      }
      

      finally {


          if ( statement != null ) {
              try {
                  statement.close();
              } catch ( SQLException ignore ) {
              }
          }

          if ( connexion != null ) {
              try {
                  connexion.close();
              } catch ( SQLException ignore ) {
              }
          }
	
	}

	}
}

