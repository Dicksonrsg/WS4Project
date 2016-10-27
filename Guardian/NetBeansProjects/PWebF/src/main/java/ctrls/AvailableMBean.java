package ctrls;

import dao.AvailableDAO;
import dao.DayDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Available;
import model.Day;
import model.Teacher;

@ManagedBean
public class AvailableMBean {

    private Available ava = new Available();
    private Teacher tea = new Teacher();

    public Available getAva() {
        return ava;
    }

    public void setAva(Available ava) {
        this.ava = ava;
    }
    
    public List<Available> getListFull(){
        AvailableDAO adao = new AvailableDAO();
        try{
            return adao.findAll();
        }finally{
            adao.close();
        }        
    }

    public List<Day> getLoadShifts(){
        DayDAO ddao = new DayDAO();
        try{
            return ddao.findAll();
        }finally{
            ddao.close();
            }        
        }

    /* think on how you're loading the dayz list with days*/

    private List<Day> dayz;
    
    public List<Day> getDayz(){
        return dayz;
    }
    
    public void setDayz(List<Day> dayz){
        this.dayz = dayz;
    }

    public String save(){
        AvailableDAO adao = new AvailableDAO();
        try{
            if(ava.getId() == 0){
                ava.setTeacher(tea);
                ava.setDays(dayz);
                adao.create(ava);
                ava = new Available();
            }else{
                adao.update(ava);
            }
        }finally{
            adao.close();
        }
        return null;
    }
    
    public String select(Available ava){
        this.ava = ava;
        return null;
    }
    
    public String delete(Available ava){
        AvailableDAO adao = new AvailableDAO();
        try{
            adao.delete(ava);
        }finally{
            adao.close();
        }
        return null;
    }
}
