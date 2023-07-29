package lk.ijse.gdse63.shaili.assignment1.service.util;


import lk.ijse.gdse63.shaili.assignment1.service.Custom.impl.ItemServiceImpl;

public class ServiceFactory {
    public static <T> T getService(ServiceTypes serviceType) {
        switch (serviceType) {
//            case CUSTOMER_SERVICE:
//                return (T) new CustomerServiceIMPL();
            case ITEM_SERVICE:
                return (T) new ItemServiceImpl();
//            case ORDER_SERVICE:
//                return (T) new OrderServiceIMPL();
            default:
                throw new RuntimeException("Invalid Service Type.");
        }


    }
}
