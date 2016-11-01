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

    public Soldier() {
    }

    public Soldier(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "soldier{" + "id=" + id + ", user=" + user + ", password=" + password + '}';
    }
    
}
