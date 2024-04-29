package com.example;

import com.example.entities.Address;
import com.example.entities.Company;
import com.example.entities.Employee;
import com.example.repositories.AddressRepository;
import com.example.repositories.CompanyRepository;
import com.example.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class App {

    @Transactional
    public static void main(String[] args) throws IOException {

        //Create repository
        EmployeeRepository er = new EmployeeRepository();

        Employee emp1 = new Employee("María","Díaz",25000.0, "mariad@gmail.com");
        er.insert(emp1);

        //er.update(new Employee(9L, "María", "Jiménez", 25000.0,
        //        "mariaj@gmail.com"));
        //System.out.println(er.findById(9L));

        //er.delete(er.findById(10L));

        er.findAll().forEach(System.out::println);



        // -----------------------------------------------------

        /*
        CompanyRepository cr = new CompanyRepository();
        Company cp1 = new Company("Dune S.A.", "Vera");
        cr.insert(cp1);

        //Leer imagen de url y escribirla en fichero
        URL url = new URL("https://imagenes.20minutos.es/files/image_640_360/uploads/imagenes/2024/03/04/dune-parte-dos.jpeg");
        String nombreFichero = "./src/main/resources/imagenes/company-" + cp1.getId() + ".jpg";
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(nombreFichero), StandardCopyOption.REPLACE_EXISTING);

        //Meter la url de la imagen en el objeto Company
        cp1.setImagen(nombreFichero);
        cr.update(cp1);

        cr.closeSession();
        */

        AddressRepository ar = new AddressRepository();
        Address a1 = new Address("Mi calle", "Cuevas", "04633");
        //ar.insert(a1);

        Employee en = er.findById(3L);
        en.setAddress(ar.findById(1L));
        er.update(en);

        Employee en3 = er.findById(3L);
        System.out.println(en3);

        ar.closeSession();
        er.closeSession();

    }
}
