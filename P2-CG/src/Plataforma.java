import java.util.HashSet;

public class Plataforma extends Jogo{
	private final int x2p = 20;
	
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade){
		super(nome, preco, jogabilidade);
	}
	
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
