
public class Luta extends Jogo{
	
	public Luta(String nome, double preco, Jogabilidade jogabilidade){
		super(nome, preco, jogabilidade);
	}

	public int registraJogada(int score, boolean zerou){
		int maxscore = getMaxScore();
		int pontos = maxscore/1000;
		
		if(score > maxscore){
			pontos += score/1000;
			setMaxScore(score);
		}
		if(zerou){
			setZeradas();
		}
		
		return pontos;
		
		
		
	}
}
