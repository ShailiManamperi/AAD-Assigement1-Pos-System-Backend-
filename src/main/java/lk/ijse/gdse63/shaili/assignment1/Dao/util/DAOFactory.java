package lk.ijse.gdse63.shaili.assignment1.Dao.util;


import lk.ijse.gdse63.shaili.assignment1.Dao.custom.impl.ItemDAOImpl;

public class DAOFactory {
    public static <T> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case ITEM_DAO:
                return (T) new ItemDAOImpl();
//            case ORDER_DAO:
//                return (T) new OrderDAOIMPL();
            default:
                return null;
        }

    }
}
