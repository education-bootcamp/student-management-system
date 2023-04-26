package lk.developersstack.lms.bo.custom.impl;

import lk.developersstack.lms.bo.custom.LaptopBo;
import lk.developersstack.lms.dao.DaoFactory;
import lk.developersstack.lms.dao.custom.LaptopDao;
import lk.developersstack.lms.dto.CreateLaptopDto;
import lk.developersstack.lms.entity.Laptop;

import java.sql.SQLException;

public class LaptopBoImpl implements LaptopBo {
    LaptopDao laptopDao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.LAPTOP);
    @Override
    public void saveLaptop(CreateLaptopDto dto) throws SQLException, ClassNotFoundException {
        Laptop laptop = new Laptop();
        laptop.setBrand(dto.getBrand());
        laptopDao.saveLaptopWithStudentId(dto.getStudentId(), laptop);
    }
}
