package lk.developersstack.lms.bo.custom.impl;

import lk.developersstack.lms.bo.custom.StudentBo;
import lk.developersstack.lms.dao.DaoFactory;
import lk.developersstack.lms.dao.custom.StudentDao;
import lk.developersstack.lms.dto.StudentDto;
import lk.developersstack.lms.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {

    private final StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public void saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException {
        Student student = new Student();
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        studentDao.save(student);
    }

    @Override
    public List<StudentDto> findAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDto> dtos = new ArrayList<>();
        for (Student s : studentDao.findAll()
        ) {
            StudentDto dto = new StudentDto(s.getId(), s.getName(), s.getContact());
            dto.setBooks(s.getBooks());
            dto.setLaptop(s.getLaptop());
            dtos.add(dto);
        }
        return dtos;
    }
}
