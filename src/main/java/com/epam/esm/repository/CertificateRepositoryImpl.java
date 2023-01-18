package com.epam.esm.repository;

import com.epam.esm.entity.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CertificateRepositoryImpl implements CertificateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Certificate getCertificate(Long giftId) {
        Session session = this.sessionFactory.getCurrentSession();
        Certificate giftCertificate = (Certificate) session.get(Certificate.class, giftId);
        return giftCertificate;
    }

    @Override
    public Certificate addCertificate(Certificate giftCertificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(giftCertificate);
        return giftCertificate;
    }

    @Override
    public void deleteCertificate(Certificate giftCertificate) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(giftCertificate);
    }

    @Override
    public Certificate updateCertificate(Certificate giftCertificate) {
        Session session = this.sessionFactory.getCurrentSession();
        Certificate giftCertificate1 = (Certificate) session.merge(giftCertificate);
        return giftCertificate1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Certificate> listCertificates() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Certificate> giftCertificates = session.createQuery("from gift_certificate").list();
        return giftCertificates;
    }
}
