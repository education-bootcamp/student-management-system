package lk.developersstack.lms.dao.custom.impl;

import lk.developersstack.lms.dao.custom.ProgramDao;
import lk.developersstack.lms.entity.Program;
import lk.developersstack.lms.entity.Registration;
import lk.developersstack.lms.entity.Student;
import lk.developersstack.lms.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramDaoImpl implements ProgramDao {
    @Override
    public void save(Program program) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            session.beginTransaction();
            session.save(program);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Program program) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Program find(Long aLong) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void delete(Long aLong) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Program> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Long> findAllProgramIds() {
       /* try(Session session = HibernateUtil.getInstance().openSession()){
            String hql="SELECT p.programId FROM Program p";
            Query query = session.createQuery(hql);
            List list = query.list();
            System.out.println(list);
        }*/
        List<Long> list = new ArrayList<>();
        try (Session session = HibernateUtil.getInstance().openSession()) {
            String hql = "FROM Program";
            Query<Program> query = session.createQuery(hql, Program.class);
            for (Program p : query.list()
            ) {
                list.add(p.getId());
            }
        }
        return list;
    }

    @Override
    public void register(long studentId, long programId) {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Query<Student> query =
                    session.createQuery("FROM Student WHERE student_id=:sId", Student.class);
            query.setParameter("sId", studentId);
            Student student = query.uniqueResult();
            if (student == null) {
                throw new RuntimeException("Student not found");
            }
            //-----------------------------
            Query<Program> pQuery =
                    session.createQuery("FROM Program WHERE program_id=:pId", Program.class);
            pQuery.setParameter("pId", programId);
            Program program = pQuery.uniqueResult();
            if (program == null) {
                throw new RuntimeException("program not found");
            }
            session.beginTransaction();
            Registration registration = new Registration();
            registration.setProgram(program);
            registration.setStudent(student);
            registration.setRegDate(new Date());
            session.save(registration);
            session.getTransaction().commit();
        }


    }

    @Override
    public List<Registration> findAllRegistrations() {
        try (Session session = HibernateUtil.getInstance().openSession()) {
            String hql = "FROM Registration";
            Query<Registration> query = session.createQuery(hql, Registration.class);
            return query.list();
        }
    }
}
