package pl.strefakursow.hibernatedemoapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemoapp.entity.Employee;

public class DeleteEntityApp {
    public  static void  main(String args[]){
        // stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobranie sesji
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        /*
        Usuwanie pracownika z id = 7
         */
        Employee employee = session.get(Employee.class,7);
        session.delete(employee);

        session.getTransaction().commit();


        // zamknięcie obiektu SessionFactory
        factory.close();
    }

}
