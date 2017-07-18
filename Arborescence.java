import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Arborescence {

	//Prend en param�tre le chemin
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
	
	public static String recurseDirs(String repertoire, StringBuffer b, int[] L, float [] G){
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
					
					
					
					recurseDirs(repertoire+"/" +list[i], b, L,G);
					
				}
				else{
					
					// tous les fichiers que l'on ignore dans le d�compte	
					if(!list[i].startsWith(".") && !list[i].startsWith("target") && !list[i].endsWith(".otf") && !list[i].endsWith(".eot") && !list[i].endsWith(".svg") && !list[i].endsWith(".ttf") && !list[i].endsWith(".woff")
							&& !list[i].endsWith(".woff2") && !list[i].endsWith(".gif") && !list[i].endsWith(".png") && !list[i].endsWith(".jpg") && !list[i].endsWith(".jpeg") && !list[i].endsWith(".ico") && !list[i].endsWith(".log")){
						
					b.append(repertoire+"/"+list[i]).append("\r\n");
					
					try {
						if(list[i].endsWith(".java")){
					    L[1]=L[1]+StringCompteur(repertoire+"/"+list[i]);
						L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
						System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
						G[0]=G[0]+var.length();
						G[1]=G[1]+var.length();
						}
						else if(list[i].endsWith(".html")){
						    L[2]=L[2]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[2]=G[2]+var.length();
							}
						else if(list[i].endsWith(".sql")){
						    L[3]=L[3]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[3]=G[3]+var.length();
							}
						else if(list[i].endsWith(".properties")){
						    L[4]=L[4]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[4]=G[4]+var.length();
							}
						else if(list[i].endsWith(".xml")){
						    L[5]=L[5]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[5]=G[5]+var.length();
							}
						else if(list[i].endsWith(".md")){
						    L[6]=L[6]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[6]=G[6]+var.length();
							}
						else if(list[i].endsWith(".txt")){
						    L[7]=L[7]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[7]=G[7]+var.length();
							}
						else if(list[i].endsWith(".jsp")){
						    L[8]=L[8]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[8]=G[8]+var.length();
							}
						else if(list[i].endsWith(".css")){
						    L[9]=L[9]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[9]=G[9]+var.length();
							}
						else if(list[i].endsWith(".xslt")){
						    L[10]=L[10]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[10]=G[10]+var.length();
							}
						else if(list[i].endsWith(".js")){
						    L[11]=L[11]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[11]=G[11]+var.length();
							}
						else if(list[i].endsWith(".sh")){
						    L[12]=L[12]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[12]=G[12]+var.length();
							}
						else if(list[i].endsWith(".xsl")){
						    L[13]=L[13]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[13]=G[13]+var.length();
							}
						else if(list[i].endsWith(".launch")){
						    L[14]=L[14]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[14]=G[14]+var.length();
							}
						else if(list[i].endsWith(".jar")){
						    L[15]=L[15]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[15]=G[15]+var.length();
							}
						else if(list[i].endsWith(".war")){
						    L[16]=L[16]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[16]=G[16]+var.length();
							}
						else if(list[i].endsWith(".class")){
						    L[17]=L[17]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[17]=G[17]+var.length();
							}
						else if(list[i].endsWith(".map")){
						    L[18]=L[18]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[18]=G[18]+var.length();
							}
						else{
							L[25]=L[25]+StringCompteur(repertoire+"/"+list[i]);
							L[0]=L[0]+StringCompteur(repertoire+"/"+list[i]);
							System.out.println("Le fichier "+repertoire+"/"+list[i]+" contient "+StringCompteur(repertoire+"/"+list[i])+" lignes.");
							G[0]=G[0]+var.length();
							G[25]=G[25]+var.length();
						}
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
						
					
				}
				
			}
			
		}
		}
		
		return ("Le projet contient en tout: "+L[0]+" lignes  et a une taille de "+G[0]/1024+ "ko dont " + L[1]+" lignes en .java qui font "+G[1]/1024+"ko, "+L[2]+" lignes en .html qui font "+G[2]/1024+"ko, "
		+L[3]+" lignes en .sql qui font "+G[3]/1024+"ko, "+L[4]+" lignes en .properties qui font "+G[4]/1024+"ko, "+L[5]+" lignes en .xml qui font "+G[5]/1024+"ko, "+L[6]+" lignes en .md qui font "+G[6]/1024+"ko, "
		+L[7]+" lignes en .txt qui font "+G[7]/1024+"ko, "+L[8]+" lignes en .jsp qui font "+G[8]/1024+"ko, "+L[9]+" lignes en .css qui font "+G[9]/1024+"ko, "+L[10]+" lignes en .xslt qui font "+G[10]/1024+"ko, "
		+L[11]+" lignes en .js qui font "+G[11]/1024+"ko, "+L[12]+" lignes en .sh qui font "+G[12]/1024+"ko, "+L[13]+" lignes en .xsl qui font "+G[13]/1024+"ko, "+L[14]+" lignes en .launch qui font "+G[14]/1024+"ko, "
		+L[25]+" lignes de fichiers sans extension qui font "+G[25]/1024+"ko, "+L[15]+" lignes en .jar qui font "+G[15]/1024+"ko, "+L[16]+" lignes en .war qui font "+G[16]/1024+"ko, "+L[17]+" lignes en .class qui font "+G[17]/1024+"ko, "
		+L[18]+" et lignes en .map qui font "+G[18]/1024+"k0.");
		
	}

	public static void main (String[] args){
		int[] lesfichiers = new int[40];
		float [] taille= new float [40];
		StringBuffer fichiers = new StringBuffer();
		System.out.println(recurseDirs("/home/oscar/nouveau tp/lutece-dev-example", fichiers, lesfichiers, taille));
		
	}

}