package p2cg;

import java.util.HashSet;

abstract class Usuario {
	private String nome;
	private String login;
	protected HashSet <Jogo> bibliotecaJogos = new HashSet<Jogo>();
	private double gold = 0;
	private int x2p;
	protected double desconto; 
	protected int x2pcompra;
	
	/**
	 * 
	 * @param nome
	 * 				o nome do usuario
	 * @param login
	 * 				o login do usuario
	 * @param x2p
	 * 				a x2p  inicial do usuario que depende de seu tipo(noob ou veterano)
	 * @throws Exception
	 * 				excessao de nome null
	 */
	public Usuario (String nome, String login, int x2p) throws Exception{
		if(nome == null || nome.equals("")){
			throw new Exception("Nome nao pode ser null ou vazio.");
		}
		if(login == null || login.equals("")){
			throw new Exception("Login nao pode ser null ou vazio.");
		}
		this.nome = nome;
		this.login = login;
		this.x2p = x2p;
	}
	
	public void adicionaGold(double gold){
		this.gold += gold;
	}
	
	/**
	 * Faz uma busca na biblioteca de jogos do usuario e caso encontre o jogo
	 * o metodo seta a x2p ganha a partir da chamada do metodo registraJogada
	 * 
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 */
	public boolean registraJogada(String nomeDoJogo, int score,boolean zerou){
		for (Jogo jogo : bibliotecaJogos) {
			if(nomeDoJogo.equalsIgnoreCase(jogo.getNome())){
				setX2p(jogo.registraJogada(score, zerou));
				return true;
			}
		}return false;
	}
	
	/**
	 * Checa se o usuario possui dinheiro suficiente para comprar o jogo
	 * e se ele tiver, entao o jogo eh adicionado em sua biblioteca de jogos 
	 * e o preco do jogo eh descontado do dinheiro que o usuario possui alem 
	 * de ser acrescentado a x2p por compra.
	 * 
	 * @param jogo
	 * 			jogo que pretende-se comprar
	 * @return
	 * 			um boolean que retorna true se o jogo foi comprado e false caso contrario
	 */
	public boolean compraJogo(Jogo jogo){
		if(getGold()>= jogo.getPreco()){
			setGold(getGold() - (jogo.getPreco() - (jogo.getPreco() * desconto )));
			bibliotecaJogos.add(jogo);
			double pontos = x2pcompra * jogo.getPreco();
			int pontosx2p = (int) pontos;
			setX2p(pontosx2p);
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
		this.x2p += x2p;
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
