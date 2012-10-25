package warsjawa.sam.architecture.contract.courier;

public interface CourierAddressSetupInfo {

	public void setCity(String cityName);
	public void setStreet(String streetName);
	public void setPackageSize(Integer kgSize);
	public void setupDone();
}
