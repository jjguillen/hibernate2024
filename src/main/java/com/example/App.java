package com.example;

import com.example.entities.Company;
import com.example.entities.Employee;
import com.example.repositories.CompanyRepository;
import com.example.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

public class App {

    @Transactional
    public static void main(String[] args) throws IOException {

        //Create repository
        EmployeeRepository er = new EmployeeRepository();

        Employee emp1 = new Employee("María","Díaz",25000.0, "mariad@gmail.com");
        er.insert(emp1);

        er.update(new Employee(9L, "María", "Jiménez", 25000.0,
                "mariaj@gmail.com"));
        System.out.println(er.findById(9L));

        //er.delete(er.findById(10L));

        er.findAll().forEach(System.out::println);

        //Close repository
        er.closeSession();

        // -----------------------------------------------------

        CompanyRepository cr = new CompanyRepository();
        Company cp1 = new Company("Cosentino S.A.", "Cantoria");
        cr.insert(cp1);

        /*
        //Leer imagen de url
        URL url = new URL("https://pm1.aminoapps.com/6313/026f7fff60fafb9b7eebd6f0b4f1a5b6a73d3175_hq.jpg");
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        */

    }
}
