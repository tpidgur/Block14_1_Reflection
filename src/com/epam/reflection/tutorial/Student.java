package com.epam.reflection.tutorial;

/**
 * Created by Зая on 28.07.2016.
 */
public class Student implements Community {
    public String name;
    private int courseYear;
    private int id;

    public Student() {
    }

    public Student(String name, int courseYear, int id) {
        this.name = name;
        this.courseYear = courseYear;
        this.id = id;
    }
    public void print(){
        System.out.println("Print smth!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "com.epam.reflection.tutorial.Student{" +
                "name='" + name + '\'' +
                ", courseYear=" + courseYear +
                ", id=" + id +
                '}';
    }
}
