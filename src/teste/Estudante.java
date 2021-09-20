package teste;

public class Estudante {
	private String nome;
	private String Endereco;
	private int matricula;
	private char sexo;
	
	public Estudante(String nome, String endereco, int matricula, char sexo) {
		super();
		this.nome = nome;
		this.Endereco = endereco;
		this.matricula = matricula;
		this.sexo = sexo;
	}

	public Estudante(String name, String endereco2, String matricula2, String sexo2, int conversor, char conversor1) {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public int getMatricula() {
		return matricula;
	}
	public char getSexo() {
		return sexo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
}
