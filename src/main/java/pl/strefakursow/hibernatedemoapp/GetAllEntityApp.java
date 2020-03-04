package pl.strefakursow.hibernatedemoapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemoapp.entity.Employee;

import java.util.List;

public class GetAllEntityApp {
    public static void main(String args[]){

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
        //rozpoczecie transakcji
        session.beginTransaction();
        //zwrocenie wszystkich encji
        /*
        Przypisanie encji do listy
         */
        List<Employee> resultList = session.createQuery("from Employee ").getResultList();
          /*
          wyświetlenie encji w konsoli petla foreach
           */
        for(Employee employee : resultList){
            System.out.println(employee);
        }
        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();


    }
}
