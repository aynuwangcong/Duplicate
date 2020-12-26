package com.wcc.dao;

import com.wcc.beans.Students;
import com.wcc.page.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentsDao {
    int insertStudents(Students student);

    int updateStudents(Students student);

    int deleteStudents(String id);

    Students selectStudentsById(String id);

    List<Students> selectAllStudents();
    List<Students> selectCompounds(Students student);

    int selectAllStudent1();

    List<Students> selectCurrentPage(Page<Students> page);

    List<Students> selectCompounds2(@Param("student_message") Students student_message,@Param("pageStartIndex") int pageStartIndex);

    List<Students> selectAllStudents2(int pageStartIndex);
}
