package ctrls;

import dao.DayDAO;
import dao.ShiftDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Day;
import model.Shift;

@ManagedBean(name = "dayMBean")
@ViewScoped
public class DayMBean {
    private Day d = new Day();
    private Shift shi = new Shift();
    private List<Shift> shiftz ;
    
    public Day getDays(){
        return d;
    }
    
    public void setDays(Day d){
        this.d = d;
    }
    
    public Shift getShi() {
        return shi;
    }

    public void setShi(Shift shi) {
        this.shi = shi;
    }    
    
    public List<Day> getListFull(){
        DayDAO ddao = new DayDAO();
        try{
            return ddao.findAll();
        }finally{
            ddao.close();
        }        
    }
    
    public List<Shift> getLoadShifts(){
        ShiftDAO sdao = new ShiftDAO();
        try{
            return sdao.findAll();
        }finally{
            sdao.close();
            }        
        }
    
    /* think on how you're loading the shiftz list with shifts*/

    public List<Shift> getSelectedShiftz(){
        return shiftz;
    }
    
    public void setSelectedShiftz(List<Shift> shiftz){
        this.shiftz = shiftz;
    }
    
    public String save(){
        DayDAO ddao = new DayDAO();
        try{
            if(d.getId() == 0){
                d.setName("Segunda");
                d.setShifts(shiftz);
                ddao.create(d);
                d = new Day();
                shiftz = new ArrayList();
            }else{
                ddao.update(d);
            }           
        }finally{
            ddao.close();
        }
        return null;
    }
    
    public String select(Day d){
        this.d = d;
        return null;
    }
    
    public String delete(Day d){
        DayDAO ddao = new DayDAO();
        try{
            ddao.delete(d);
        }finally{
            ddao.close();
        }
        return null;
    }
    
    public void addMF(){
        ShiftDAO sdao = new ShiftDAO();
        try{
            shi = sdao.findByPK(shi.getId());            
            shiftz.add(shi);
            shi = new Shift();
        }catch(Exception error){
            System.out.println("Erro: " + error.toString());
        }
    }
    
    public void addSelectedShift(){
        ShiftDAO sdao = new ShiftDAO();
        try{
            shi = sdao.selectedShift();
            sdao.create(shi);
            shiftz.add(shi);
            shi = new Shift();
        }catch(Exception error){
            System.out.println("Erro: " + error.toString());
        }
    }
}
