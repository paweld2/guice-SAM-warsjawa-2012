package warsjawa.sam.architecture.contract.store;

import warsjawa.sam.architecture.contract.courier.CourierAddressSetupInfo;

public interface StoreOrder {

	public void addProduct(String productId, Integer nrOfProducts);
	
	public void receiveExternalCourierService(CourierAddressSetupInfo adressSetup);
	
	public boolean cancelOrder();
	public String realizeOrder();
}
