package model;

import dao.PersistDB;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tb_soldiers")
public class Soldier implements PersistDB, Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "sol_id")
    private int id;
    @Column(name = "sol_user")
    private String user;
    @Column(name = "sol_password")
    private String password;
    @Column(name = "sol_name")
    private String name;

    public Soldier() {
    }

    public Soldier(int id, String user, String password, String name) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Soldier{" + "id=" + id + ", user=" + user + ", password=" + password + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
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
        final Soldier other = (Soldier) obj;
        return true;
    }
 
}
