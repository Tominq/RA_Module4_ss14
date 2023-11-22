package ra.ss14.service;

import java.util.List;

public interface IGenericService <T,U, E>{
    List<T> findAll(); // read

    T findById(E id);

    boolean save(U u); // creat & update

    void deleteById(E id); // delete


}
