import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;



public class VisitorStatic implements Visitor{

	int total=0;
	public void visit(String docPath) throws IOException {
		

		
		FileReader fileReader = new FileReader(docPath);;
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line =bufferedReader.readLine() ;
		while (line != null) {
			line=line.trim();
         if(line.startsWith("public static")){
        	 total=total+1;
         }
			line = bufferedReader.readLine();
		}
	}
	

	public int getstatic() {

		return total;
	}
	

}