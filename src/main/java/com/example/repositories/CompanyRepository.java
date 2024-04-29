package com.example.repositories;

import com.example.HibernateUtil;
import com.example.entities.Company;
import com.example.entities.Employee;
import org.hibernate.Session;

import java.util.List;

public class CompanyRepository {
    private Session sesion;

    /**
     * Create Hibernate Session
     */
    public CompanyRepository() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        sesion.close();
    }


    /**
     * Inserta un objeto company en la BBDD
     * @param cp (no lleve id, sino hace update)
     */
    public void insert(Company cp) {
        sesion.beginTransaction();
        sesion.persist(cp);
        sesion.getTransaction().commit();
    }

    /**
     * Modifica un objeto company en la BBDD
     * @param cp (LLeve id, modifica el objeto con ese id)
     */
    public void update(Company cp) {
        sesion.beginTransaction();
        sesion.merge(cp);
        sesion.getTransaction().commit();
    }

    /**
     * Buscar por la primary key
     * @param id primary key
     * @return
     */
    public Company findById(Long id) {
        var company = sesion.find(Company.class, id);
        return company;
    }

    /**
     * Elimina un objeto company en la BBDD
     * @param cp (LLeve id, elimina ese empleado por id)
     */
    public void delete(Company cp) {
        sesion.beginTransaction();
        sesion.remove(cp);
        sesion.getTransaction().commit();
    }

    /**
     * Busca todos los objetos Company
     * @return List con todos los Employee en la base de datos
     */
    public List<Company> findAll() {
        /*
        String consulta = "Select e From Company e";
        var query = sesion.createQuery(consulta);
        return query.list();
        */

        return sesion.createQuery("Select e From Company e").list();
    }

}
