package ctrls;

import javax.faces.bean.ManagedBean;
import model.Available;

@ManagedBean
public class AvailableMBean {

    private Available ava = new Available();

    public Available getAva() {
        return ava;
    }

    public void setAva(Available ava) {
        this.ava = ava;
    }
    
    
}
