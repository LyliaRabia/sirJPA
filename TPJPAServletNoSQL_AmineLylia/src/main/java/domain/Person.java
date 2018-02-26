package domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Person {
    private Long id;
    private String name;
    private Department department;
    public Person() {
    }
    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    public Person(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }
}
