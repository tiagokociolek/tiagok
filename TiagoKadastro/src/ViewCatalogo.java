// Tiago Kociolek
// 4ºSian

import java.util.ArrayList;
import java.util.Scanner;

public class ViewCatalogo {
	
	private Scanner teclado;

	public ViewCatalogo()
	{
		teclado = new Scanner(System.in);
	}
	
	public String mostraMenu(int itens, boolean it) {
		
		System.out.println("-----MENU------");
		if (it == false) {
			System.out.println("Exite " + (itens) + " Dragon Catalogados.");
		}
		else {System.out.println("Nenhum Dragon Catalogado!");}
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Pesquisar");
		System.out.println("5 - Excluir");
		System.out.println("6 - Sair");
		System.out.println("Opção: ");
		return teclado.nextLine();
		
	}
	
	public Dragon inserir() 
	{
		float n = 0;
		boolean t = false;
		
		Dragon umDragon = new Dragon();
		System.out.println("Inserir");
		System.out.println("Nome: ");
		umDragon.setNome(teclado.nextLine());		
		
		System.out.println("Tipo: ");
		umDragon.setTipo(teclado.nextLine());
		
		System.out.println("Especie: ");
		umDragon.setEspecie(teclado.nextLine());
		
		System.out.println("Força: ");
		do {
		try {
		n = Float.parseFloat(teclado.nextLine());
		t = true;
		}catch (Exception e) {
			System.out.println("\n1Digite um dado válido use o segunite formato exemplo: 1.13 ou EX: 5 \n Digite novamente: ");
		}
		}while(t != true);
		umDragon.setForca(n);
		
		return umDragon;
	}
	
	public void Listar(ArrayList<Dragon> catalogo) 
	{
		System.out.println("\nLista catalogo!");
		
		int x = 0;
        for (Dragon Dragons : catalogo) {
        	System.out.println("ID: " + x + " - " + 
            catalogo.get(x).getNome() + "\n DADOS: " +  
            catalogo.get(x).toString());
			System.out.println("\n");
			x++;        	
        }		
	}

	public void Alterar(ArrayList<Dragon> catalogo) {
		Listar(catalogo);
		
		boolean continuar = true;
		int x = 0;
		
      do {
			System.out.println("Digite o registro para alteração: ");
		try {
			
			 x = Integer.parseInt(teclado.nextLine());
			
			if(x >= 0 && x < catalogo.size())
			{
				continuar = false;
			}
			else 
			{
				System.out.println("Digite um dado válido: ");
			}
			
		} catch (Exception e) {
			
			System.out.println("Dado digitado Invalido!!");
		}
		} while(continuar);
		
      AlterarModificar(catalogo,x);

	  }
	  
