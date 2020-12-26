package com.wcc.handler;

import com.wcc.beans.Classes;
import com.wcc.beans.Student;
import com.wcc.beans.Students;
import com.wcc.page.Page;
import com.wcc.service.IClassesService;
import com.wcc.service.IStudentService;
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
@RequestMapping("classes")
public class ClassesHandler {
    private IClassesService classesService;
    @RequestMapping("/querystudent")
    public String querystudent(@RequestParam(defaultValue = "1") int pagenum, HttpServletRequest request){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");
        Page<Classes> page = classesService.findCurrentPage(pagenum);
        System.out.println("查询学生当前页1");
        for(Classes c:page.getDatas()){
            System.out.println(c);
        }
        System.out.println("查询学生当前页2");
        //将list存放到request域中
        request.setAttribute("contactorList2", page.getDatas());
        request.setAttribute("page",page);
        request.setAttribute("mainPage", "/jsp1/classes_view.jsp");
        System.out.println(page.getDatas().size());
        return "admin";
    }
    @RequestMapping("/rearch")
    public ModelAndView dosecond(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");

        //执行查询业务
        List<Classes> list = classesService.findAllClasses();
        //将list存放到request域中
        request.setAttribute("contactorList2", list);
        request.setAttribute("mainPage", "/jsp1/classes_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/preAdd")
    public ModelAndView dothird(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");

        //辨别是修改还是添加
        String classes_id=null;
        classes_id = request.getParameter("classes_id");
        Classes classes = new Classes();
        if(classes_id!=null){
            classes = classesService.findClassesById(classes_id);
            request.setAttribute("classes",classes);
        }

        request.setAttribute("mainPage", "/jsp1/classes_add.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/add")
    public ModelAndView doAdd(Classes classes, Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("-------------------接收到的数据");
        System.out.println(classes);
        System.out.println("-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");

        //判断是添加还是修改
        //获取隐藏字段method的值，并把它转换为int型
        String id="";
        id = request.getParameter("method");
        System.out.println("method="+request.getParameter("method"));
        System.out.println("id="+id);
        if(id=="") {
            int row = classesService.addClasses(classes);
            if (row > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }

        }
        else{
            classes.setClasses_id(request.getParameter("method"));
            System.out.println("要修改的数据----------------"+classes);
            int row = classesService.modifyClasses(classes);
            if(row>0) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }

        //执行查询业务
        List<Classes> list = classesService.findAllClasses();
        //将list存放到request域中
        request.setAttribute("contactorList2", list);
        //跳转到查询全部学生页面
        request.setAttribute("mainPage", "/jsp1/classes_view.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/delete")
    public ModelAndView doDelete(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");
        //执行删除操作
        String classes_id = request.getParameter("classes_id");
        classesService.removeClasses(classes_id);

        //执行查询业务
        List<Classes> list = classesService.findAllClasses();
        //将list存放到request域中
        request.setAttribute("contactorList2", list);
        request.setAttribute("mainPage", "/jsp1/classes_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/compound")
    public ModelAndView doCompound(Classes classes,Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("复合查询-------------------接收到的数据");
        System.out.println(classes);
        System.out.println("复合查询-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = (IClassesService) ac.getBean("classesService");

        //执行查询业务
        List<Classes> list = classesService.selectCompounds(classes);
        request.setAttribute("classes1",classes);
        //将list存放到request域中
        request.setAttribute("contactorList2", list);
        request.setAttribute("mainPage", "/jsp1/classes_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
}
