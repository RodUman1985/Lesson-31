package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        ToDoList toDoList=new ToDoList();
        toDoList.loadFromFile();
        /*toDoList.addDeal(date("13/10/2022"),new Deal("eat"));
        toDoList.addDeal(date("12/10/2022"),new Deal("go to stady"));
        toDoList.addDeal(date("11/10/2022"),new Deal("sleep"));
        toDoList.addDeal(date("13/10/2022"),new Deal("go home"));
        toDoList.addDeal(date("10/12/4022"),new Deal("написать на золтом троне: ИМПЕРАТОР- ХЮЮЮ "));
        toDoList.addDeal(date("13/10/4022"),new Deal("many eat"));
        toDoList.addDeal(date("15/10/4022"),new Deal("very many eat"));*/
        toDoList.shouList();
        System.out.println("______________________________________________");
        toDoList.marcDealAsComplited(date("13/10/2022"),2);
        toDoList.shouList(date("15/10/4022"));
        System.out.println("______________________________________________");
        toDoList.shouListForWeak();
        toDoList.safeToFile();

    }
    public static Date date(String d) throws ParseException {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
           return df.parse(d);
    }
}
