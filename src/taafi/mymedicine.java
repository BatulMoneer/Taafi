/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taafi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author albat
 */
@Entity
@Table(name="mymedicine")
public class mymedicine implements java.io.Serializable{
    
    @Id
     @Column(name="id")
     private int medicineid;
    @Id
     @Column(name="medicinename")
     private String medicinename;
    
    public mymedicine() {
       this.medicineid = 0;
        this.medicinename = null;
    }
    
    public mymedicine(int medicineid, String medicinename) {
        this.medicineid = medicineid;
        this.medicinename = medicinename;
    }

    public int getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(int medicineid) {
        this.medicineid = medicineid;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }
    
    
}
