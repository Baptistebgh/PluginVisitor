import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXMLHandler extends DefaultHandler{
   //Nous nous servirons de cette variable plus tard
   private String node = null;

   //d�but du parsing
   public void startDocument() throws SAXException {
      System.out.println("D�but du parsing");
   }
   //fin du parsing
   public void endDocument() throws SAXException {
      System.out.println("Fin du parsing");
   }
   
   /**
    * Red�finition de la m�thode pour intercepter les �v�nements
    */
   public void startElement(String namespaceURI, String lname,
         String qname, Attributes attrs) throws SAXException {
      
      System.out.println("---------------------------------------------");
      //cette variable contient le nom du n�ud qui a cr�� l'�v�nement
      System.out.println("qname = " + qname);
      node = qname;
         
      //Cette derni�re contient la liste des attributs du n�ud
      if (attrs != null) {
         for (int i = 0; i < attrs.getLength(); i++) {
            //nous r�cup�rons le nom de l'attribut
            String aname = attrs.getLocalName(i);
            //Et nous affichons sa valeur
            System.out.println("Attribut " + aname + " valeur : " + attrs.getValue(i));
         }
      }
   }   

   public void endElement(String uri, String localName, String qName)
         throws SAXException{
     System.out.println("Fin de l'�l�ment " + qName);       
   }
   
   /**
    * permet de r�cup�rer la valeur d'un n�ud
    */  
   public void characters(char[] data, int start, int end){   
	   
	   if(node.equals("application-class")){
      System.out.println("***********************************************");
      //La variable data contient tout notre fichier.
      //Pour r�cup�rer la valeur, nous devons nous servir des limites en param�tre
      //"start" correspond � l'indice o� commence la valeur recherch�e
      //"end" correspond � la longueur de la cha�ne
      String str = new String(data, start, end);
      System.out.println("Donn�e du n�ud " + node + " : " + str);
	   }
   }
}