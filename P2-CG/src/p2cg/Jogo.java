package p2cg;

import java.util.HashSet;

public abstract class Jogo {
	private String nome;
	private double preco;
	private int maxScore;
	private int jogadas;
	private int zeradas;
	private HashSet<Jogabilidade> jogabilidade;
	
	/**
	 * 
	 * @param nome
	 * 				o nome do jogo
	 * @param preco
	 * 				o valor do jogo 
	 * @param jogabilidade
	 * 				qual/quais jogabilidades o jogo possui
	 * @param maxScore
	 * 				quantidade maxima de score obtidas neste jogo, iniciando com 0
	 * @param jogadas
	 * 				numero de vezes que foi jogado
	 * @param zeradas
	 * 				quantidade de vezes que o jogo foi terminado
	 * @throws Exception
	 * 				excessoes de nome null e preco negativo
	 */
	public Jogo(String nome,double preco, HashSet <Jogabilidade> jogabilidade) throws Exception{
		if(nome == null || nome.equals("")){
			throw new Exception ("Nome nao pode ser null ou  vazio.");
		}
		if(preco < 0){
			throw new Exception ("Preco nao pode ser menor que zero");
		}
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
