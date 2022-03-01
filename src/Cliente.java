import java.util.Date;

import lombok.Data;

@Data
public class Cliente {
	private String nome;
	private String cpf;
	private Conta conta; 
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void criarConta() {}
}
