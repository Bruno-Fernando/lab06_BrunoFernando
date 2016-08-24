package teste;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import p2cg.Jogabilidade;
import p2cg.Jogo;
import p2cg.Luta;
import p2cg.Plataforma;
import p2cg.RPG;

public class TesteJogo {
	
	@Test
	public void testeConstrutor() throws Exception{
		HashSet<Jogabilidade> tipoWOW = new HashSet<>();
		tipoWOW.add(Jogabilidade.Competitivo);
		tipoWOW.add(Jogabilidade.Cooperativo);
		tipoWOW.add(Jogabilidade.Multiplayer);
		tipoWOW.add(Jogabilidade.Online);
		Jogo WorldOfWarcraft = new RPG("World of Warcraft", 20.00, tipoWOW);
		assertTrue(20.00 == WorldOfWarcraft.getPreco());
		assertEquals("World of Warcraft", WorldOfWarcraft.getNome());
		
		HashSet<Jogabilidade> tipoMegaMan = new HashSet<>();
		tipoMegaMan.add(Jogabilidade.Offline);
		Jogo MegaMan = new Plataforma("Mega Man Zero", 30.00, tipoMegaMan);
		assertTrue(30.00 == MegaMan.getPreco());
		assertEquals("Mega Man Zero", MegaMan.getNome());
		
		HashSet<Jogabilidade> tipoMK = new HashSet<>();
		tipoMK.add(Jogabilidade.Competitivo);
		tipoMK.add(Jogabilidade.Multiplayer);
		tipoMK.add(Jogabilidade.Online);
		tipoMK.add(Jogabilidade.Offline);
		Jogo MK = new Luta("Mortal Kombat X", 40.00, tipoMK);
		assertTrue(40.00 == MK.getPreco());
		assertEquals("Mortal Kombat X", MK.getNome());
	}
	
	@Test
	public void testeConstrutorException(){
		HashSet<Jogabilidade> tipoWOW = new HashSet<>();
		
		try{
			Jogo WorldOfWarcraft = new RPG(null , 20.00, tipoWOW);
			fail("Deveria ter lancado exception de nome null ou vazio");
		}catch(Exception e){
			assertEquals("Nome nao pode ser null ou  vazio.", e.getMessage());
		}
		
		try{
			Jogo WorldOfWarcraft = new RPG("World Of Warcraft", -20.00, tipoWOW);
		}catch(Exception e){
			assertEquals("Preco nao pode ser menor que zero", e.getMessage());
		}
	
	}
}
