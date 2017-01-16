
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_teachers")
//@XmlRootElement
public class Teacher implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tea_id")
    private int id;
    @Column(name = "tea_name")
    private String name;
    @Column(name = "tea_phone")
    private String phone;
    @Column(name = "tea_language")
    private String language;

    public Teacher() {
    }

    public Teacher(int id, String name, String phone, String language) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.language = language;
    }

    public Teacher(String name, String phone, String language) {
        this.name = name;
        this.phone = phone;
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Teacher other = (Teacher) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
