package hibernatewypozyczalnia.dao;

import hibernatewypozyczalnia.model.Samochod;
import hibernatewypozyczalnia.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SamochodDao implements  ISamochodDao{
    @Override
    public void dodajSamochod(Samochod samochod) {
        SessionFactory fabrykaPolaczen  = HibernateUtil.INSTANCE.getSessionFactory();
    }

    @Override
    public void usunSamochod(Samochod samochod) {
        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = fabrykaPolaczen.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove((samochod));
            transaction.commit();
        }

    }

    @Override
    public Optional<Samochod> zwrocSamochod(Long id) {
        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = fabrykaPolaczen.openSession()) {
            Samochod obiektSamochod = session.get(Samochod.class, id);
        return Optional.ofNullable(obiektSamochod);
    }

    @Override
    public List<Samochod> zwrocListeSamochodow() {
        List<Samochod> samochodLista = new ArrayList<>();

        SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();
        try (Session session = fabrykaPolaczen.openSession()) {
                // Tworzymy "zapytanie" do bazy o obiekty typu Samochod
            TypedQuery<Samochod> zapytanie = session.createQuery("from Samochod", Samochod.class);
                List<Samochod> wynikZapytania = zapytanie.getResultList();

                samochodLista.addAll(wynikZapytania);
            } catch (SessionException sessionException) {
                System.err.println("Błąd wczytywania danych.");
            }

            return samochodLista;

    }

    @Override
    public void updateSamochod(Samochod samochod) {
            SessionFactory fabrykaPolaczen = HibernateUtil.INSTANCE.getSessionFactory();

            Transaction transaction = null;
            try (Session session = fabrykaPolaczen.openSession()) {
                transaction = session.beginTransaction();

                session.persist(samochod);

                transaction.commit();
            } catch (SessionException sessionException) {
                if (transaction != null){
                    transaction.rollback();
                }
            }
        }

    }
}
