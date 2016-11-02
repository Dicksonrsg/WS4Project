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
    private List<Shift> shiftz = new ArrayList<>();
    private List<String> selectedShifts;
    
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
    
    public List<String> getSelectedShifts() {
        return selectedShifts;
    }

    public void setSelectedShifts(List<String> selectedShifts) {
        this.selectedShifts = selectedShifts;
    }

    public List<Shift> getShiftz(){
        return shiftz;
    }
    
    public void setShiftz(List<Shift> shiftz){
        this.shiftz = shiftz;
    }
    
    public void insertMonday(){
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            for(String group : selectedShifts){
                shi = sdao.searchByGroup(group);
                shiftz.add(shi);
            }
            d.setName("Segunda");
            d.setShifts(shiftz);
            ddao.create(d);
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }finally{
            ddao.close();
            sdao.close();
        }       
    }

    public void insertTuesday(){
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            for(String group : selectedShifts){
                shi = sdao.searchByGroup(group);
                shiftz.add(shi);
            }
            d.setName("Terca");
            d.setShifts(shiftz);
            ddao.create(d);
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }finally{
            ddao.close();
            sdao.close();
        }       
    }    
    
    public void insertWednesday(){
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            for(String group : selectedShifts){
                shi = sdao.searchByGroup(group);
                shiftz.add(shi);
            }
            d.setName("Quarta");
            d.setShifts(shiftz);
            ddao.create(d);
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }finally{
            ddao.close();
            sdao.close();
        }       
    }

    public void insertThursday(){
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            for(String group : selectedShifts){
                shi = sdao.searchByGroup(group);
                shiftz.add(shi);
            }
            d.setName("Quinta");
            d.setShifts(shiftz);
            ddao.create(d);
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }finally{
            ddao.close();
            sdao.close();
        }       
    }

    public void insertFriday(){
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            for(String group : selectedShifts){
                shi = sdao.searchByGroup(group);
                shiftz.add(shi);
            }
            d.setName("Sexta");
            d.setShifts(shiftz);
            ddao.create(d);
        }catch(Exception error){
            System.out.println("Erro: " + error);
        }finally{
            ddao.close();
            sdao.close();
        }       
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

}
