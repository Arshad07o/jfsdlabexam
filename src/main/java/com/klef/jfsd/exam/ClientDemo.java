package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Device.class);
        config.addAnnotatedClass(Smartphone.class);
        config.addAnnotatedClass(Tablet.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert Device
        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("Model X");
        device.setPrice(500.0);
        session.save(device);

        // Insert Smartphone
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Samsung");
        smartphone.setModel("Galaxy S21");
        smartphone.setPrice(1200.0);
        smartphone.setOperatingSystem("Android");
        smartphone.setCameraResolution("108 MP");
        session.save(smartphone);

        // Insert Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Apple");
        tablet.setModel("iPad Pro");
        tablet.setPrice(1400.0);
        tablet.setScreenSize(12.9);
        tablet.setBatteryLife(10);
        session.save(tablet);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully.");
    }
}
