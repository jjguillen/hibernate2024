package com.example.repositories;

import com.example.HibernateUtil;
import com.example.entities.Employee;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;


public class EmployeeRepository {

    private Session sesion;

    /**
     * Create Hibernate Session
     */
    public EmployeeRepository() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Close Hibernate Session
     */
    public void closeSession() {
        sesion.close();
    }


    /**
     * Inserta un objeto empleado en la BBDD
     * @param emp (no lleve id, sino hace update)
     */
    public void insert(Employee emp) {
        sesion.beginTransaction();
        sesion.persist(emp);
        sesion.getTransaction().commit();
    }

    /**
     * Modifica un objeto empleado en la BBDD
     * @param emp (LLeve id, modifica el objeto con ese id)
     */
    public void update(Employee emp) {
        sesion.beginTransaction();
        sesion.merge(emp);
        sesion.getTransaction().commit();
    }

    /**
     * Buscar por la primary key
     * @param id primary key
     * @return
     */
    public Employee findById(Long id) {
        var employee = sesion.find(Employee.class, id);
        return employee;
    }

    /**
     * Elimina un objeto empleado en la BBDD
     * @param emp (LLeve id, elimina ese empleado por id)
     */
    public void delete(Employee emp) {
        sesion.beginTransaction();
        sesion.remove(emp);
        sesion.getTransaction().commit();
    }

    /**
     * Busca todos los objetos Employee
     * @return List con todos los Employee en la base de datos
     */
    public List<Employee> findAll() {

        return sesion.createQuery("Select e From Employee e", Employee.class).getResultList();
    }

}
