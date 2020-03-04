package pl.strefakursow.hibernatedemoapp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemoapp.entity.Employee;

public class PrimaryKeyApp {
    public static void main(String args[]){

        /*
        Dodawanie kolejnych obiektow - pracownikow do tabeli w celu ukazania automatycznej generavji id w bazie - INSERT
         */
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
        // stworzenie  2 obiektów
        Employee employee2 = new Employee();
        employee2.setFirstName("Maciej");
        employee2.setLastName("Pukaluk");
        employee2.setSalary(20000);

        Employee employee3 = new Employee();
        employee3.setFirstName("Weronika");
        employee3.setLastName("Teter");
        employee3.setSalary(12000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanie 2 pracowników
        session.save(employee2);
        session.save(employee3);
        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();


    }
}
