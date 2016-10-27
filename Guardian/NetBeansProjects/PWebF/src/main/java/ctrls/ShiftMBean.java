
package ctrls;

import dao.ShiftDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Shift;

@ManagedBean
public class ShiftMBean extends AbstractCtrl<Shift>{
    private Shift shi = new Shift();
    
    public Shift getShi(){
        return shi;
    }
    
    public void setShi(Shift shi){
        this.shi = shi;
    }
    
    public List<Shift> getListAll(){
        ShiftDAO sdao = new ShiftDAO();
        
        try{
            return sdao.findAll();
        }finally{
            sdao.close();
        }
    }
    
    public String save(){
        ShiftDAO sdao = new ShiftDAO();
        
        try{
            if(shi.getId() == 0){
                sdao.create(shi);
                shi = new Shift();
            }else{
                sdao.update(shi);
            }           
        }finally{
            sdao.close();
        } 
        return null;
    }
    
    public String select(Shift shi){
        this.shi = shi;
        return null;
    }
    
    public String delete(Shift shi){
        ShiftDAO sdao = new ShiftDAO();
        try{
            sdao.delete(shi);
        }finally{
            sdao.close();
        }
        return null;
    }
}
