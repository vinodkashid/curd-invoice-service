package com.data.app.controller;

import com.data.app.model.Invoice;
import com.data.app.repository.InvoiceRepository;
import com.data.app.util.SalesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@Slf4j
public class InvoiceController {

    @Autowired
    SalesClient salesClient;

    @Autowired
    InvoiceRepository invoiceRepository;

    @GetMapping("invoice/{id}/")
    public ResponseEntity<?> getInvoiceforSales(@PathVariable("id") String id) {
        log.info("Calling Sales Client {}", id);
        return salesClient.getSales(Integer.parseInt(id));
    }

    @PostMapping("invoice/create")
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {
        return new ResponseEntity<>(invoiceRepository.save(invoice), HttpStatus.CREATED);
    }

}
