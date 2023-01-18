package com.epam.esm.controller;

import com.epam.esm.entity.Certificate;
import com.epam.esm.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertificateController {

    @Autowired
    CertificateService сertificateService;

    @RequestMapping(value = "/certificates", method = RequestMethod.GET)
    public ResponseEntity<List<Certificate>> listCertificates() {
        List<Certificate> giftCertificates = сertificateService.listCertificates();
        if (giftCertificates != null) {
            return new ResponseEntity<List<Certificate>>(giftCertificates, HttpStatus.OK);
        }
        return new ResponseEntity<List<Certificate>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/certificates/{giftId}", method = RequestMethod.GET)
    public ResponseEntity<Certificate> getCertificate(@PathVariable("giftId") Long giftId) {
        Certificate giftCertificate = сertificateService.getCertificate(giftId);
        if (giftCertificate != null) {
            return new ResponseEntity<Certificate>(giftCertificate, HttpStatus.OK);
        }
        return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/certificates", method = RequestMethod.POST)
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate giftCertificate) {
        giftCertificate = сertificateService.addCertificate(giftCertificate);
        return new ResponseEntity<Certificate>(giftCertificate, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/certificates/{giftId}", method = RequestMethod.PUT)
    public ResponseEntity<Certificate> updateCertificate(@PathVariable("giftId") Long giftId, @RequestBody Certificate giftCertificate) {
        giftCertificate.setId(giftId);
        Certificate updatedGiftCertificate = сertificateService.updateCertificate(giftCertificate);
        return new ResponseEntity<Certificate>(updatedGiftCertificate, HttpStatus.OK);
    }

    @RequestMapping(value = "/certificates/{giftId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCertificate(@PathVariable("giftId") Long giftId) {
        Certificate giftCertificate = сertificateService.getCertificate(giftId);
        if (giftCertificate != null) {
            сertificateService.deleteCertificate(giftCertificate);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
