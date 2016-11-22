package model;

import dao.PersistDB;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.apache.commons.lang3.text.WordUtils;

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
        WordUtils.capitalize(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Soldier{" + "id=" + id + ", user=" + user + ", password=" + password + ", name=" + name + '}';
    }
    
}
