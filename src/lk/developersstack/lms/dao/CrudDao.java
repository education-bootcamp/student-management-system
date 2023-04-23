package lk.developersstack.lms.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T,ID> {
    public void save(T t) throws SQLException, ClassNotFoundException;
    public void update(T t) throws SQLException, ClassNotFoundException;
    public T find(ID id) throws SQLException, ClassNotFoundException;
    public void delete(ID id) throws SQLException, ClassNotFoundException;
    public List<T> findAll() throws SQLException, ClassNotFoundException;
}
