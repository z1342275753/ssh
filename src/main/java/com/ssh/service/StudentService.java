package com.ssh.service;

import com.ssh.dao.StudentDao;
import com.ssh.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Queue;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public List<Student> findAll(){
        Session session=studentDao.getSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Student").list();
//        System.out.println(list.get(0));
        transaction.commit();
//        Session session1=studentDao.getSession();
//        Transaction transaction1 = session1.beginTransaction();
//        Student s1= (Student) session1.get(Student.class,6);
//        System.out.println(s1);
//        transaction1.commit();
//        Session session2=studentDao.getSession();
//        Transaction transaction2 = session2.beginTransaction();
//        Student s2= (Student) session2.get(Student.class,6);
//        System.out.println(s1);
//        transaction2.commit();
        session.close();
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
