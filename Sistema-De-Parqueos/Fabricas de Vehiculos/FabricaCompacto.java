
public class FabricaCompacto extends FabricaVehiculos {

	@Override
	protected Vehiculo creaVehiculo() {
		return new Compacto();
	}

}
