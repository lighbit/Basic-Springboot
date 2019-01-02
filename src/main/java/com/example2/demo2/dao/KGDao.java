package com.example2.demo2.dao;

import com.example2.demo2.model.Golongan;
import com.example2.demo2.model.Karyawan;
import com.example2.demo2.service.KGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class KGDao implements KGService {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public List<Karyawan> listKaryawan() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Karyawan", Karyawan.class).getResultList();
    }

    @Override
    public Karyawan saveOrUpdate(Karyawan karyawan) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Karyawan saved = entityManager.merge(karyawan);
        entityManager.getTransaction().commit();
        return saved;
    }

    @Override
    public List<Golongan> listGolongan() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Golongan", Golongan.class).getResultList();
    }

    @Override
    public Golongan saveOrUpdate2(Golongan golongan) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Golongan saved = entityManager.merge(golongan);
        entityManager.getTransaction().commit();
        return saved;
    }

    @Override
    public Karyawan getIDKaryawan(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Karyawan.class, id);
    }

    @Override
    public Golongan getIDGolongan(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Golongan.class, id);
    }

    @Override
    public void hapusKaryawan(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Karyawan.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public void hapusGolongan(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Golongan.class, id));
        entityManager.getTransaction().commit();
    }
}
