package com.ssh.dao;

import com.ssh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SessionFactory sessionFactory;
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    public Session getSession(){
        //getCurrentSession 必须事物
        return sessionFactory.getCurrentSession();
//        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
