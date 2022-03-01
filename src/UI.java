import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UI {

	static Map<Integer, String> idPassword = new HashMap<>();
	static Map<Integer, Conta> idAccount = new HashMap<>();
	

	static Scanner scanner = new Scanner(System.in);
	
	public static void printWelcome() {
		System.out.println("=== BEM VINDO AO BANCO ===");
		System.out.println();
	}
	
	public static void printChoices() {
		System.out.println("1. Logar"
						+ "\n2. Criar nova conta "
						+ "\n3. Mais informações "
						+ "\n4. Sair");
		
	}
	
	public static void maisInformacoes() {
		System.out.println("=== Mais infos ===\n\nGithub/pedfu");
	}
	
	public static boolean logar() {
		System.out.println("=== Login ====");
		System.out.print("\nDigite seu id: ");
		int id = returnChoice(Integer.MAX_VALUE);
		System.out.print("Digite sua senha: ");
		String senha = returnString();
		
		for (Map.Entry<Integer, String> entry:idPassword.entrySet()) {
			if(entry.getKey() == id && entry.getValue().equals(senha)) {
				id2 = entry.getKey();
				return true;
			}
		}
		System.out.println("\n->Error. senha ou id errados!\n");
		return false;
	}
	
	public static void logado() {
		System.out.println("\n=== Conta ===");
		conta();
		int op = returnChoice(5);
		
		switch(op) {
			case 1:
				System.out.print("\nValor: ");
				double valor = scanner.nextDouble();
				idAccount.get(id2).depositar(valor);;
				break;
			case 2:
				System.out.print("\nValor: ");
				double valor2 = scanner.nextDouble();
				idAccount.get(id2).sacar(valor2);;
				break;
			case 3:
				System.out.print("\nValor: ");
				double valor3 = scanner.nextDouble();
				System.out.print("\nId da conta: ");
				int idT = scanner.nextInt();
				idAccount.get(id2).tranferir(valor3, idAccount.get(idT));
				break;
			case 4:
				idAccount.get(id2).imprimirExtrato();
				break;
			case 5:
				Application.logado = false;
				break;
		}
		
	}
	
	public static void conta() {
		
		System.out.println("1. Depositar\n2. Sacar\n3. Tranferir\n4. Saldo\n5. Sair");
	}
	
	public static void criarConta() {
		System.out.println("=== Criar Conta ====");
		System.out.print("\nDigite seu id: ");
		int id = returnChoice(Integer.MAX_VALUE);
		System.out.print("Digite sua senha: ");
		String senha = returnString();
		
		Conta conta = new ContaPoupanca();
		
		idPassword.put(id, senha);
		idAccount.put(id, conta);
		
		System.out.println("\nConta criada!\n");
	}
	
	public static int returnChoice(int maxLength) {
		int num = scanner.nextInt();
		
		while(num > maxLength || num < 0) {
			System.out.println("/nOpção Inválida!");
			System.out.print("Digite novamente: ");
			num = scanner.nextInt();
		}
		return num;
	}
	
	public static String returnString() {
		Scanner scanner = new Scanner(System.in);
		String palavra = scanner.nextLine();
		
		return palavra;
	}
	
	public static void closeScanner() {
		if(scanner != null) {
			scanner.close();
		}
	}
	
	static int id2;
	
	public int getId() {
		return id2;
	}
}
