package lk.ijse.gdse63.shaili.assignment1.service;



import lk.ijse.gdse63.shaili.assignment1.DTO.SuperDTO;

import java.util.List;
import java.util.Optional;

public interface SuperService<T extends SuperDTO,ID> {
    boolean add(T t);

    boolean update(T t);

    boolean delete(ID id);

    Optional<T>search(ID id);

    List<T> getAll();
}
