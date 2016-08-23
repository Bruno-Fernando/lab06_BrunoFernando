import java.util.HashSet;

/**
 * 
 * @author brunofs
 * @param nome
 * 	o nome do jogo
 * @param preco
 * 	o preco do jogo
 * @param jogabilidade
 * 	a jogabilidade do jogo
 *
 */
public abstract class Jogo {
	private String nome;
	private double preco;
	private int maxScore;
	private int jogadas;
	private int zeradas;
	private HashSet<Jogabilidade> jogabilidade;
	
	public Jogo(String nome,double preco, HashSet <Jogabilidade> jogabilidade){
		this.nome = nome;
		this.preco = preco;
		this.maxScore = 0;
		this.jogadas = 0;
		this.zeradas = 0;
		this.jogabilidade = jogabilidade;
	}

	abstract int registraJogada(int score, boolean zerou);
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getJogadas() {
		return jogadas;
	}

	public void setJogadas() {
		this.jogadas += 1;
	}

	public int getZeradas() {
		return zeradas;
	}

	public void setZeradas() {
		this.zeradas += 1;
	}

	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}
	
}
