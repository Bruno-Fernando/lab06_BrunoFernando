
public class UsuarioNoob extends Usuario{
	//recebe 10% de desconto ao comprar o jogo
	
	public UsuarioNoob(String nome, String login){
		super(nome, login, 0);
	}
	
	public int x2pPorCompra(double preco){
		double x2p = 10 * preco;
		int x2pfinal = (int) x2p;
		return x2pfinal;
	}
	
	
}
