package pl.strefakursow.hibernatedemoapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemoapp.entity.Employee;

/*
W tej klasie pokazuje jak wczytuje dane zapsianego obiektu do konsoli
 */
public class GetEntityApp {
    public static void main(String args[]) {
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
        // stworzenie obiektu
        Employee employee = new Employee();
        employee.setFirstName("Tadeusz");
        employee.setLastName("Jachymek");
        employee.setSalary(5000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanie pracownika
        Integer id = (Integer) session.save(employee);
        // zakończenie transakcji
        session.getTransaction().commit();

        session = factory.getCurrentSession();

        session.beginTransaction();

        Employee retrievedEmployee = session.get(Employee.class,id);

        session.getTransaction().commit();

        System.out.println("Dane Pracownika:" + retrievedEmployee);

        // zamknięcie obiektu SessionFactory
        factory.close();
    }
}
