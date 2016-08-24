package p2cg;

import java.util.HashSet;

public class Luta extends Jogo{
	/**
	 * 
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @throws Exception
	 */
	public Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		super(nome, preco, jogabilidade);
	}
	
	/**
	 * Regista a jogada, e se o novo score obtido for maior que o 
	 * maior score que estava registrado, em caso positivo, o 
	 * metodo tambem calcula a quantidade de x2p que o usuario ganhara 
	 * e acrescenta uma "zerada"se o jogo foi zerado.
	 * 
	 * @param score
	 * 				score atingido na partida
	 * @param zerou
	 * 				boolean indicando se o jogo foi zerado
	 * 
	 * @return os pontos de x2p obtidos
	 */
	public int registraJogada(int score, boolean zerou){
		int maxscore = getMaxScore();
		int pontos = maxscore/1000;
		setJogadas();
		
		if(score > maxscore){
			pontos += score/1000;
			setMaxScore(score);
		}
		if(zerou){
			setZeradas();
		}
		
		return pontos;
	}
	
	@Override
	public String toString() {
		return "+ " + getNome() + " - " + "Luta:\n" + 
				"==> Jogou " + getJogadas() + " vez(es)\n" + 
				"==> Zerou " + getZeradas() + " vez(es)\n" + 
				"==> Maior score: " + getMaxScore();
	}
}
