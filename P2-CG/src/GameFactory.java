import java.util.HashSet;

public class GameFactory {
	private Jogo RPG(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		Jogo rpg = new RPG(nome, preco, jogabilidade);
		return rpg;
	}
	private Jogo Luta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		Jogo luta = new Luta(nome, preco, jogabilidade);
		return luta;
	}
	private Jogo Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws Exception{
		Jogo plataforma = new Plataforma(nome, preco, jogabilidade);
		return plataforma;
	}
	
	public Jogo getJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, TipoJogo tipo) throws Exception{
		if(tipo.equals(TipoJogo.RPG)){
			return RPG(nome, preco, jogabilidade);
		}
		else if(tipo.equals(TipoJogo.Luta)){
			return Luta(nome, preco, jogabilidade);
		}
		else{
			return Plataforma(nome, preco, jogabilidade);
		}
	}
	
}
