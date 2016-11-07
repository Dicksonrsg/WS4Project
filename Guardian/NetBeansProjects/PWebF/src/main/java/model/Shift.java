package model;

import dao.PersistDB;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "tb_shifts")
public class Shift implements PersistDB, Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "shi_id")   
    private int id;
    @Column(name = "shi_group")
    private String group;

    public Shift() {
    }

    public Shift(int id, String group) {
        this.id = id;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Shift{" + "id=" + id + ", group=" + group + '}';
    }
    
}
