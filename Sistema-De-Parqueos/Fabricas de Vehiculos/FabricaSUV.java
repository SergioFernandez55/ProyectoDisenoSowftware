

public class FabricaSUV extends FabricaVehiculos {

	@Override
	protected Vehiculo creaVehiculo() {
		return new SUV();
	}

}
