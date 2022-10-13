package com.company;

import java.io.Serializable;

public class Deal implements Serializable {
public String name;
public Status status;


    public Deal(String name){
    this.name=name;
    this.status=Status.not_complited;

}

    @Override
    public String toString() {
        char c=' ';
        if(this.status==Status.complited){
            c='x';
        }
        return String.format(" [%c] %s",c, this.name);
    }
}
