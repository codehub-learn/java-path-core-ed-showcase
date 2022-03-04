
package gr.codelearn.core.generics;

import java.util.ArrayList;
import java.util.List;

public class Generic<T,U> {
    private T t;
    private U u;
    private List<T> list;
    
    public Generic(){
        list = new ArrayList<>();
        System.out.println("Default constructor");
    }

    public Generic(T t, U u) {
        this();
        this.t = t;
        this.u = u;
    }


    public T getVariable() {
        return t;
    }

    public void setVariable(T variable) {
        this.t = variable;
    }

    public void addToList(T t) {
        list.add(t);
    }
    
    public Integer getListSize(){
        return list.size();
    }
    
}