/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import entity.Studentyi;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import utils.NewHibernateUtil;

/**
 *
 * @author 18751
 */
public class Lab1 {

    /**
     * @param args the command line arguments ndnder
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tasks tasks = new Tasks(session);
        List<Studentyi> students = tasks.task1();
        for(Studentyi student : students){
            System.out.println(student.toString());
        }
        //new
        System.out.println();
        HashMap map = tasks.task2();
        System.out.println(map);
        session.getTransaction().commit();
    }
    
}
