import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class LineCount {
	
	// Prend en paramètre le fichier
	public static void Compteur(File doc) throws IOException{
		
		int count = 0;
		
		FileInputStream fis = new FileInputStream(doc);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			System.out.println("Le fichier "+doc+" contient "+count+" lignes.");
		}
	
	//Prend en paramètre le chemin
	public static void StringCompteur(String docPath) throws IOException{
		
		int count = 0;
		
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			System.out.println("Le fichier "+docPath+" contient "+count+" lignes.");
		}
	
	
	
	public static void main(String[] args) throws IOException{
		
		// Saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le chemin du fichier :");
		String str = sc.nextLine();
		
		//Appel de la méthode
		StringCompteur(str);
		 // OU
		//Compteur(?);
	}
		
}
