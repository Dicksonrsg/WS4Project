package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import dao.PersistDB;

@Entity(name = "tb_teachers")
public class Teacher implements PersistDB{
	
    @Id
    @GeneratedValue
    @Column(name = "tea_id")
    private int id;
    @Column(name = "tea_rg")
    private int rg;
    @Column(name = "tea_name")
    private String name;
    @Column(name = "tea_lang")
    private String langauge;
    @Column(name = "tea_phone")
    private String phone;
    
    public Teacher(){}

    public Teacher(int id, int rg, String name, String langauge, String phone) {
        this.id = id;
        this.rg = rg;
        this.name = name;
        this.langauge = langauge;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLangauge() {
        return langauge;
    }

    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", rg=" + rg + ", name=" + name + ", langauge=" + langauge + ", phone=" + phone + '}';
    }

}
