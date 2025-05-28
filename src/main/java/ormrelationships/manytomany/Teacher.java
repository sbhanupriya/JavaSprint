package ormrelationships.manytomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Teacher {
    @Id
    private int tid;
    private String name;
    @ManyToMany
    private List<Course> courses;

    public int getId() {
        return tid;
    }

    public void setId(int id) {
        this.tid = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + tid +
                ", name='" + name + '\'' +
                ", courses=" + courses.toString() +
                '}';
    }
}
