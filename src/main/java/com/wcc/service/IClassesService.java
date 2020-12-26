package com.wcc.service;

import com.wcc.beans.Classes;
import com.wcc.page.Page;

import java.util.List;

public interface IClassesService {
    int addClasses(Classes classes);
    int modifyClasses(Classes classes);

    int removeClasses(String id);

    Classes findClassesById(String id);

    List<Classes> findAllClasses();
    List<Classes> selectCompounds(Classes classes);

    Page<Classes> findCurrentPage(int pagenum);
}
