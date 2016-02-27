package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
@NamedQueries({
        @NamedQuery(
                name = "com.example.helloworld.core.Person.findAll",
                query = "SELECT p FROM Person p"
        )
})
public class Person {

    @Id
	//@Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    @GeneratedValue(generator="InvSeq") 
    @SequenceGenerator(name="InvSeq",sequenceName="PERSON_SEQ", allocationSize=5) 		
    private long id;

    @Column(name = "FULLNAME", nullable = false)
    private String fullName;

    @Column(name = "JOBTITLE", nullable = false)
    private String jobTitle;

    public Person() {
    }

    public Person(String fullName, String jobTitle) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        final Person that = (Person) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.fullName, that.fullName) &&
                Objects.equals(this.jobTitle, that.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, jobTitle);
    }
}
