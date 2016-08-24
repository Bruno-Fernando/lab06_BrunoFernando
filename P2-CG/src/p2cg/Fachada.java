package p2cg;

import java.util.HashSet;

public class Fachada {
	private HashSet <Usuario> players = new HashSet <Usuario>();
	
	/**
	 * Caso o usuario nao exista, ele eh registrado nos players 
	 * 
	 * @param nome
	 * 			nome do usuario
	 * @param login
	 * 			login do usuario
	 * @throws Exception
	 * 				no caso do usuario existir
	 */
	public void novoUsuario(String nome, String login) throws Exception{
		if(retornaUsuario(login) == null){
			Usuario novo = new UsuarioNoob(nome, login);
			players.add(novo);
		}
		throw new Exception ("Usuario jah existe.");
	}
	
	/**
	 * Procura por um usuario entre os players
	 * @param login
	 * @return um usuario, mas se o usuario na existir o retorno eh null
	 */
	public Usuario retornaUsuario(String login){
		for (Usuario usuario : players) {
			if(usuario.getLogin().equals(login)){
				return usuario;
			}
		}
		return null;
	}
	
	/**
	 * Atravez do login, eh pesquisado se o usuario existe e se existir 
	 * o dinheiro eh adicionado a seu "perfil"
	 * @param login
	 * @param dinheiro
	 */
	public void adicionaDinheiro(String login, double dinheiro){
		if(retornaUsuario(login) instanceof Usuario){
			retornaUsuario(login).adicionaGold(dinheiro);
		}
	}
	
	/**
	 * Tenta vender um jogo e se nao conseguir recebe uma excessao
	 * que eh tratada no metodo
	 * @param login
	 * @param nome
	 * @param preco
	 * @param jogabilidade
	 * @param tipo
	 */
	public void vendeJogo(String login, String nome, double preco, HashSet<Jogabilidade> jogabilidade, TipoJogo tipo){
		Usuario usuario = retornaUsuario(login);
		try{
			GameFactory factory = new GameFactory ();
			Jogo jogo = factory.getJogo(nome, preco, jogabilidade, tipo);
			usuario.compraJogo(jogo);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Faz o upgrade do usuario se ele possuir 1000 xp e se for  noob
	 * @param login
	 * @return true se conseguir fazer o upgrade e false caso contrario
	 * @throws Exception
	 * 				lanca e trata a exception no caso do usuario ja ser veterano ou 
	 *				 o usuario nao existir
	 */
	public boolean upgrade(String login) throws Exception{
		try{
			for (Usuario usuario : players) {
				if(usuario.getLogin().equals(login)){
					if(usuario instanceof UsuarioVeterano){
						throw new Exception ("Usuario jah eh veterano.");
					}
					if(usuario.getX2p() >= 1000){
						Usuario novoveterano = new UsuarioVeterano(usuario.getNome(),usuario.getLogin());
						novoveterano.setGold(usuario.getGold());
						novoveterano.setX2p(usuario.getX2p());
						novoveterano.setBiblioteca(usuario.getBiblioteca());
						players.add(novoveterano);
						players.remove(usuario);
						return true;
					}
				}
			
			}throw new Exception ("Usuario nao encontrado.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}return false;
	}
	
	
	
	@Override
	public String toString() {
		String string = "";
		for (Usuario usuario : players) {
			string += usuario.getLogin();
			string += "\n";
			string += usuario.toString();
			
		}
		
		return "=== Central P2-CG ===\n" + string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fachada other = (Fachada) obj;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}
	
	
}
