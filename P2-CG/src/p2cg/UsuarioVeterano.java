package p2cg;

public class UsuarioVeterano extends Usuario{
	
	/**
	 * 
	 * @param nome
	 * @param login
	 * @param desconto
	 * 				diz qual sera o desconto na compra de jogos do usuario veterano
	 * @throws Exception
	 */
	public UsuarioVeterano(String nome, String login)throws Exception{
		super(nome, login, 1000);
		desconto = 0.2;
		x2pcompra = 15;
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
