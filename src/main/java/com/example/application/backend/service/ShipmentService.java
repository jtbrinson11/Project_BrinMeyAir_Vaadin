package com.example.application.backend.service;

import com.example.application.backend.entity.Shipment;
import com.example.application.backend.repository.CustomerRepository;
import com.example.application.backend.repository.ServiceRepository;
import com.example.application.backend.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class ShipmentService {
    private static final Logger LOGGER = Logger.getLogger(ShipmentService.class.getName());

    private ShipmentRepository shipmentRepository;
    private ServiceRepository serviceRepository;
    private CustomerRepository customerRepository;

    public ShipmentService(ShipmentRepository shipmentRepository,
                           ServiceRepository serviceRepository,
                           CustomerRepository customerRepository) {
        this.shipmentRepository = shipmentRepository;
        this.serviceRepository = serviceRepository;
        this.customerRepository = customerRepository;
    }

    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    public long count() {
        return shipmentRepository.count();
    }

    public void delete(Shipment shipment) {
        shipmentRepository.delete(shipment);
    }

    public void save(Shipment shipment) {
        if (shipment == null) {
            LOGGER.log(Level.SEVERE,
                    "Shipment is null. Is the form connected to the application?");
            return;
        }
        shipmentRepository.save(shipment);
    }
}
