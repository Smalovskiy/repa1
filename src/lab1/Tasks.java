/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import static org.hibernate.tool.hbm2x.StringUtils.split;

/**
 *
 * @author 18751
 */
public class Tasks {
    private Session session;
    
    public Tasks(Session session){
        this.session = session;
    }
    
    public List<Studentyi> task1(){
        String sql = "from Studentyi s";
        Query query = session.createQuery(sql);
        
        List<Studentyi> rows = query.list();
        return rows;
    }
    
    public HashMap task2(){
        String sql = "from Gruppyi g";
        Query query = session.createQuery(sql);
        
        List<Gruppyi> rowsg = query.list();
        HashMap m = new HashMap();
        for(Gruppyi row : rowsg){
            sql = "from Studentyi s where s.gruppyi.shifr = :param";
            query = session.createQuery(sql);
            query.setParameter("param", row.getShifr());
            List<Studentyi> rows = query.list();
            String[] words = split(row.getNazvanie(), "-");
            if(m.containsKey(words[0])){
                int amount = (int)m.get(words[0]);
                m.remove(words[0]);
                m.put(words[0], rows.size() + amount);
            } else if(words.length != 0) m.put(words[0], rows.size());
        }
        return m;
    }
}
