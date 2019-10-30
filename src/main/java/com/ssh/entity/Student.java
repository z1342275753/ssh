package com.ssh.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({@NamedQuery(name = "findById",query = "from Student where id=:id")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private Integer fenzu;
    @Column
    private Timestamp time;
    /**
     * 多对一
     */
    @ManyToOne
    /**
     * 一对一
     */
//    @OneToOne(cascade = CascadeType.ALL)
    /**
     * 多对多
     */
//    @ManyToMany
//    @JoinTable(name = "aaaa_student",
//            joinColumns = {@JoinColumn(name = "aaa_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName ="id")})
    private Aaaa aaa;


//
    public Aaaa getAaa() {
        return aaa;
    }

    public void setAaa(Aaaa aaa) {
        this.aaa = aaa;
    }


//    public Set<Aaaa> getAaa() {
//        return aaa;
//    }
//
//    public void setAaa(Set<Aaaa> aaa) {
//        this.aaa = aaa;
//    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getFenzu() {
        return fenzu;
    }

    public void setFenzu(Integer fenzu) {
        this.fenzu = fenzu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", fenzu=" + fenzu +
                ", time=" + time +
                ", aaa=" + aaa +
                '}';
    }
}
