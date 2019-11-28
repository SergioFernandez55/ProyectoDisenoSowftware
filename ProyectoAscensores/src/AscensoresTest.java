import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AscensoresTest {

	//Test crear ascensores
	@Test
	void test() {
		Ascensor ascensor;

		ascensor = new Ascensor.Builder()
				.setPisoActual(1)
				.setDireccion("quieto")
				.build();
		
		assertEquals(ascensor.getPisoActual(),1);
	
		
		DespachadorDePiso despachador = new DespachadorDePiso(10, 2, 4);
		Ascensor ascensor1, ascensor2, ascensor3;

			ascensor1 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(2)
					.setDireccion("quieto")
					.setID(1)
					.build();
			
			ascensor2 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(5)
					.setDireccion("quieto")
					.setID(2)
					.build();
			
			ascensor3 = new Ascensor.Builder()
					.setMaxPasajeros(3)
					.setPisoActual(7)
					.setDireccion("quieto")
					.setID(3)
					.build();
			despachador.addAscensor(ascensor1);
			despachador.addAscensor(ascensor2);
			despachador.addAscensor(ascensor3);
		
					
		assertEquals((despachador.getListaAscensores().get(0).getIdentificador()),1);
		assertEquals((despachador.getListaAscensores().get(1).getIdentificador()),2);
		assertEquals((despachador.getListaAscensores().get(2).getIdentificador()),3);

		assertEquals(despachador.llamarAscensor(3, 9, TipoAscensor.CARGA), 0);
		
	}
}


