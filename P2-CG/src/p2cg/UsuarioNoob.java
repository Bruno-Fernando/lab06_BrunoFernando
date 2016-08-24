package p2cg;

public class UsuarioNoob extends Usuario{
	
	/**
	 * 
	 * @param nome
	 * @param login
	 * @param desconto
	 * 				diz qual sera o desconto na compra de jogos do usuario noob
	 * @throws Exception
	 */
	public UsuarioNoob(String nome, String login) throws Exception{
		super(nome, login, 0);
		desconto = 0.1;
		x2pcompra = 10;
	}

	@Override
	public String toString() {
		String jogos = "";
		double valor = 0;
		for (Jogo jogo : bibliotecaJogos) {
			jogos += jogo.toString();
			jogos += "\n";
			valor += jogo.getPreco();
		}
		return getNome() + " - Usuario Veterano\n" + 
				jogos +
				"Total de preco dos jogos : R$ " + valor + 
				"­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­--------------------------------------------";
	}

}
