package ctrls;

import model.Teacher;
import dao.TeacherDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "teacherMBean")
@SessionScoped
public class TeacherMBean extends AbstractCtrl<Teacher> implements Serializable{
	
    private Teacher tea = new Teacher();
    private String rg = new String();   

    public Teacher getTea() {
        return tea;
    }

    public void setTea(Teacher tea) {
        this.tea = tea;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }    
    
    public List<Teacher> getListAll(){
        TeacherDAO tdao = new TeacherDAO();
        try{
           return tdao.findAll();
        }finally{
                tdao.close();
        }
    }
	
    public String save(){
        TeacherDAO tdao = new TeacherDAO();	
        try{
            if(tea.getId() == 0){
                tdao.create(tea);
                tea = new Teacher();                
                addInfo("Professsor cadastrado!");               
            } else{
                tdao.update(tea);
                addInfo("Cadastrado atualizado!");
            }
        }finally{
            tdao.close();
        }
        return "main";
    }
	
    public String select(Teacher tea){
        this.tea = tea;
        return null;
    }

    public String delete(Teacher tea){
        TeacherDAO tdao = new TeacherDAO();
        try{
            tdao.delete(tea);
            addInfo("Deletado com sucesso!");
        }finally{
                tdao.close();
        }
        return "main";
    }

    public Teacher findByRG(){
        TeacherDAO tdao = new TeacherDAO();
        try{
            if(rg != null){
                if(rg.length() < 4){
                    addWarn("O campo matricula precisa de 4 digitos.");
                }else{
                    int rg2 = Integer.parseInt(rg);
                    tea = tdao.findByRG(rg2);
                    return tea;
                }
            }else{
                addWarn("Matricula não pode ser vazia!");
            }            
        }catch(NumberFormatException error){
            System.out.println("Erro: " + error);
        }finally{
            rg = new String();
            tea = new Teacher();
            tdao.close();
        }    
        return null;
    }

}