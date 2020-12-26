package com.wcc.handler;

import com.wcc.beans.Student;
import com.wcc.duplicate.DupCheckMain;
import com.wcc.page.Page;
import com.wcc.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("student")
public class ControlHandler {

    private IStudentService studentService;

    @RequestMapping("/querystudent")
   public String querystudent(@RequestParam(defaultValue = "1") int pagenum, HttpServletRequest request, HttpServletResponse response){
       ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       studentService = (IStudentService) ac.getBean("studentService");

       Page<Student> page = studentService.findCurrentPage(pagenum);
       System.out.println("querystudent  pageStartIndex="+page.getPageStartIndex());
       request.getSession().setAttribute("pageStartIndex",page.getPageStartIndex());
       System.out.println("查询学生当前页1");
       for(Student s:page.getDatas()){
           System.out.println(s);
       }
       System.out.println("查询学生当前页2");
       //将list存放到request域中
       request.setAttribute("contactorList", page.getDatas());
       request.setAttribute("page",page);
       request.setAttribute("mainPage", "/jsp1/student_view.jsp");
       System.out.println(page.getDatas().size());
       return "admin";
   }
    @RequestMapping("/compound")
    public ModelAndView doCompound(Student student,@RequestParam("searchType") String searchType,@RequestParam("Text") String Text, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("复合查询-------------------接收到的数据");
        System.out.println(student);
        System.out.println("searchType="+searchType);
        System.out.println("Text="+Text);

        request.setAttribute("Text",Text);

        if(("student_name").equals(searchType)){
            student.setStudent_name(Text);
        }else if("university".equals(searchType)){
            student.setUniversity(Text);
        }else if("classes_name".equals(searchType)){
            student.setClasses_name(Text);
        }
        System.out.println("最终组合的student="+student);
        request.setAttribute("student1",student);

        System.out.println("pageStartIndex="+pageStartIndex);
        System.out.println("复合查询-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (IStudentService) ac.getBean("studentService");

        //执行查询业务
        List<Student> list = studentService.selectCompound1(student,pageStartIndex);
        //将list存放到request域中
        request.setAttribute("contactorList", list);
        request.setAttribute("mainPage", "/jsp1/student_view.jsp");
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
        studentService = (IStudentService) ac.getBean("studentService");

        //辨别是修改还是添加
        String student_id=null;
        student_id = request.getParameter("student_id");
        Student student = new Student();
        if(student_id!=null){
            student = studentService.findStudentById(student_id);
            request.setAttribute("student",student);
        }
        request.setAttribute("mainPage", "/jsp1/student_add.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    @RequestMapping("/add")
    public ModelAndView doAdd(Student student, Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("添加修改-------------------接收到的数据");
        System.out.println("student="+student);

        System.out.println("pageStartIndex="+pageStartIndex);
        System.out.println("添加修改-------------------接收到的数据");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (IStudentService) ac.getBean("studentService");

        //判断是添加还是修改
        //获取隐藏字段method的值，并把它转换为int型
            String id="";
            id = request.getParameter("method");
            System.out.println("method="+request.getParameter("method"));
            System.out.println("id="+id);
            if(id=="") {
                int row = studentService.addStudent(student);
                if (row > 0) {
                    System.out.println("插入成功");
                } else {
                    System.out.println("插入失败");
                }
        }
        else{
            student.setId(Integer.parseInt(request.getParameter("method")));
            System.out.println("要修改的数据----------------"+student);
            int row = studentService.modifyStudent(student);
            if(row>0) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }

        //执行查询业务
        List<Student> list = studentService.findAllStudent2(pageStartIndex);
        //将list存放到request域中
        request.setAttribute("contactorList", list);
        //跳转到查询全部学生页面
        request.setAttribute("mainPage", "/jsp1/student_view.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }


    @RequestMapping("/delete")
    public ModelAndView doDelete(Model model, HttpServletRequest request,int pageStartIndex) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("删除接收pageStartIndex="+pageStartIndex);
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = (IStudentService) ac.getBean("studentService");
        //执行删除操作
        String student_id = request.getParameter("student_id");
        studentService.removeStudent(student_id);

        //执行查询业务
        List<Student> list = studentService.findAllStudent2(pageStartIndex);
        //将list存放到request域中
        request.setAttribute("contactorList", list);
        request.setAttribute("mainPage", "/jsp1/student_view.jsp");
        System.out.println(list.size());

        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }

    @RequestMapping("/preload")
    public ModelAndView dopreload(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        request.setAttribute("mainPage", "/jsp1/fileupload.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }

    @RequestMapping("/preduplicate")
    public ModelAndView dopreduplicate(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        request.setAttribute("mainPage", "/jsp1/duplicate.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
    /**
     * 执行文件上传
     */
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("uploadfile") List<MultipartFile> uploadfile, HttpServletRequest request) {
        // 判断所上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            System.out.println("文件"+uploadfile);
            //循环输出上传的文件
            for (MultipartFile file : uploadfile) {
                // 获取上传文件的 原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/Upload/");
//                String dirPath ="D:/Upload/";
                String newFilename = name+ "_"+ UUID.randomUUID() + "_"+originalFilename;
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                    //////////////////////////////获取上传的第一个文件路径,上传人以及原始文件名
                    request.getSession().setAttribute("file1",dirPath+"\\"+newFilename);
                    request.getSession().setAttribute("name1",name);
                    request.getSession().setAttribute("originFilename1",originalFilename);
                    System.out.println("file1=="+request.getSession().getAttribute("file1"));
                }
                   /////////////////////////////////获取上传的第二个文件路径,上传人以及原始文件名
                   request.getSession().setAttribute("file2",dirPath+"\\"+newFilename);
                   request.getSession().setAttribute("name2",name);
                   request.getSession().setAttribute("originFilename2",originalFilename);
                   System.out.println("file2=="+request.getSession().getAttribute("file2"));
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath +"/"+ newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return"forward:/jsp2/error.jsp";
                }
            }

            request.setAttribute("mainPage", "/jsp2/success.jsp");

            // 跳转到成功页面
            return "admin";
        }else{
            return"forward:/jsp2/error.jsp";
        }
    }
   //    查重控制类的实现
    @RequestMapping("/duplicate")
    public ModelAndView doduplicate(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();


        String file1= (String) request.getSession().getAttribute("file1");
        System.out.println("接收到的文件file1="+file1);
        String file2= (String) request.getSession().getAttribute("file2");
        System.out.println("接收到的文件file2="+file2);
        //调用查重方法进行查重
        DupCheckMain d = new DupCheckMain();
        Double result= d.getRepetiveRate(file1, file2);

        System.out.println(result);//输出结果
        //保留两位小数
        BigDecimal b = new BigDecimal(result);
        Double r1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        Double result1=r1*100;
        request.setAttribute("result",result1+"%");
        request.setAttribute("mainPage", "/jsp2/duplicateResult.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
}
