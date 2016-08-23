import java.util.HashSet;

public class RPG extends Jogo{
	private final int x2p = 10;
	
	public RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade){
		super(nome, preco, jogabilidade);
	}
	
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
