/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author vasil
 */
public class user {

    private int i;
    private String Name;
    private String Desc;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    @Override
    public String toString() {
        return "user{" + "i=" + i + ", Name=" + Name + ", Desc=" + Desc + '}';
    }

    public user(int i, String Name, String Desc) {
        this.i = i;
        this.Name = Name;
        this.Desc = Desc;
    }

    public user() {
    }

}
