package entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private Department dept;


    @Id
    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Basic
    @Column (name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column (name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null);
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;

}
    }

