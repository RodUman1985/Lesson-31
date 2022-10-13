package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList {
    private HashMap<Date, LinkedList<Deal>> deals;
    private SimpleDateFormat df;
    private static final String fileName="deals.bin";


    public ToDoList(){
        this.deals=new HashMap<>();
        this.df=new SimpleDateFormat("dd/MM/yyyy");
    }
    public void addDeal(Date date, Deal d) throws Exception {
        if(!this.deals.containsKey(date)){
            LinkedList<Deal> list=new LinkedList<>();
            list.add(d);
            this.deals.put(date,list);
            return;
        }
      LinkedList<Deal> list= this.deals.get(date);
        for (Deal deal:list){
            if(deal.name.equals(d.name)){
                throw new Exception("deal is already exist");
            }
        }
        list.add(d);

    }
    public void shouList(){
        for(Date date:this.deals.keySet()){
            this.shouList(date);
        }
    };
    public void shouList (Date date){
        LinkedList<Deal> list=this.deals.get(date);
        if(list==null){
            return;
        }
        System.out.println(this.df.format(date));
        for(int i=0;i<list.size();i++){
            System.out.printf("%d. %s\n",i+1,list.get(i));
        }
    };
    public void shouListForWeak(){
        Calendar c=Calendar.getInstance();
        int weekNow =c.get(Calendar.WEEK_OF_YEAR);
        int yearNow= c.get(Calendar.YEAR);
        for (Date date:this.deals.keySet()){
            c.setTime(date);
            int week =c.get(Calendar.WEEK_OF_YEAR);
            int year= c.get(Calendar.YEAR);
            if(yearNow==year && weekNow==week){
                this.shouList(date);
            }
        }
    };
    public void marcDealAsComplited(Date date,int n){
        LinkedList<Deal> list=this.deals.get(date);
        if(list==null){
            return;
        }
        if(n<=0||n>list.size()){
            return;
        }
        Deal d =list.get(n-1);
        d.status=Status.complited;

    }
    public void safeToFile() throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
       ObjectOutputStream oos=new ObjectOutputStream(fos);
       oos.writeObject(this.deals);
       oos.flush();
       fos.close();
       oos.close();


    }
    public void loadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream(fileName);
        ObjectInputStream ois=new ObjectInputStream(fis);
       this.deals=(HashMap<Date, LinkedList<Deal>>) ois.readObject();
       fis.close();
        ois.close();
    }
}
