import Entities.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class main {
    //private static SessionFactory factory;

    public static void main(String[] args) {

        System.out.println("Hello Iteration 2!");
        UI.MainUI.main( args);
    }
}