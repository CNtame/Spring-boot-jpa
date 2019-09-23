package com.example.abert.entity;

//import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


//@Entity注解表明它是一个JPA实体
@Entity
@Table(name="tab")
//@Data
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = false)
//@AllArgsConstructor
//@NoArgsConstructor

public class User
{
//    id属性加了@Id和@GeneratedValue注解，说明这个字段 是实体的唯一标识，并且这个字段的值是自动生成的。

    @Id
    @GeneratedValue(strategy = GenerationType. AUTO)
    @Column(name = "id")
    private Long id;


   @Column(nullable = false,unique = true)
    private String name;
    @Column
    private String sex;
   @Column
    private int age;
   @Column
    private int score;

    public Long getId()
    {
        return id;
    }
    public void setId(Long d)
    {
        this.id=d;
    }

    public void setName(String a)
    {
        name=a;
    }
    public String getName()
    {
        return name;
    }

    public void setSex(String a)
    {
        sex=a;
    }
    public String getSex()
    {
        return sex;
    }

    public void setAge(int a)
    {
        age=a;
    }
    public int getAge()
    {
        return age;
    }

    public void setScore(int a)
    {
        score=a;
    }
    public int getScore()
    {
        return score;
    }
    public User(String a, String b,int c, int d)
    {
        name=a;
        sex=b;
        age=c;
        score=d;
    }
    public User()
    {

    }
/*    public User(int e,String a, String b,int c, int d)
    {
        id=e;
        name=a;
        sex=b;
        age=c;
        score=d;
    }*/


}
