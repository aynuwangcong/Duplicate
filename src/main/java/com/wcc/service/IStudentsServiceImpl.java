package com.wcc.service;

import com.wcc.beans.Student;
import com.wcc.beans.Students;
import com.wcc.dao.IStudentsDao;
import com.wcc.page.Page;

import java.util.List;

public class IStudentsServiceImpl implements IStudentsService {
    IStudentsDao studentsDao;

    public void setStudentsDao(IStudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    @Override
    public int addStudents(Students student) {
        return studentsDao.insertStudents(student);
    }

    @Override
    public int modifyStudents(Students student) {
        return studentsDao.updateStudents(student);
    }

    @Override
    public int removeStudents(String i) {
        return studentsDao.deleteStudents(i);
    }

    @Override
    public Students findStudentsById(String id) {
        return studentsDao.selectStudentsById(id);
    }

    @Override
    public List<Students> findAllStudents() {
        return studentsDao.selectAllStudents();
    }


    @Override
    public List<Students> selectCompounds(Students students, int pageStartIndex) {
        return studentsDao.selectCompounds2(students,pageStartIndex);
    }

    @Override
    public List<Students> findAllStudents2(int pageStartIndex) {
        return studentsDao.selectAllStudents2(pageStartIndex);
    }

    @Override
    public List<Students> selectCompounds(Students student) {
        return studentsDao.selectCompounds(student);
    }

    @Override
    public Page<Students> findCurrentPage(int pagenum) {
        Page<Students> page = new Page<>();
        page.setPagenum(pagenum);
        int totalRows = studentsDao.selectAllStudent1();
        page.setTotalRows(totalRows);
        List<Students> datas = studentsDao.selectCurrentPage(page);
        page.setDatas(datas);
        return page;
    }

}
