import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class test {
	
	
public static void StringCompteur() throws IOException{
		
		int count = 0;
		

		File fis = new File("D:/Users/beghinb/lutece-dev4/lutece-dev-example/pom.xml");
		
		System.out.println( fis.length());
}

public static void main (String[] args){
	int count = 0;
	

	File fis = new File("D:/Users/beghinb/lutece-dev4/lutece-dev-example/target/plugin-example-1.0.0-SNAPSHOT.jar");
	
	long fisfis = (fis.length())/1000;
	System.out.println( fisfis);
}
}
