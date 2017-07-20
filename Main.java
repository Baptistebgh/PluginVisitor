import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorSize visitSize= new VisitorSize();
		FilesStructure.accept(visitSize, "/home/oscar/Documents/lutece-dev2/lutece-dev-example");
		//FilesStructure.accept(visitCount, "D:/Users/beghinb/lutece-dev4");
		HashMap L = visitSize.getsizeL();
		System.out.println(L);
	}

}

