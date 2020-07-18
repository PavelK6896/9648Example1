package data1.controllers;

import data1.entities.Category1;
import data1.entities.Category1_;
import data1.entities.Product1;
import data1.entities.Product1_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
public class ProductsController {
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public ProductsController(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @GetMapping("/w") // all product
    @ResponseBody
    public List<Product1> w() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin(); // открыть транзакцию

        CriteriaBuilder cb = em.getCriteriaBuilder(); // который будет строить объекты запросов

        //  который параметризуется типом, который этот запрос возвращает.
        CriteriaQuery<Product1> criteriaQuery = cb.createQuery(Product1.class);

        // от которого производится обход дерева свойств при накладывании ограничений или указании что выбирать.
        Root<Product1> root = criteriaQuery.from(Product1.class);

        criteriaQuery.select(root);
        // что же мы хотим выбрать
        //эквивалентен JPQL запросу « from Person».

        List<Product1> products1 = em.createQuery(criteriaQuery).getResultList();

//        em.getTransaction().commit();
//        em.close();
        products1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return products1;
    }

    @GetMapping("/h") // all product
    @ResponseBody
    public List<Product1> h() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin(); // открыть транзакцию
        List<Product1> products = em
                .createQuery(
                        "SELECT s FROM Product1 s ",
                        Product1.class)
                .getResultList();
        products.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return products;
    }

    @GetMapping("/w2") // all categories in product
    @ResponseBody
    public List<Category1> w2() {

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin(); // открыть транзакцию
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); // который будет строить объекты запросов

        CriteriaQuery<Category1> criteriaQuery = criteriaBuilder.createQuery(Category1.class);
        Root<Product1> personPassportRoot = criteriaQuery.from(Product1.class);
        //criteriaQuery.select(personPassportRoot.get("categories"));
        criteriaQuery.select(personPassportRoot.get(Product1_.CATEGORIES));
        List<Category1> category1 = em.createQuery(criteriaQuery).getResultList();
        category1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return category1;
    }

    @GetMapping("/h2") // all categories in product
    @ResponseBody
    public List<Category1> h2() { // all categories in product
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin(); // открыть транзакцию

        List<Category1> products = em
                .createQuery(
                        "SELECT ca FROM Product1 as s, IN (s.categories) as ca ",
                        Category1.class)
                .getResultList();

        products.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return products;
    }

    @GetMapping("/w3") // all categories
    @ResponseBody
    public List<Category1> w3() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Category1> criteriaQuery = criteriaBuilder.createQuery(Category1.class);
        Root<Category1> root = criteriaQuery.from(Category1.class);
        criteriaQuery.select(root);
        List<Category1> category1 = em.createQuery(criteriaQuery).getResultList();
        category1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return category1;
    }

    @GetMapping("/h3") // all categories
    @ResponseBody
    public List<Category1> h3() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Category1> category1 = em
                .createQuery(
                        "SELECT s FROM Category1 as s",
                        Category1.class)
                .getResultList();

        category1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return category1;
    }

    @GetMapping("/w4") // all product where title category
    @ResponseBody
    public List<Product1> w4() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product1> criteriaQuery = criteriaBuilder.createQuery(Product1.class);
        Root<Product1> root = criteriaQuery.from(Product1.class);
        Join<Product1, Category1> join = root.join(Product1_.CATEGORIES);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(join.get(Category1_.title), "Food"));
        List<Product1> products1 = em.createQuery(criteriaQuery).getResultList();
        products1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return products1;
    }

    @GetMapping("/h4") // all product where title category
    @ResponseBody
    public List<Product1> h4() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Product1> products1 = em
                .createQuery(
                        "SELECT pr FROM Product1 as pr, IN (pr.categories) as ca  WHERE ca.title = :title",
                        Product1.class)
                .setParameter("title", "Food")
                .getResultList();

        products1.stream().map(product -> "-- " + product + " //").forEach(System.out::println);
        return products1;
    }
}