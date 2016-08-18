
public class RPG extends Jogo{
	private final int x2p = 10;
	
	public RPG(String nome, double preco, Jogabilidade jogabilidade){
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		if(score > getMaxScore()){
			setMaxScore(score);
		}
		if(zerou){
			setZeradas();
		}
		return x2p;
	}

}
