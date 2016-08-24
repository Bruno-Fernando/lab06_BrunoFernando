package p2cg;

import java.util.HashSet;

public class RPG extends Jogo{
	private final int x2p = 10;
	
	/**
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @throws Exception
	 */
	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade)throws Exception{
		super(nome, preco, jogabilidade);
	}
	
	/**
	 * 
	 * Regista a jogada e se o score obtido for maior que o score maximo anterior
	 * ele eh setado como o novo score maximo
	 * e se o jogo foi zerado, eh acrescentado uma nova "zerada".
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
		if(score > getMaxScore()){
			setMaxScore(score);
		}
		if(zerou){
			setZeradas();
		}
		return x2p;
	}

	@Override
	public String toString() {
		return "+ " + getNome() + " - " + "RPG:\n" + 
				"==> Jogou " + getJogadas() + " vez(es)\n" + 
				"==> Zerou " + getZeradas() + " vez(es)\n" + 
				"==> Maior score: " + getMaxScore();
	}
}
