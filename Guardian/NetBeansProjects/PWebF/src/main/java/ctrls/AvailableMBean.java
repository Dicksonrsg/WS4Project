package ctrls;

import dao.AvailableDAO;
import dao.DayDAO;
import dao.ShiftDAO;
import dao.TeacherDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Available;
import model.Day;
import model.Shift;
import model.Teacher;

@ManagedBean(name = "avaMBean")
public class AvailableMBean extends AbstractCtrl<Available> implements Serializable{

    private Available ava = new Available();
    private Teacher tea = new Teacher();
    private List<Day> dayz = new ArrayList<>();
    private String trg = new String();
    private Day da = new Day();
    private List<String> selectedShiftsM, selectedShiftsTu,selectedShiftsW,selectedShiftsTh,selectedShiftsF;
    private Shift shi = new Shift();
    private List<Shift> shiftz = new ArrayList<>();

    public Available getAva() {
        return ava;
    }

    public void setAva(Available ava) {
        this.ava = ava;
    }
    
    public Teacher getTea() {
        return tea;
    }

    public void setTea(Teacher tea) {
        this.tea = tea;
    }

    public String getTrg() {
        return trg;
    }

    public void setTrg(String trg) {
        this.trg = trg;
    }
    
    public Day getDa() {
        return da;
    }

    public void setDa(Day da) {
        this.da = da;
    }     
    
        public List<String> getSelectedShiftsM() {
        return selectedShiftsM;
    }

    public void setSelectedShiftsM(List<String> selectedShiftsM) {
        this.selectedShiftsM = selectedShiftsM;
    }

    public Shift getShi() {
        return shi;
    }

    public void setShi(Shift shi) {
        this.shi = shi;
    }

    public List<Shift> getShiftz() {
        return shiftz;
    }

    public void setShiftz(List<Shift> shiftz) {
        this.shiftz = shiftz;
    }

    public List<String> getSelectedShiftsTu() {
        return selectedShiftsTu;
    }

    public void setSelectedShiftsTu(List<String> selectedShiftsTu) {
        this.selectedShiftsTu = selectedShiftsTu;
    }

    public List<String> getSelectedShiftsW() {
        return selectedShiftsW;
    }

    public void setSelectedShiftsW(List<String> selectedShiftsW) {
        this.selectedShiftsW = selectedShiftsW;
    }

    public List<String> getSelectedShiftsTh() {
        return selectedShiftsTh;
    }

    public void setSelectedShiftsTh(List<String> selectedShiftsTh) {
        this.selectedShiftsTh = selectedShiftsTh;
    }

    public List<String> getSelectedShiftsF() {
        return selectedShiftsF;
    }

    public void setSelectedShiftsF(List<String> selectedShiftsF) {
        this.selectedShiftsF = selectedShiftsF;
    }
    
    public List<Available> getListFull(){
        AvailableDAO adao = new AvailableDAO();
        try{
            return adao.findAll();
        }finally{
            adao.close();
        }        
    }
    
