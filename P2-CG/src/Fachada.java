

import java.util.HashSet;

public class Fachada {
	private HashSet <Usuario> players = new HashSet <Usuario>();
	
	public void novoUsuario(String nome, String login) throws Exception{
		if(retornaUsuario(login) == null){
			Usuario novo = new UsuarioNoob(nome, login);
			players.add(novo);
		}
		throw new Exception ("Usuario jah existe.");
	}
	
	public Usuario retornaUsuario(String login){
		for (Usuario usuario : players) {
			if(usuario.getLogin().equals(login)){
				return usuario;
			}
		}
		return null;
	}
	
	public void adicionaDinheiro(String login, double dinheiro){
		if(retornaUsuario(login) instanceof Usuario){
			retornaUsuario(login).adicionaGold(dinheiro);
		}
	}
	
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
		
		return "=== Central P2-CG ===\n";
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
