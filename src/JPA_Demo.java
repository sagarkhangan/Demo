import entity.Employee;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
public class JPA_Demo {
public static void main(String args[])
{
    String displayAllQuery="Select emp from Employee emp" ;
    Scanner sc;   
    sc = new Scanner(System.in);
    String name,id;
    int ph,ch = 0;
    
    do 
    {
    System.out.println("menu 1.insert 2. view 3. exit ");
    ch=sc.nextInt();
    switch (ch)
    {
        case 1: 
        {
                    System.out.println("enter name "); 
                    name=sc.nextLine();
                    sc.nextLine();
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
                   break;
        }
        case 2: 
                {
                    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JPA_DemoPU");
                    EntityManager em = emf.createEntityManager();
                    
                    em.getTransaction().begin();

                    TypedQuery  e=em.createQuery(displayAllQuery, Employee.class);

                    List <Employee> employees=e.getResultList();
                        
                    if(employees.size()>0)

                      {
                          System.out.println(employees.size()+" Employee Records Available...!");
                          for(Employee temp:employees)
                             {
                               System.out.println("Id :"+temp.getId());
                               System.out.println("Name :"+temp.getName());
                               System.out.println("Phone Number :"+temp.getPh());
                               
                               System.out.println();
                             }
                          
                      }
                   else
                          System.out.println("Database is Empty!");
                          em.getTransaction().commit();
                    break;
                }
        case 3: System.exit(0);
     }
   }while(ch!=3);
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