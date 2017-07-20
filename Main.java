import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorSize visitSize= new VisitorSize();
		FilesStructure.accept(visitSize, "/home/oscar/Documents/lutece-dev2/lutece-dev-example");
		FilesStructure.accept(visitCount, "/home/oscar/Documents/lutece-dev2/lutece-dev-example");
		HashMap L = visitSize.getsizeL();
		HashMap G = visitCount.getL();
		System.out.println(L);
		System.out.println(G);
	}

}

