import entity.Employee;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class JPA_Demo {
public static void main(String args[]){
    
    Scanner sc;   
    sc = new Scanner(System.in);
    String name,id;
    int ph;
    System.out.println("enter name ");
    name=sc.nextLine();
    System.out.println("enter id ");
    id=sc.nextLine();
    System.out.println("enter phone ");
    ph=sc.nextInt();
    
Employee p = new Employee();
p.setName(name);
p.setId(id);
p.setPh(ph);

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