package com.example.repositories;

import com.example.HibernateUtil;
import com.example.entities.Address;
import com.example.entities.Company;
import org.hibernate.Session;

import java.util.List;

public class AddressRepository {

    private Session sesion;

    /**
     * Create Hibernate Session
     */
    public AddressRepository() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        sesion.close();
    }


    /**
     * Inserta un objeto address en la BBDD
     * @param ad (no lleve id, sino hace update)
     */
    public void insert(Address ad) {
        sesion.beginTransaction();
        sesion.persist(ad);
        sesion.getTransaction().commit();
    }

    /**
     * Modifica un objeto address en la BBDD
     * @param ad (LLeve id, modifica el objeto con ese id)
     */
    public void update(Address ad) {
        sesion.beginTransaction();
        sesion.merge(ad);
        sesion.getTransaction().commit();
    }

    /**
     * Buscar por la primary key
     * @param id primary key
     * @return
     */
    public Address findById(Long id) {
        var address = sesion.find(Address.class, id);
        return address;
    }

    /**
     * Elimina un objeto address en la BBDD
     * @param ad (LLeve id, elimina ese empleado por id)
     */
    public void delete(Address ad) {
        sesion.beginTransaction();
        sesion.remove(ad);
        sesion.getTransaction().commit();
    }

    /**
     * Busca todos los objetos Address
     * @return List con todos los Employee en la base de datos
     */
    public List<Address> findAll() {
        return sesion.createQuery("Select a From Address a", Address.class).getResultList();
    }
}
