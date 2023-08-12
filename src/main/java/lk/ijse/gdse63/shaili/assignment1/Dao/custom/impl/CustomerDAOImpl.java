package lk.ijse.gdse63.shaili.assignment1.Dao.custom.impl;

import lk.ijse.gdse63.shaili.assignment1.DB.DBConnection;
import lk.ijse.gdse63.shaili.assignment1.Dao.custom.CustomerDAO;
import lk.ijse.gdse63.shaili.assignment1.Entity.Customer;
import lk.ijse.gdse63.shaili.assignment1.Entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    private static String error_Info = "";

    public static String getError_Info() {
        return error_Info;
    }

    public void setError_Info(String e) {
        error_Info = e;

    }

    @Override
    public boolean add(Customer customer) throws SQLException {
        int status = 0;
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
            ps.setString(1,customer.getId());
            ps.setString(2,customer.getName());
            ps.setString(3,customer.getAddress());
            ps.setInt(4,customer.getContact());
            status = ps.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println("Message.." + ex.getMessage());
            ex.printStackTrace();
        }
        if (status > 0){
            System.out.println("pass true");
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Optional<Customer> search(String s) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
