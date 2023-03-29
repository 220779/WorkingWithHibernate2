import entity.Department;
import entity.Employee;
import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            /*Employee player = new Employee();
            Department dept = new Department();
            player.setId(11);
            player.setFirstName("Pipi");
            player.setLastName("Pipi");
            dept.setDepartment_id(2);
            entityManager.persist(player);*/

            TypedQuery<Employee> empByDeptQuery = entityManager.createNamedQuery("Employee.byDept", Employee.class);
            empByDeptQuery.setParameter(1,"Arsenal");
            for (Employee employee : empByDeptQuery.getResultList()) {
                System.out.println(employee);
                
            }

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