    private void AlterarModificar(ArrayList<Dragon> catalogo, int x) {
		float n = 0;
		boolean t = false;
	   boolean continuar = true;
		int opc = 0;
		//  String SN;
		  	        
	   do {  
		   try {
			   
			      System.out.println("\n Para alterar Nome - Digite 1"
        		+ " \n Para alterar tipo - Digite 2"
			        		+ " \n Para alterar especie - Digite 3 "
			        		+ " \n Para alterar força - Digite 4 "
        		+ "\n Para sair de alterar - Digite 5 ");
			        System.out.println("\nEscolha qual campo voce deseja alterar: ");  	
			        
	  	  opc = Integer.parseInt(teclado.nextLine());
	  	  
	  	  switch (opc) {
	  	  case 1:
	  		  System.out.println("Nome (" +  catalogo.get(x).getNome() + "): ");
	  		  catalogo.get(x).setNome(teclado.nextLine());
	  	      System.out.println("\nAlterar outro campo S ou N ?");
	  	      continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	  		  break;	  
	  	  case 2:
	  		  System.out.println("Tipo (" +  catalogo.get(x).getTipo() + "): ");
	  		  catalogo.get(x).setTipo(teclado.nextLine());
	  	      System.out.println("\nAlterar outro campo S ou N ?");
	  	      continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	  		  break;	  
	  	  case 3:
	  	      System.out.println("Especie (" +  catalogo.get(x).getEspecie() + "): ");
	  	      catalogo.get(x).setEspecie(teclado.nextLine());
	  	      System.out.println("\nAlterar outro campo S ou N ?");	  	      
	  	      continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	  	      break;	
	  	 case 5:
	  		continuar = false;
	  		 break;
	  	 case 4:
	  		  System.out.println("Força (" +  catalogo.get(x).getForca() + "): ");
	  		do {
	  			try {
	  			n = Float.parseFloat(teclado.nextLine());
	  			t = true;
	  			}catch (Exception e) {
	  				System.out.println("\n1Digite um dado válido use o segunite formato exemplo: 1.13 ou EX: 5 \n Digite novamente: ");
	  			}
	  			}while(t != true);
	  	      catalogo.get(x).setForca(n);
	  	      System.out.println("\nAlterar outro campo S ou N ?");	  	      
	  	      continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	  	      break;		  		 
	  	  default:
	  		System.out.println("Valor digitado Invalido!!");
	  			break;
	  	  }	
		   } catch (Exception e) {
				
				System.out.println("Valor digitado Invalido!!");
		   }
		} while(continuar);
	        
	}

	public void Pesquisar(ArrayList<Dragon> catalogo) {
     int opc = 0;
	 int x = 0;
	 int i = 0;
    boolean continuar = true;
	String pNome="", pTipo="", pEspecie="", pQualquer="";
	 
	do {
     try {
		System.out.println("1 - Pesquisar por nome\n2"
				+ " - Pesquisar por Tipo\n3 -"
				+ " Pesquisar por Especie\n4"
				+ " - Pesquisar por qualquer critério, força não inclusa\n"
				+ "5 - Sair da pesquisa");
		
        opc = Integer.parseInt(teclado.nextLine());
        x = 0;
        i = 0;

		switch (opc) {
		case 1:
			System.out.println("Nome: ");
			pNome = teclado.nextLine();
	        for (Dragon Dragons : catalogo) {
	        	if(pNome.contains(catalogo.get(x).getNome())) {
	        	System.out.println("ID: " + x + " - " + 
	            catalogo.get(x).getNome() + "\n DADOS: " +  
	            catalogo.get(x).toString());
				i++;
				}
				x++;        	
	        }		
	        System.out.println("Total de encontrados: "+ i);
	        System.out.println("\nRealizar nova pesquisa S ou N ? ");
	        continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
			break;
		case 2:
			System.out.println("Tipo: ");
			pTipo = teclado.nextLine();		
	        for (Dragon Dragons : catalogo) {
	        	if(pTipo.contains(catalogo.get(x).getTipo())) {
	        	System.out.println("ID: " + x + " - " + 
	            catalogo.get(x).getNome() + "\n DADOS: " +  
	            catalogo.get(x).toString());
				i++;
				}
				x++;        	
	        }
	        System.out.println("Total de encontrados: "+ i);
	        System.out.println("\nRealizar nova pesquisa S ou N ? ");
	        continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
			break;
		case 3: 
			System.out.println("Especie: ");
			pEspecie = teclado.nextLine();		
	        for (Dragon Dragons : catalogo) {
	        	if(pEspecie.contains(catalogo.get(x).getEspecie())) {
	        	System.out.println("ID: " + x + " - " + 
	            catalogo.get(x).getNome() + "\n DADOS: " +  
	            catalogo.get(x).toString());
				i++;
				}
				x++;        	
	        }
	        System.out.println("Total de encontrados: "+ i);
	        System.out.println("\nRealizar nova pesquisa S ou N ? ");
	        continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
			break;
		case 4:
			System.out.println("Qualquer: ");
			pQualquer = teclado.nextLine();		
	        for (Dragon Dragons : catalogo) {
	        	if((pQualquer.contains(catalogo.get(x).getEspecie()))||
	        	(pQualquer.contains(catalogo.get(x).getTipo()))||
	        	(pQualquer.contains(catalogo.get(x).getNome()))){
	        	System.out.println("ID: " + x + " - " + 
	            catalogo.get(x).getNome() + "\n DADOS: " +  
	            catalogo.get(x).toString());
				i++;
				}
				x++;        	
	        }
	        System.out.println("Total de encontrados: "+ i);
	        System.out.println("\nRealizar nova pesquisa S ou N ? ");
	        continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
			break;
		case 5:
			continuar = false;
			break;
		}
		   } catch (Exception e) {
				
				System.out.println("Valor digitado Invalido!!");
		   }
	}while(continuar);
		
	}

