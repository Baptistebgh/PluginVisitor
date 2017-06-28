import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class LineCountTest {
	
	
	public void Compteur(String docPath) throws IOException{
		
		int count = 0;
		
		//FileInputStream fis = new FileInputStream(doc);
		FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			System.out.println("Nombre de lignes : " + count);
		}
		
	
	
	
	public static void main(String[] args) throws IOException{
		
		
        //Compteur("D:/Users/beghinb/Desktop/LineCount.txt");
		int count = 0;
		
		FileInputStream fis = new FileInputStream("D:/Users/beghinb/Desktop/Tp Example/lutece-dev/usage.txt");
		//FileInputStream fis = new FileInputStream(docPath);

		LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		
		while ((l.readLine())!=null) 
			{
				count = l.getLineNumber();
			}
			System.out.println("Nombre de lignes : " + count);
	}
		
}



