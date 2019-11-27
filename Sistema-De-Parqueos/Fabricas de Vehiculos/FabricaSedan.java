
public class FabricaSedan extends FabricaVehiculos {

	@Override
	protected Vehiculo creaVehiculo() {
		return new Sedan();
	}

}
