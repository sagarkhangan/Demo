import entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class JPA_Demo {
public static void main(String args[]){
Employee p = new Employee();
p.setName("XYZ");
p.setId("ABC!@#ABC123");
p.setPh(62813909);

JPA_Demo demo = new JPA_Demo();
demo.persist(p);
}

public void persist(Object object) {
EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JPA_DemoPU");
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
try {
em.persist(object);
em.getTransaction().commit();
} catch (Exception e) {
em.getTransaction().rollback();
} finally {
em.close();
}
}
}