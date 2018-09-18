//Tiago Kociolek
//4ºSian

import java.util.ArrayList;
public class ControleCatalogo {

	private ViewCatalogo viewCatalogo;
	ArrayList<Dragon> catalogo;
	
	public ControleCatalogo() throws InterruptedException {
		viewCatalogo = new ViewCatalogo();
		catalogo = new ArrayList<>();
		trataMenu();		
	}
	private void trataMenu() throws InterruptedException {
		
		Boolean continuar = true;
		Boolean add = false;
		do {
			
			String opc = viewCatalogo.mostraMenu();
			
		switch (opc){
		    case "1":			  
		    	catalogo.add(viewCatalogo.inserir());
			    break;
			case "2":
				if (catalogo.isEmpty() == false ) {
				viewCatalogo.Listar(catalogo);
				}else {
					add = viewCatalogo.nulo();
					if (add == true)catalogo.add(viewCatalogo.inserir());
					}
				break;
			case "3":
				if (catalogo.isEmpty() == false ) {
				viewCatalogo.Alterar(catalogo);
				}else {
					add = viewCatalogo.nulo();
					if (add == true)catalogo.add(viewCatalogo.inserir());	
				}
				break;
			case "4":
				if (catalogo.isEmpty() == false ) {
				viewCatalogo.Pesquisar(catalogo);
				}else {					
					add = viewCatalogo.nulo();
					if (add == true)catalogo.add(viewCatalogo.inserir());	
				}
				break;
			case "5":
				if (catalogo.isEmpty() == false ) {
				viewCatalogo.Remover(catalogo);
				}else {
					add = viewCatalogo.nulo();
					if (add == true)catalogo.add(viewCatalogo.inserir());	
				}
				break;
			case "6":
				viewCatalogo.Sair();
				Thread.sleep(3000);
				continuar = false;
				break;
		default:
			viewCatalogo.opinvalida();
			break;
		}
		
		} while (continuar);
		System.exit(0);
	}
		
}