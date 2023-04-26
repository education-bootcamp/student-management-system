package lk.developersstack.lms.bo.custom;

import lk.developersstack.lms.dto.CreateLaptopDto;
import lk.developersstack.lms.dto.ProgramDto;

import java.sql.SQLException;

public interface ProgramBo {
    public void saveProgram(ProgramDto dto) throws SQLException, ClassNotFoundException;
    }
