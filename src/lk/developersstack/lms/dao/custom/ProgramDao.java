package lk.developersstack.lms.dao.custom;

import lk.developersstack.lms.dao.CrudDao;
import lk.developersstack.lms.entity.Program;
import lk.developersstack.lms.entity.Student;

import java.util.List;

public interface ProgramDao extends CrudDao<Program, Long> {
    public List<Long> findAllProgramIds();
}
