package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {

    public static void main(String[] args) {
        /*
        SessionFactory - это объект конфигуратор. Он создается один раз на все приложение.
        В нем происходит создания пулов, загрузка кешей, проверка моделей.
        Создание этого объекта трудозатратное.
        Создание объекта SessionFactory.
        Этот объект создается через фабрику. Метод configure читает файл hibernate.cfg.xml
        и выполняет инициализация пула и кешей.
        */
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            var item = new Item();
            item.setName("Learn Hibernate");
            create(item, sf);
            System.out.println(item);

            item.setName("Learn Hibernate 5.");
            update(item, sf);
            System.out.println(item);

            Item rsl = findById(item.getId(), sf);
            System.out.println(rsl);
            delete(rsl.getId(), sf);
            List<Item> list = findAll(sf);
            for (Item it : list) {
                System.out.println(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Методы create, update, delete работает с объектом Session.
     * Объект Session позволяет записать, удалить и прочитать данные из базы.
     * Этот объект создается быстро.
     * Session session = sf.openSession();
     * Любое действие с базой происходит в транзакции.
     */
    public static Item create(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Методы поиска - find.
     * Обратите внимание Hibernate собирает объект сам.
     * Мы не прописываем, какие поля нужно достать.
     * Кода по сравнению с чистым JDBC стало меньше.
     */
    public static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from Item", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static Item findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
