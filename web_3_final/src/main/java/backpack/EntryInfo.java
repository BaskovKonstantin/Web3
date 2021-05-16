package backpack;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EntryInfo implements Serializable {
    private Information information;
    private List<Information> informationList;
    

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    private void connection () {
        entityManagerFactory = Persistence.createEntityManagerFactory("@localhost");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    private void loadInformationList() {
        try {
            transaction.begin();
            Query query = entityManager.createQuery("SELECT e FROM Information e");
            informationList = query.getResultList();
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }
    }
    public EntryInfo() {
        information = new Information();
        informationList = new ArrayList<>();
        connection();
        loadInformationList();
    }

    public void add() {
        try {
            transaction.begin();
            information.setResult(CkeckArea.Check(information.getCoordinateX(), information.getCoordinateY(), information.getValueR()));
            entityManager.persist(information);
            informationList.add(information);
            information = new Information();
            transaction.commit();
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }

    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Information getInformation() {
        return information;
    }

    public List<Information> getInformationList() {
        return informationList;
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }
}