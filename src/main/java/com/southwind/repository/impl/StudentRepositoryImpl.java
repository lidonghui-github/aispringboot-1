package com.southwind.repository.impl;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L,new Student(1L,"zhangsan1",20));
        studentMap.put(2L,new Student(2L,"zhangsan1",21));
        studentMap.put(3L,new Student(3L,"zhangsan1",22));
        studentMap.put(4L,new Student(4L,"zhangsan1",23));
        studentMap.put(5L,new Student(5L,"zhangsan1",24));


    }
    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
