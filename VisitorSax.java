

import org.xml.sax.Attributes;

import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;


public class VisitorSax extends DefaultHandler{

   public int compteur=0;
   public int nombre=0;
   public int css=0;
   public int jvs=0;
   public int portlet=0;
   
   public String[] test = new String[3000];

   //Nous nous servirons de cette variable plus tard

   private String node = null;
  


   //début du parsing

   public void startDocument() throws SAXException {

   }

   //fin du parsing

   public void endDocument() throws SAXException {

      

   } 
   
   
   /**

    * Redéfinition de la méthode pour intercepter les événements

    */

   public void startElement(String namespaceURI, String lname,

         String qname, Attributes attrs) throws SAXException {

      

     // System.out.println("---------------------------------------------");

      //cette variable contient le nom du nœud qui a créé l'événement

      //System.out.println("qname = " + qname);

      node = qname;

         

      //Cette dernière contient la liste des attributs du nœud

      if (attrs != null) {

         for (int i = 0; i < attrs.getLength(); i++) {

            //nous récupérons le nom de l'attribut

            String aname = attrs.getLocalName(i);

            //Et nous affichons sa valeur

            //System.out.println("Attribut " + aname + " valeur : " + attrs.getValue(i));

         }

      }

   }   


   public void endElement(String uri, String localName, String qName)

         throws SAXException{

     //System.out.println("Fin de l'élément " + qName);       

   }
   
   public void characters(char[] ch, int start, int end) throws SAXException {

	   
	   
	   if (node.equals("application-class")) {
	   compteur+=1;
	   test[compteur-1] =new String(ch, start, end);
       System.out.println("Nom de la Xpage n°" + compteur + ": "+test[compteur-1]);
       node="";
	   }
     //  System.out.println("Nombre de Xpages : " + compteur);
       
       else if (node.equals("feature-id")){
    	   nombre=nombre+1;
    	   test[100+nombre-1]= new String(ch, start, end);
    	   System.out.println("Nom de l'adminfeature n°" + nombre + ": "+test[100+nombre-1]);
    	   node="";
       }
	   
       else if(node.equals("css-stylesheet")){
    	   css=css+1;
    	   test[200+css-1]= new String(ch, start, end);
    	   System.out.println("Nom de la feuille de style n°" + css + ": "+test[200+css-1]);
    	   node="";
       }
	   
       else if(node.equals("javascript-file")){
    	   jvs=jvs+1;
    	   test[300+jvs-1]= new String(ch, start, end);
    	   System.out.println("Nom de la feuille de style n°" + jvs + ": "+test[300+jvs-1]);
    	   node="";
       }
       else if(node.equals("portlet-class")){
    	   portlet=portlet+1;
    	   test[400+portlet-1]= new String(ch, start, end);
    	   System.out.println("Nom de la portlet n°" + portlet + ": "+test[400+portlet-1]);
    	   node="";
       }
       

      
       
	   }


}