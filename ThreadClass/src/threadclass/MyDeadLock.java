/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadclass;

/**
 *
 * @author saravanan
 */
public class MyDeadLock {
 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
               synchronized(str1){
                   synchronized(str2){
                        System.out.println("Thread 1" + str1 + str2);
                    }
               }
           }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                   synchronized(str1){
                        System.out.println("Thread 2" +str2 + str1);
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
        MyDeadLock mdl = new MyDeadLock();
        mdl.trd1.start();
        
       
        mdl.trd2.start();
    }
}