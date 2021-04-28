/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg1laba;

import entity.Gruppyi;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 18760
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SessionFactory sf =  HibernateUtil1.getSessionFactory();
        Session s = sf.openSession();
        Query query = s.createQuery("from Gruppyi u where u.nazvanie = (:It)");
     query.setParameter("It", 2);
     List<Gruppyi> ups = (List<Gruppyi>)query.list();
for (Gruppyi u : ups)
     {
         System.out.println(u);
     }

        s.close(); 
    }
    
}
