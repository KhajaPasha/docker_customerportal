package devops;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import devops.*;
 
public class LoginService {
 
    public boolean authenticateUser(String email1, String password) {
        AuthUsers user = getUserByEmail(email1);         
        if(user!=null && user.getEmail().equals(email1) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
 
    public AuthUsers getUserByEmail(String email1) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        AuthUsers user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from AuthUsers where email='"+email1+"'");
            user = (AuthUsers)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
     
    public List<AuthUsers> getListOfUsers(){
        List<AuthUsers> list = new ArrayList<AuthUsers>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from AuthUsers").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}