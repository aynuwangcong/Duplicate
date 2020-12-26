package com.wcc.dao;


import com.wcc.beans.Classes;
import com.wcc.page.Page;

import java.util.List;

public interface IClassesDao {
    int insertClasses(Classes classes);

    int updateClasses(Classes classes);

    int deleteClasses(String id);

    Classes selectClassesById(String id);

    List<Classes> selectAllClasses();
    List<Classes> selectCompound(Classes classes);

    int selectAllStudent1();

    List<Classes> selectCurrentPage(Page<Classes> page);
}
