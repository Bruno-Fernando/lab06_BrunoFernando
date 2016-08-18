
public class Plataforma extends Jogo{
	private final int x2p = 20;
	
	public Plataforma(String nome, double preco, Jogabilidade jogabilidade){
		super(nome, preco, jogabilidade);
	}
	
	public int registraJogada(int score, boolean zerou){
		if(zerou){
			setZeradas();
			return x2p;
		}return 0;
	}

}
