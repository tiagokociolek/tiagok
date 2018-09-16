
//Tiago Kociolek
//4ºSian

import java.util.ArrayList;
public class ControleCatalogo {

	private ViewCatalogo viewCatalogo;
	ArrayList<Dragon> catalogo;
	
	public ControleCatalogo() {
		viewCatalogo = new ViewCatalogo();
		catalogo = new ArrayList<>();
		trataMenu();		
	}
	private void trataMenu() {
		
		Boolean continuar = true;
		do {
			
			String opc = viewCatalogo.mostraMenu();
			
		switch (opc){
		    case "1":			  
		    	catalogo.add(viewCatalogo.inserir());
			    break;
			case "2":
				viewCatalogo.Listar(catalogo);
				break;
			case "3":
				viewCatalogo.Alterar(catalogo);
				break;
			case "4":
				viewCatalogo.Pesquisar(catalogo);
				break;
			case "5":
				viewCatalogo.Remover(catalogo);
				break;
			case "6":
				System.out.println("sair do menu");
				continuar = false;
				break;
		default:
			System.out.println("Opção Invalida");
			break;
		}
		
		} while (continuar);
		System.exit(0);
	}
		
}


