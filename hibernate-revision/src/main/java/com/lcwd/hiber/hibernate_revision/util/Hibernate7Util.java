package com.lcwd.hiber.hibernate_revision.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.lcwd.hiber.hibernate_revision.entities.Student;
import com.lcwd.hiber.hibernate_revision.entities.Certificate;

public class Hibernate7Util {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Step 1: Load registry from hibernate.cfg.xml
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

            // Step 2: Add annotated classes
            MetadataSources sources = new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Certificate.class);

            // Step 3: Build metadata and session factory
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
