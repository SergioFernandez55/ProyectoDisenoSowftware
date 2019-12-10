import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AscensoresTest {
	Ascensor ascensor;
	DespachadorDePiso despachador;
	Ascensor carga1, carga2, carga3, personas1, personas2, personas3;
	
	//Test crear ascensores
	@Before
	public void init() {

		ascensor = new Ascensor.Builder()
				.setPisoActual(1)
				.setDireccion("quieto")
				.build();
		
		//assertEquals(ascensor.getPisoActual(),1);
	
		
		despachador = new DespachadorDePiso(10, 2, 4);


			carga1 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(2)
					.setDireccion("quieto")
					.setID(1)
					.setTipoCarga()
					.build();
			
			carga2 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(5)
					.setDireccion("quieto")
					.setID(2)
					.setTipoCarga()
					.build();
			
			carga3 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(7)
					.setDireccion("quieto")
					.setID(3)
					.setTipoCarga()
					.build();
			
			
			personas1 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(2)
					.setDireccion("quieto")
					.setID(1)
					.setTipoPersona()
					.build();
			
			personas2 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(5)
					.setDireccion("quieto")
					.setID(2)
					.setTipoPersona()
					.build();
			
			personas3 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(7)
					.setDireccion("quieto")
					.setID(2)
					.setTipoPersona()
					.build();
		
	}
	
	@Test
	public void testAgregarAscensores() {
		
		despachador.addAscensor(carga1);
		despachador.addAscensor(carga2);
		despachador.addAscensor(carga3);
				
		assertEquals((despachador.getListaAscensores().get(0).getIdentificador()),1);
		assertEquals((despachador.getListaAscensores().get(1).getIdentificador()),2);
		assertEquals((despachador.getListaAscensores().get(2).getIdentificador()),3);

	}
	
	@Test
	public void llamarAscensorCarga() {
		
		despachador.addAscensor(carga1);
		despachador.addAscensor(carga2);
		despachador.addAscensor(carga3);
		
		assertEquals(despachador.llamarAscensor(3, 9, TipoAscensor.CARGA), 3);
	}
	
	@Test
	public void llamarAscensorPersonas() {
		
		despachador.addAscensor(personas1);
		despachador.addAscensor(personas2);
		despachador.addAscensor(personas3);
	
		assertEquals(despachador.llamarAscensor(9, 3, TipoAscensor.PASAJEROS), 1);
	}
}
