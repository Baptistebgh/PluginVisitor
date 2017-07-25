import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.omg.CORBA.portable.InputStream;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorFiles visitFiles = new VisitorFiles();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		VisitorClass visitClass= new VisitorClass();
		FilesStructure.accept(visitSize, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitCount, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitStatic, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitFiles, "/home/oscar/Documents/lutece-dev2");
		FilesStructure.accept(visitClass, "/home/oscar/Documents/lutece-dev2");
		HashMap L = visitSize.getsizeL();
		HashMap F = visitFiles.getfichiers();
		HashMap G = visitCount.getL();
		int T = visitStatic.getstatic();
		int C = visitClass.getclass();
		System.out.println(L);
		System.out.println(G);
		System.out.println(" Il y a "+T+" méthodes static dans ce dossier");
		System.out.println(F);
		System.out.println(" Il y a "+C+" class dans ce dossier");
		
		
	}

}

