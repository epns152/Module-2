package com.epam.esm.service;

import com.epam.esm.entity.Certificate;
import com.epam.esm.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;
    @Override
    public Certificate getCertificate(Long giftId) {
        return certificateRepository.getCertificate(giftId);
    }

    @Override
    public Certificate addCertificate(Certificate giftCertificate) {
        return certificateRepository.addCertificate(giftCertificate);
    }

    @Override
    public void deleteCertificate(Certificate giftCertificate) {
        certificateRepository.deleteCertificate(giftCertificate);
    }

    @Override
    public Certificate updateCertificate(Certificate giftCertificate) {
        return certificateRepository.updateCertificate(giftCertificate);
    }

    @Override
    public List<Certificate> listCertificates() {
        return certificateRepository.listCertificates();
    }
}
