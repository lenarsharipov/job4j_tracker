package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HQLUsage {

    /**
     * Для того чтобы ограничить выборку или сделать выборку по критерию,
     * достаточно в запрос включить конструкцию с ключевым словом where.
     */
    public static void unique(Session session) {
        Query<Item> query = session.createQuery(
                "from Item as i where i.id = 3", Item.class);
        System.out.println(query.uniqueResult());
    }

    /**
     * В отличие от SQL параметры подменяются не через конструкцию ?,
     * а через подмену параметров по их имени - главное, чтобы имя
     * указанное в запросе (fId) и имя указанное при установлении
     * параметра - совпадали. При этом в параметрах запроса это имя
     * указывается после двоеточия - это особенность синтаксиса.
     * HQL поддерживает блоки SQL WHERE, HAVING, GROUP BY, ORDER BY, LIMIT, OFFSET.
     */
    public static void findById(Session session, int id) {
        Query<Item> query = session.createQuery(
             "from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        System.out.println(query.uniqueResult());
    }

    /**
     * Чтобы выполнить операции изменения данных, нужно начать
     * транзакцию для этого используется блок try-catch.
     * Если упало исключение, то все изменения откатываются.
     * Синтаксис запроса на обновление записи идентичен с SQL.
     */
    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                    "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Запрос типа "INSERT ... VALUES ..." в HQL не поддерживается.
     * Для обычной вставки нужно использовать метод save().
     * В метод save() нужно передать объект Item.
     */
    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            /* working with session */
            /* Query query = session.createQuery("from Item"); */
            Query<Item> query = session.createQuery("from Item", Item.class);
            for (Object st : query.list()) {
                System.out.println(st);
            }
            unique(session);

            findById(session, 2);

            update(session, 1);

            delete(session, 1);

            insert(session, new Item("inserted new Item"));

            for (Object st : query.list()) {
                System.out.println(st);
            }

            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
