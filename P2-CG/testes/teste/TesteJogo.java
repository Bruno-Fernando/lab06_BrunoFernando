package teste;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteJogo {

	@Test
	public void testJogo() {
		try{
			Jogo jogo = new RPG("",2000);
			fail("devia ter lançado")
		}catch(Exception e){
			System.out.println(e.get);
		}
		fail("Not yet implemented");
	}

	@Test
	public void testRegistraJogada() {
		fail("Not yet implemented");
	}

}
