import java.util.HashSet;

abstract class Usuario {
	private String nome;
	private String login;
	protected HashSet <Jogo> bibliotecaJogos = new HashSet<Jogo>();
	private double gold = 0;
	private int x2p;
	protected double desconto; 
	
	public Usuario (String nome, String login, int x2p) throws Exception{
		if(nome == null){
			throw new Exception("Nome nao pode ser null.");
		}
		this.nome = nome;
		this.login = login;
		this.x2p = x2p;
	}
	
	public void adicionaGold(double gold){
		this.gold += gold;
	}
	
	public void registraJogada(String nomeDoJogo, int score,boolean zerou){
		for (Jogo jogo : bibliotecaJogos) {
			if(nomeDoJogo.equalsIgnoreCase(jogo.getNome())){
				setX2p(jogo.registraJogada(score, zerou));
			}
		}
	}
	
	public boolean compraJogo(Jogo jogo){
		if(getGold()>=jogo.getPreco()){
			setGold(getGold() - (jogo.getPreco() * desconto ));
			bibliotecaJogos.add(jogo);
			return true;
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}
	
	public double valorJogos(){
		double total = 0.0;
		for (Jogo jogo : bibliotecaJogos) {
			total += jogo.getPreco();		
		}
		return total;
	}
	
	public HashSet<Jogo> getBiblioteca(){
		return bibliotecaJogos;
	}
	
	public void setBiblioteca(HashSet <Jogo> biblioteca){
		this.bibliotecaJogos = biblioteca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bibliotecaJogos == null) ? 0 : bibliotecaJogos.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (bibliotecaJogos == null) {
			if (other.bibliotecaJogos != null)
				return false;
		} else if (!bibliotecaJogos.equals(other.bibliotecaJogos))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

}