	public void Remover(ArrayList<Dragon> catalogo) {
	
		int x,i,id;
		String s;
		Listar(catalogo);
		 boolean continuar = true;
		System.out.println("utilize a ID.");
		System.out.println("Qual catalogo deseja remover? ou C para cancelar.");
		s = (teclado.nextLine());
		id = Integer.parseInt(s);
		
		do {
			 try {
	    if("c".equalsIgnoreCase(s) == true) {break;} 
	    else if((catalogo.size() < Integer.parseInt(s)) || (0 >Integer.parseInt(s))) {
	    	System.out.println("ID não encontrada! Tetar novamente? S ou N:");
	    	 continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	    	 Listar(catalogo);
	    	 System.out.println("Qual catalogo deseja remover? ou C para cancelar.");
	    	 s = (teclado.nextLine());
	    }else {
	    	 System.out.println("Tem certeza que deseja remover o item?\n ");
        	System.out.println("ID: " + id + " - " + 
                    catalogo.get(id).getNome() + "\n DADOS: " +  
                    catalogo.get(id).toString());        	
	    	 System.out.println("Tem certeza que deseja remover o item?\n ");
	    	 System.out.println("S ou N: ");
	    	 if ("s".equalsIgnoreCase(teclado.nextLine())== true) {	    		    
	    	catalogo.remove(Integer.parseInt(s));
	    	System.out.println("Remover mais um item? S ou N:");
	    	 continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
	    	 if (continuar == false)break;
	    	 Listar(catalogo);
	    	 System.out.println("Qual catalogo deseja remover? ou C para cancelar.");
	    	 s = (teclado.nextLine());
	    	 }else {
	    		 System.out.println("Tetar outro item ? S ou N:");
			    	continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
			    	if (continuar == false)break;
			    	else {
			    	 Listar(catalogo);
			    	 System.out.println("Qual catalogo deseja remover? ou C para cancelar.");
			    	 s = (teclado.nextLine());
			    	}	    		 
	    	 }
	    }
		   } catch (Exception e) {
				
				System.out.println("Valor digitado Invalido!!");
		    	System.out.println("Tetar novamente? S ou N:");
		    	continuar = ("s".equalsIgnoreCase(teclado.nextLine()));
		    	if (continuar == false)break;
		    	else {
		    	 Listar(catalogo);
		    	 System.out.println("Qual catalogo deseja remover? ou C para cancelar.");
		    	 s = (teclado.nextLine());
		    	}
		   }
		}while(continuar);
		
			
	}

	public void Sair() {
		System.out.println("Saindo da aplicação!");
		
	}

	public boolean nulo() {
		System.out.println("Catalogo vazio favor adicionar pelo menos 1 dados!");
		System.out.println("Deseja adicionar agora? S para sim qualquer tecla sair.");
		boolean q = false;
		 q = ("s".equalsIgnoreCase(teclado.nextLine()));	
		 if (q == false)return false;
		return q;
		
	}

	public void opinvalida() {
		System.out.println("Opção Invalida");		
	}

	
}