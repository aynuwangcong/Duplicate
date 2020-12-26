package com.wcc.service;

import com.wcc.beans.Classes;
import com.wcc.beans.Student;
import com.wcc.dao.IClassesDao;
import com.wcc.page.Page;

import java.util.List;

public class IClassesServiceImpl implements IClassesService {
   IClassesDao classesDao;

    public void setClassesDao(IClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public int addClasses(Classes classes) {
        return classesDao.insertClasses(classes);
    }

    @Override
    public int modifyClasses(Classes classes) {
        return classesDao.updateClasses(classes);
    }

    @Override
    public int removeClasses(String id) {
        return classesDao.deleteClasses(id);
    }

    @Override
    public Classes findClassesById(String id) {
        return classesDao.selectClassesById(id);
    }

    @Override
    public List<Classes> findAllClasses() {
        return classesDao.selectAllClasses();
    }

    @Override
    public List<Classes> selectCompounds(Classes classes) {
        return classesDao.selectCompound(classes);
    }

    @Override
    public Page<Classes> findCurrentPage(int pagenum) {
        Page<Classes> page = new Page<>();
        page.setPagenum(pagenum);
        int totalRows = classesDao.selectAllStudent1();
        page.setTotalRows(totalRows);
        List<Classes> datas = classesDao.selectCurrentPage(page);
        page.setDatas(datas);
        return page;
    }
}
