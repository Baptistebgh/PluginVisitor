
public class Fichier implements Visitable{

	private String file;
	

	
	Fichier(String fichier) {
		file = fichier;
	}
	
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
