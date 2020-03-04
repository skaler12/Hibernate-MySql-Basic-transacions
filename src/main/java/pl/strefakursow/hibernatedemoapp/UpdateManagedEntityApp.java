package pl.strefakursow.hibernatedemoapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.hibernatedemoapp.entity.Employee;

public class UpdateManagedEntityApp {
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
        Update imienia pracownika z Id=8 i zapis do bazy przez transakcje
         */
         Employee employee = session.get(Employee.class,8);
         employee.setFirstName("Tadeusz");
         session.getTransaction().commit();

         System.out.println("Zaktualizowane dane Pracownika:" + employee);


         // zamknięcie obiektu SessionFactory
         factory.close();
     }
}
