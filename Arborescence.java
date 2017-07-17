import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Arborescence {

	//Prend en paramètre le chemin
	public static int StringCompteur(String docPath) throws IOException{
		
		int count = 0;
		
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			
			return(count);
		}
	
	public static String recurseDirs(String repertoire, StringBuffer b, int[] L){
		File fichier = new File(repertoire);
		String list[] ={};
		StringBuffer a = new StringBuffer();
		a=a.append(" ");
		
		
		if (fichier.isDirectory())
		{
			list = fichier.list();
		
			for (int i = 0; i < list.length ; i++)
			{
				
				
				
				
				
				File var= new File(repertoire+ File.separatorChar + list[i]);
				if(var.isDirectory() && !list[i].startsWith(".") && !list[i].startsWith("target")){
					
					
					
					recurseDirs(repertoire+"/" +list[i], b, L);
					
				}
				else{
					
					// tous les fichiers que l'on ignore dans le décompte	
					if(!list[i].startsWith(".") && !list[i].startsWith("target") && !list[i].endsWith(".otf") && !list[i].endsWith(".eot") && !list[i].endsWith(".svg") && !list[i].endsWith(".ttf") && !list[i].endsWith(".woff")
							&& !list[i].endsWith(".woff2") && !list[i].endsWith(".gif") && !list[i].endsWith(".png") && !list[i].endsWith(".jpg") && !list[i].endsWith(".jpeg") && !list[i].endsWith(".ico") && !list[i].endsWith(".log")){
						
					b.append(repertoire+"/"+list[i]).append("\r\n");
					try {
						if(list[i].endsWith(".java")){
					    L[1]=L[1]+StringCompteur(repertoire+"/"+list[i]);
						L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
						System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
						}
						if(list[i].endsWith(".html")){
						    L[2]=L[2]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".sql")){
						    L[3]=L[3]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".properties")){
						    L[4]=L[4]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".xml")){
						    L[5]=L[5]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".md")){
						    L[6]=L[6]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".txt")){
						    L[7]=L[7]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".jsp")){
						    L[8]=L[8]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".css")){
						    L[9]=L[9]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".xslt")){
						    L[10]=L[10]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".js")){
						    L[11]=L[11]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".sh")){
						    L[12]=L[12]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".xsl")){
						    L[13]=L[13]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".launch")){
						    L[14]=L[14]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".jar")){
						    L[15]=L[15]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".war")){
						    L[16]=L[16]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".class")){
						    L[17]=L[17]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						if(list[i].endsWith(".map")){
						    L[18]=L[18]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							}
						else{
							L[25]=L[25]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
						}
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
						
					
				}
				
			}
			
		}
		}
		
		return ("Le projet contient en tout: "+L[0]+" lignes dont "+ L[1]+" en .java, "+L[2]+" lignes en .html, "+L[3]+" lignes en .sql, "+L[4]+" lignes en .properties, "+L[5]+" lignes en .xml, "+L[6]+" lignes en .md, "+L[7]+" lignes en .txt et "+L[8]+" lignes en .jsp, "+L[9]+" lignes en .css, "+L[10]+" lignes en .xslt, "+L[11]+" lignes en .js "+L[12]+" lignes en .sh, "+L[13]+" lignes en .xsl, "+L[14]+" lignes en .launch, "+L[25]+" lignes de fichiers sans extension."+L[15]+" lignes en .jar, "+L[16]+" lignes en .war, "+L[17]+" lignes en .class, "+L[18]+" lignes en .map");
		
	}

	public static void main (String[] args){
		int[] lesfichiers = new int[40];
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs("D:/Users/beghinb/lutece-dev-module-example-elastic/.settings", fichiers, lesfichiers));
		
	}

}