    public List<Day> getListAllDays(){
        DayDAO ddao = new DayDAO();
        try{
            return ddao.findAll();
        }finally{
            ddao.close();
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
    
    public List<Day> getDayz(){
        return dayz;
    }
    
    public void setDayz(List<Day> dayz){
        this.dayz = dayz;
    }

    public void addSaturday(){
        Day saturday = new Day();
        List<Shift> sls = new ArrayList<>();
        Shift seven = new Shift();
        seven.setGroup("08:00-12:00");
        sls.add(seven);
        saturday.setName("Saturday");
        saturday.setShifts(sls);
        dayz.add(saturday);
        for(Day z : dayz){System.out.println("here: " + z.toString());}
    }
    
    public void delSaturday(){
        String sat = "Saturday";
        dayz.removeIf(p -> p.getName().equals(sat));
    }
    
    public String save(){
        AvailableDAO adao = new AvailableDAO();
        DayDAO ddao = new DayDAO();
        ShiftDAO sdao = new ShiftDAO();
        try{
            if(ava.getId() == 0){
                    tea = findByRG();
                    ava.setTeacher(tea);
                    if (selectedShiftsM.isEmpty() == false){                   
                        try{
                            List<Shift> shiftM = new ArrayList<>();
                            for(String group : selectedShiftsM){                           
                                shi = sdao.searchByGroup(group);
                                shiftM.add(shi);
                            }
                            da.setName("Segunda");
                            da.setShifts(shiftM);
                            ddao.create(da);
                            dayz.add(da);
                        }catch(Exception error){
                            System.out.println("Erro: " + error);
                        }finally{
                            ddao.close();
                            sdao.close();
                            da = new Day();
                        }  
                    }
                    if (selectedShiftsTu.isEmpty() == false){                   
                        try{
                            List<Shift> shiftTu = new ArrayList<>();
                            for(String group : selectedShiftsTu){
                                shi = sdao.searchByGroup(group);
                                shiftTu.add(shi);
                            }
                            da.setName("Terca");
                            da.setShifts(shiftTu);
                            ddao.create(da);
                            dayz.add(da);
                        }catch(Exception error){
                            System.out.println("Erro: " + error);
                        }finally{
                            ddao.close();
                            sdao.close();
                            da = new Day();
                        }  
                    }
                    if (selectedShiftsW.isEmpty() == false){                   
                        try{
                            List<Shift> shiftW = new ArrayList<>();
                            for(String group : selectedShiftsW){
                                shi = sdao.searchByGroup(group);
                                shiftW.add(shi);
                            }
                            da.setName("Quarta");
                            da.setShifts(shiftW);
                            ddao.create(da);
                            dayz.add(da);
                        }catch(Exception error){
                            System.out.println("Erro: " + error);
                        }finally{
                            ddao.close();
                            sdao.close();
                            da = new Day();
                        }  
                    }
                    if (selectedShiftsTh.isEmpty() == false){                    
                        try{
                            List<Shift> shiftTh = new ArrayList<>();
                            for(String group : selectedShiftsTh){
                                shi = sdao.searchByGroup(group);
                                shiftTh.add(shi);
                            }
                            da.setName("Quinta");
                            da.setShifts(shiftTh);
                            ddao.create(da);
                            dayz.add(da);
                        }catch(Exception error){
                            System.out.println("Erro: " + error);
                        }finally{
                            ddao.close();
                            sdao.close();
                            da = new Day();
                        }  
                    }  
                    if (selectedShiftsF.isEmpty() == false){                   
                        try{
                            List<Shift> shiftF = new ArrayList<>();
                            for(String group : selectedShiftsF){
                                shi = sdao.searchByGroup(group);
                                shiftF.add(shi);
                            }
                            da.setName("Sexta");
                            da.setShifts(shiftF);
                            ddao.create(da);
                            dayz.add(da);
                        }catch(Exception error){
                            System.out.println("Erro: " + error);
                        }finally{
                            ddao.close();
                            sdao.close();
                            da = new Day();
                        }  
                    }
                    addInfo("Salvo com Sucesso");
                    ava.setDays(dayz);
                    adao.create(ava);
            }else{
                addInfo("Cadastrado atualizado!");
                adao.update(ava);
            }
        }finally{
            adao.close();
            tea = new Teacher();
            ava = new Available();
            da = new Day();
        }
        return "ava";
    }
    
    public String selectAva(Available ava){
        this.ava = ava;
        return null;
    }
    
    public String deleteAva(Available ava){
        AvailableDAO adao = new AvailableDAO();        
        try{
            for(Day day : ava.getDays()){
                deleteDay(day);
            }
            adao.delete(ava);
            addInfo("Deletado com sucesso!");
        }finally{
            adao.close();
        }
        return "ava";
    }
    
    public String deleteDay(Day d){
        DayDAO ddao = new DayDAO();
        try{
            ddao.delete(d);
        }finally{
            ddao.close();
        }
        return null;
    }    
    
    public String select(Day da){
        this.da = da;
        return null;
    }       

    public Teacher findByRG(){
        TeacherDAO tdao = new TeacherDAO();
        try{
            if(trg.isEmpty() == false){
                int rg2 = Integer.parseInt(trg);
                tea = tdao.findByRG(rg2);
            }else{
                addWarn("Selecione um professor e click no bt selecionar");
            }
        }catch(NumberFormatException error){
            System.out.println("Erro: " + error);
        }finally{
            tdao.close();
        }    
        return tea;
    }    
    
}
