
public class Main {

	public static void main(String[] args) {
		
		LineCountTest lineC = new LineCountTest();
		
		Fichier fichier = new Fichier("D:/Users/beghinb/Desktop/Tp Example/lutece-dev/usage.txt");
		
		
		System.out.println(fichier.accept(lineC));

	}

}
