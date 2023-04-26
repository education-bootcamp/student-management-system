package lk.developersstack.lms.bo.custom;

import lk.developersstack.lms.dto.CreateLaptopDto;
import lk.developersstack.lms.dto.ProgramDto;
import lk.developersstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBo {
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;

    List<Long> findAllStudentIds();
    void register(long studentId, long programId);
}
