
public class UsuarioNoob extends Usuario{
	
	public UsuarioNoob(String nome, String login) throws Exception{
		super(nome, login, 0);
		desconto = 0.1;
	}

	@Override
	public String toString() {
		return getNome() + " - Usuario Noob\n";
	}
	
	
}
