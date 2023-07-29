package lk.ijse.gdse63.shaili.assignment1.Dao;



import lk.ijse.gdse63.shaili.assignment1.Entity.SuperEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SuperDAO<T extends SuperEntity, ID> {
    boolean add(T t) throws SQLException;

    boolean update(T t);

    boolean delete(ID id);

    Optional<T> search(ID id);

    List<T> getAll();
}
