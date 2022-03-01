import lombok.Getter;

public abstract class Conta implements iConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	@Getter
	private String password;
	private String username; //ou nome do cliente? cpf?

	public Conta() {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++; //aumenta a cada conta criada
	}
	
	@Override
	public void sacar(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
		}
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void tranferir(double valor, Conta contaDestino) {
		if(valor <= this.saldo) {
			sacar(valor);
			contaDestino.depositar(valor);
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	

	protected void imprimirInfoComuns() {
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
