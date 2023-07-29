package lk.ijse.gdse63.shaili.assignment1.service.Custom.impl;

import lk.ijse.gdse63.shaili.assignment1.DTO.ItemDTO;
import lk.ijse.gdse63.shaili.assignment1.Dao.custom.ItemDAO;
import lk.ijse.gdse63.shaili.assignment1.Dao.util.DAOFactory;
import lk.ijse.gdse63.shaili.assignment1.Dao.util.DAOTypes;
import lk.ijse.gdse63.shaili.assignment1.service.Custom.ItemService;

import lk.ijse.gdse63.shaili.assignment1.Util.Converter;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {


    @Override
    public boolean add(ItemDTO itemDTO) {
        ItemDAO itemDAO = DAOFactory.getDAO(DAOTypes.ITEM_DAO);
        boolean add = false;
        try {
            add = itemDAO.add(Converter.toItem(itemDTO));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return add;
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Optional<ItemDTO> search(String s) {
        return Optional.empty();
    }

    @Override
    public List<ItemDTO> getAll() {
        return null;
    }
}
