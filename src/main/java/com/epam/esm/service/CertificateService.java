package com.epam.esm.service;

import com.epam.esm.entity.Certificate;

import java.util.List;

public interface CertificateService {
    Certificate getCertificate(Long giftId);
    Certificate addCertificate(Certificate giftCertificate);
    void deleteCertificate(Certificate giftCertificate);
    Certificate updateCertificate(Certificate giftCertificate);
    List<Certificate> listCertificates();
}
