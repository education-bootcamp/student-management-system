package lk.developersstack.lms.dao.custom;

import lk.developersstack.lms.dao.CrudDao;
import lk.developersstack.lms.entity.Laptop;
import lk.developersstack.lms.entity.Student;

public interface LaptopDao extends CrudDao<Laptop, Long> {
    public void saveLaptopWithStudentId(long studentId, Laptop laptop);
}
