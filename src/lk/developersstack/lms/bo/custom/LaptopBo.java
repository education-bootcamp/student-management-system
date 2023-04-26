package lk.developersstack.lms.bo.custom;

import lk.developersstack.lms.dto.CreateLaptopDto;
import lk.developersstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface LaptopBo {
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException;
    }
