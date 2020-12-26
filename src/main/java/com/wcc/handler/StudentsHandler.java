package com.wcc.handler;

import com.wcc.beans.Students;
import com.wcc.page.Page;
import com.wcc.service.IStudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentsHandler {
    private IStudentsService studentsService;
    @RequestMapping("/querystudent")
    public String querystudent(@RequestParam(defaultValue = "1") int pagenum, HttpServletRequest request){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentsService = (IStudentsService) ac.getBean("studentsService");
        Page<Students> page = studentsService.findCurrentPage(pagenum);
        System.out.println("querystudent  pageStartIndex="+page.getPageStartIndex());
        request.getSession().setAttribute("pageStartIndex",page.getPageStartIndex());
        System.out.println("查询学生当前页1");
        for(Students s:page.getDatas()){
            System.out.println(s);
        }
        System.out.println("查询学生当前页2");
        //将list存放到request域中
        request.setAttribute("contactorList1", page.getDatas());
        request.setAttribute("page",page);
        request.setAttribute("mainPage", "/jsp1/students_view.jsp");
        System.out.println(page.getDatas().size());
        return "admin";
    }
    @RequestMapping("/compound")
    public ModelAndView doCompound(Students students,@RequestParam("searchType") String searchType,Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("复合查询-------------------接收到的数据");
        System.out.println("students="+students);
        System.out.println("searchType="+searchType);
        if("优秀".equals(searchType)){
            students.setS_total_score(1.0);
        }else if("良好".equals(searchType)){
            students.setS_total_score(2.0);
        }else if("及格".equals(searchType)){
            students.setS_total_score(3.0);
        }else if("不及格".equals(searchType)){
            students.setS_total_score(4.0);
        }
        System.out.println("pageStartIndex="+pageStartIndex);
        System.out.println("组合后的students="+students);
        System.out.println("复合查询-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentsService = (IStudentsService) ac.getBean("studentsService");

        //执行查询业务
        List<Students> list = studentsService.selectCompounds(students,pageStartIndex);/////////////
        request.setAttribute("students1",students);
        //将list存放到request域中
        request.setAttribute("contactorList1", list);
        request.setAttribute("mainPage", "/jsp1/students_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }

    @RequestMapping("/preAdd")
    public ModelAndView dothird(Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("预添加修改接收的数据 pageStartIndex="+pageStartIndex);
        request.setAttribute("pageStartIndex",pageStartIndex);

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentsService = (IStudentsService) ac.getBean("studentsService");

        //辨别是修改还是添加
        String student_id=null;
        student_id = request.getParameter("student_id");
        Students students = new Students();
        if(student_id!=null){
            students = studentsService.findStudentsById(student_id);
            request.setAttribute("students",students);
        }

        request.setAttribute("mainPage", "/jsp1/students_add.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/add")
    public ModelAndView doAdd(Students students, Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("-------------------接收到的数据");
        System.out.println("students="+students);
        System.out.println("pageStartIndex="+pageStartIndex);
        System.out.println("-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentsService = (IStudentsService) ac.getBean("studentsService");

        //判断是添加还是修改
        //获取隐藏字段method的值，并把它转换为int型
        String id="";
        id = request.getParameter("method");
        System.out.println("method="+request.getParameter("method"));
        System.out.println("id="+id);
        if(id=="") {
            int row = studentsService.addStudents(students);
            if (row > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }

        }
        else{
            students.setStudent_id(request.getParameter("method"));
            System.out.println("要修改的数据----------------"+students);
            int row = studentsService.modifyStudents(students);
            if(row>0) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }

        //执行查询业务
        List<Students> list = studentsService.findAllStudents2(pageStartIndex);
        //将list存放到request域中
        request.setAttribute("contactorList1", list);
        //跳转到查询全部学生页面
        request.setAttribute("mainPage", "/jsp1/students_view.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/delete")
    public ModelAndView doDelete(Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentsService = (IStudentsService) ac.getBean("studentsService");
        //执行删除操作
        String student_id = request.getParameter("student_id");
        studentsService.removeStudents(student_id);

        //执行查询业务
        List<Students> list = studentsService.findAllStudents2(pageStartIndex);
        //将list存放到request域中
        request.setAttribute("contactorList1", list);
        request.setAttribute("mainPage", "/jsp1/students_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
}
