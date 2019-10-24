package com.ssh.service;

import com.ssh.dao.StudentDao;
import com.ssh.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public List<Student> findAll(){
        Session session=studentDao.getSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Student").list();
        transaction.commit();
        return list;
    }
    public void saveOrUpdate(Student student){
        Session session=studentDao.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
