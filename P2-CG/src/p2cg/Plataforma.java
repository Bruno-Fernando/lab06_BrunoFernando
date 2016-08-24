package p2cg;

import java.util.HashSet;

public class Plataforma extends Jogo{
	private final int x2p = 20;
	
	/**
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @throws Exception
	 */
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade)throws Exception{
		super(nome, preco, jogabilidade);
	}
	
	/**
	 * 
	 * Regista a jogada e se o jogo foi zerado o metodo acrescentara
	 * uma "zerada" e retornara a x2p ganhada, caso contrario, o retorno de x2p eh zero
	 * e nao eh acrescentada a "zerada".
	 * 
	 * @param score
	 * 				score atingido na partida
	 * @param zerou
	 * 				boolean indicando se o jogo foi zerado
	 * 
	 * @return os pontos de x2p obtidos
	 */
	public int registraJogada(int score, boolean zerou){
		setJogadas();
		if(zerou){
			setZeradas();
			return x2p;
		}return 0;
	}
	
	@Override
	public String toString() {
		return "+ " + getNome() + " - " + "Plataforma:\n" + 
				"==> Jogou " + getJogadas() + " vez(es)\n" + 
				"==> Zerou " + getZeradas() + " vez(es)\n" + 
				"==> Maior score: " + getMaxScore();
	}

}
