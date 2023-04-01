package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Collections;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    /**
     * Добавить новую заявку.
     * @param item заявка.
     * @return заявка с ID.
     */
    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
           session.close();
        }
        return item;
    }

    /**
     * Обновить заявку в БД.
     * @param id ID.
     * @param item заявка.
     * @return true/false.
     */
    @Override
    public boolean replace(int id, Item item) {
        var result = false;
        var session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery(
                    "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Удалить заявку по ID.
     * @param id ID.
     * @return true/false;
     */
    @Override
    public boolean delete(int id) {
        var result = false;
        var session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery(
                    "DELETE Item WHERE id = :fId")
                    .setParameter(":fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Список всех заявок.
     * @return список заявок.
     */
    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        List<Item> result = Collections.emptyList();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Список заявок найденных по имени.
     * @param key ключ поиска.
     * @return список заявок.
     */
    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        List<Item> result = Collections.emptyList();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item WHERE name = :fName", Item.class)
                    .setParameter("fName", key)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Найти заявку по ID.
     * @param id ID.
     * @return заявка.
     */
    @Override
    public Item findById(int id) {
        var session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item WHERE id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}