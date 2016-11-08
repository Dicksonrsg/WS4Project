package model;

import dao.PersistDB;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name = "tb_days")
public class Day implements PersistDB, Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "day_id") 
    private int id;
    @Column(name = "day_name")
    private String name;
    @ManyToMany
    @JoinColumn(name = "day_shi_id")
    private List<Shift> shifts;

    public Day() {
    }

    public Day(int id, String name, List<Shift> shifts) {
        this.id = id;
        this.name = name;
        this.shifts = shifts;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public String toString() {
        return "Days{" + "id=" + id + ", name=" + name + ", shifts=" + shifts + '}';
    }

}
