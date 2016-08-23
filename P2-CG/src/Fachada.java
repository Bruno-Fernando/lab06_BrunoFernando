

import java.util.HashSet;

public class Fachada {
	private HashSet <Usuario> players = new HashSet <Usuario>();
	
	public void novoUsuario(String nome, String login){
		if(retornaUsuario(login) == null){
			//lanca exception
		}
		Usuario novo = new UsuarioNoob(nome, login);
		players.add(novo);
	}
	
	public Usuario retornaUsuario(String login){
		for (Usuario usuario : players) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
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
	
	public void vendeJogo(String login, Jogo jogo){
		Usuario usuario = retornaUsuario(login);
		
		usuario.compraJogo(jogo);
		
	}
	
	public void imprimeUsuarios(){
		System.out.println("=== Central P2-CG ===");
		
		for (Usuario usuario : players) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario);
			
			
			//System.out.printf("Total de preço dos jogos: R$ ",);
			System.out.println("--------------------------------------------");
		}
	}
	
	public boolean upgrade(String login){
		for (Usuario usuario : players) {
			if(usuario.getLogin().equalsIgnoreCase(login)){
				if(usuario instanceof UsuarioVeterano){
					return false;
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
			return false;
		}
		return false;
	}
	
	
	
	@Override
	public String toString() {
		String string = new String();
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
