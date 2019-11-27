
public class FabricaMotocicletas extends FabricaVehiculos{

	@Override
	protected Vehiculo creaVehiculo() {
		return new Motocicleta();
	}

}
