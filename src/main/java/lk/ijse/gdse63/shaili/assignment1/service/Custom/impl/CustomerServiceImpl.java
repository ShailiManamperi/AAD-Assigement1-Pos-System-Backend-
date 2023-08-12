package lk.ijse.gdse63.shaili.assignment1.service.Custom.impl;

import lk.ijse.gdse63.shaili.assignment1.DTO.CustomerDTO;
import lk.ijse.gdse63.shaili.assignment1.Dao.custom.CustomerDAO;
import lk.ijse.gdse63.shaili.assignment1.Dao.util.DAOFactory;
import lk.ijse.gdse63.shaili.assignment1.Dao.util.DAOTypes;
import lk.ijse.gdse63.shaili.assignment1.Util.Converter;
import lk.ijse.gdse63.shaili.assignment1.service.Custom.CustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO;

    public CustomerServiceImpl() {
        customerDAO = DAOFactory.getDAO(DAOTypes.CUSTOMER_DAO);
    }

    @Override
    public boolean add(CustomerDTO customerDTO) {
        boolean add = false;
        try {
            add = customerDAO.add(Converter.toCustomer(customerDTO));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return add;

    }

    @Override
    public boolean update(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Optional<CustomerDTO> search(String s) {
        return Optional.empty();
    }

    @Override
    public List<CustomerDTO> getAll() {
        return null;
    }
}
