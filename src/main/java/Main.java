import entity.Department;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Employee player = new Employee();
            Department dept = new Department();
            player.setId(10);
            player.setFirstName("Rauno");
            player.setLastName("Sappinen");
            dept.setDepartment_id(1);
            entityManager.persist(player);


            transaction.commit();
        } finally {
            if (transaction.isActive()){
            transaction.rollback();

            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
