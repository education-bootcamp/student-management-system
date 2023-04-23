package lk.developersstack.lms.dao.custom.impl;

import lk.developersstack.lms.dao.custom.StudentDao;
import lk.developersstack.lms.entity.Student;
import lk.developersstack.lms.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl  implements StudentDao {
    @Override
    public void save(Student student) throws SQLException, ClassNotFoundException {
        try(Session session = HibernateUtil.getInstance().openSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Student find(Long aLong) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        try(Session session = HibernateUtil.getInstance().openSession()){
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}
