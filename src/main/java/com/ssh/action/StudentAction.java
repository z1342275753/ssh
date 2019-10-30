package com.ssh.action;

import com.ssh.entity.Student;
import com.ssh.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class StudentAction {
    @Autowired
    private StudentService studentService;
    private Student student;
    private File file;
    private String fileFileName;
    private String fileContentType;
    private String me="123";
    public String login(){
        List<Student> students=studentService.findAll();
        for (Student s:students
             ) {
            System.out.println(s);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("students",students);

        return "login";
    }
    public String saveOrUpdate(){
        studentService.saveOrUpdate(student);
        return "login";
    }

    public String file() throws IOException {
        String realPath= ServletActionContext.getServletContext().getRealPath("/images");
        File newfile=new File(realPath);
        if(!newfile.exists()){
            newfile.mkdirs();
        }
        FileUtils.copyFile(file,new File(newfile,fileFileName));
        return "login";
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getMe() {
        return me;
    }
}
