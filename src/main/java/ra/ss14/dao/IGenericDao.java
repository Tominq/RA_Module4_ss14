package ra.ss14.dao;

import java.util.List;

public interface IGenericDao <T, E>{
    List<T> findAll(); // read

    T findById(E id);

    boolean save(T t); // creat & update

    void deleteById(E id); // delete
}
