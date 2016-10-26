package model;

import dao.PersistDB;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "tb_days")
public class Days implements PersistDB{
    
    @Id
    @GeneratedValue
    @Column(name = "day_id") 
    private int id;
    @Column(name = "day_name")
    private String name;
    @OneToMany
    @JoinColumn(name = "day_shi_id")
    private List<Shift> shifts;

    public Days() {
    }

    public Days(int id, String name, List<Shift> shifts) {
        this.id = id;
        this.name = name;
        this.shifts = shifts;
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
