package pl.strefakursow.hibernatedemoapp;

import pl.strefakursow.hibernatedemoapp.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SaveEntityApp {

    public static void main(String[] args) {

        /*
        HQL DODANIE POZYCJI - INSERT
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
        // stworzenie obiektu
        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(10000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanie pracownika
        session.save(employee);
        // zakończenie transakcji
        session.getTransaction().commit();
        // zamknięcie obiektu SessionFactory
        factory.close();

    }


}