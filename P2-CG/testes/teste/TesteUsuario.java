package teste;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import p2cg.Jogabilidade;
import p2cg.Jogo;
import p2cg.Plataforma;
import p2cg.UsuarioNoob;
import p2cg.UsuarioVeterano;

public class TesteUsuario {
	
	@Test
	public void testeConstrutor() throws Exception{
		UsuarioNoob bruno = new UsuarioNoob("Bruno", "PlayerZer0");
		assertEquals("Bruno", bruno.getNome());
		assertEquals("PlayerZer0", bruno.getLogin());
		assertTrue(bruno.getX2p() == 0);
		
		UsuarioVeterano bambam = new UsuarioVeterano("BamBam", "Monstro");
		assertEquals("BamBam", bambam.getNome());
		assertEquals("Monstro", bambam.getLogin());
		assertTrue(bambam.getX2p() == 1000);
	}
	
	@Test
	public void testeConstrutorException() throws Exception{
		try{
			UsuarioNoob bruno = new UsuarioNoob(null, "PlayerZer0");
			fail("Deveria ter recebido exception de nome null");
		}catch(Exception e){
			assertEquals("Nome nao pode ser null ou vazio.", e.getMessage());
		}
		
		try{
			UsuarioNoob bruno = new UsuarioNoob("Bruno", null);
			fail("Deveria ter recebido exception de nome null");
		}catch(Exception e){
			assertEquals("Login nao pode ser null ou vazio.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaCompraJogo() throws Exception{
		UsuarioNoob bruno = new UsuarioNoob("Bruno", "PlayerZer0");
		HashSet<Jogabilidade> tipoMegaMan = new HashSet<>();
		tipoMegaMan.add(Jogabilidade.Offline);
		Jogo MegaMan = new Plataforma("Mega Man Zero", 30.00, tipoMegaMan);
		Jogo MegaManX = new Plataforma("Mega Man X", 90.00, tipoMegaMan);
		
		bruno.adicionaGold(50);
		assertTrue(bruno.compraJogo(MegaMan));
		assertFalse(bruno.compraJogo(MegaManX));
		assertTrue(bruno.getX2p() == 300);
	}
}
