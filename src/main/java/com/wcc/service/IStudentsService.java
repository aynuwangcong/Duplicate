package com.wcc.service;

import com.wcc.beans.Students;
import com.wcc.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentsService {
    int addStudents(Students student);
    int modifyStudents(Students student);

    int removeStudents(String id);

    Students findStudentsById(String id);

    List<Students> findAllStudents();
    List<Students> selectCompounds(Students student);

    Page<Students> findCurrentPage(int pagenum);

    List<Students> selectCompounds(Students students,int pageStartIndex);/////////

    List<Students> findAllStudents2(int pageStartIndex);
}
