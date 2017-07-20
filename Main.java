import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		FilesStructure.accept(visitCount, "D:/Users/beghinb/lutece-dev4");
		HashMap L = visitCount.getL();
		System.out.println(L);
	}

}

