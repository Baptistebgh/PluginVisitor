import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		VisitorCompteur visitCount = new VisitorCompteur();
		VisitorSize visitSize= new VisitorSize();
		VisitorStatic visitStatic= new VisitorStatic();
		FilesStructure.accept(visitSize, "/home/oscar/plugin-visitor/PluginVisitor/PluginVisitor");
		FilesStructure.accept(visitCount, "/home/oscar/plugin-visitor/PluginVisitor/PluginVisitor");
		FilesStructure.accept(visitStatic, "/home/oscar/plugin-visitor/PluginVisitor/PluginVisitor");
		HashMap L = visitSize.getsizeL();
		HashMap G = visitCount.getL();
		int T = visitStatic.getstatic();
		System.out.println(L);
		System.out.println(G);
		System.out.println(" Il y a "+T+" méthodes static dans ce dossier");
	}

}

