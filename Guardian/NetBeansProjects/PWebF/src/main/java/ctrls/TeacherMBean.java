package ctrls;

import model.Teacher;
import dao.TeacherDAO;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TeacherMBean extends AbstractCtrl<Teacher> {
	
    private Teacher tea = new Teacher();

    public Teacher getTea() {
        return tea;
    }

    public void setTea(Teacher tea) {
        this.tea = tea;
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
            } else{
                tdao.update(tea);
            }			
        }finally{
            tdao.close();
        }
        return null;
    }
	
    public String select(Teacher tea){
            this.tea = tea;
            return null;
    }

    public String delete(Teacher tea){
            TeacherDAO tdao = new TeacherDAO();
            try{
                    tdao.delete(tea);
            }finally{
                    tdao.close();
            }
            return null;
    }

    public Teacher findByRG(int rg){
            TeacherDAO tdao = new TeacherDAO();
            return tdao.findByRG(rg);
    }
}