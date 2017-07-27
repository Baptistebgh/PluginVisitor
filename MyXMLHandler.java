import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandler extends DefaultHandler{
   
	
	int compteurXpage = 0;
	
	private String node = null;
   
   //début du parsing
   public void startDocument() throws SAXException {
      System.out.println("Début du parsing");
   }
   //fin du parsing
   public void endDocument() throws SAXException {
      System.out.println("Fin du parsing");
   }
   
   /**
    * Redéfinition de la méthode pour intercepter les événements
    */
   public void startElement(String namespaceURI, String lname,
         String qname, Attributes attrs) throws SAXException {
      
      System.out.println("---------------------------------------------");
      //cette variable contient le nom du nœud qui a créé l'événement
      System.out.println("Début de la balise = " +"<"+ qname+">");
      node = qname;
         
      //Cette dernière contient la liste des attributs du nœud
      if (attrs != null) {
         for (int i = 0; i < attrs.getLength(); i++) {
            //nous récupérons le nom de l'attribut
            String aname = attrs.getLocalName(i);
            //Et nous affichons sa valeur
            System.out.println("Attribut " + aname + " valeur : " + attrs.getValue(i));
         }
      }
   }   

   public void endElement(String uri, String localName, String qName)
         throws SAXException{
     System.out.println("Fin de la balise " + "<"+ qName+">");       
   }
   
   /**
    * permet de récupérer la valeur d'un nœud
    */  
   public void characters(char[] data, int start, int end){   
	   
	   if(node.equals("application-class")){
       System.out.println(new String(data, start, end));
       //compteurXpage+=1;
       //System.out.println(compteurXpage);
	   }
   }
}