import java.util.HashMap;
import java.util.Map;

public class Application {

	static boolean loop = true;
	static boolean logado = false;
	
	public static void main(String[] args) {
		
		System.out.println("=== BEM VINDO AO BANCO VISUAL ===");
		System.out.println();
		
		while(loop) {
			UI.printChoices();
			
			int op1 = UI.returnChoice(4);
			System.out.println();
			if(op1 == 4) break;
			returnOpcoes1(op1);
			
			while(logado) {
				//logado
				UI.logado();
				//opcoes
			}
			
			
		}
		System.out.println("\n=== Voce Saiu ===\nNos vemos mais tarde!");
		UI.closeScanner();
	}
	
	public static void createAccount() {
		System.out.println();
		System.out.println("=== CRIANDO USUARIO ===");
		System.out.print("/nNome: ");
		String nome = UI.returnString();
		System.out.print("/nCPF: ");
		String cpf = UI.returnString();
	}
	
	public static void returnOpcoes1(int n) {
		switch(n) {
			case 1:
				logado = UI.logar();
				break;
			case 2:
				UI.criarConta();
				break;
			case 3:
				UI.maisInformacoes();
				break;
			default:
				System.out.println("Opcao Invalida");
				break;
		}
	}
}
