package warsjawa.sam.architecture.contract.courier;

public interface CourierServiceOrder {

	public CourierAddressSetupInfo setupAddress();
	
	public Integer getServicePrice();
}
