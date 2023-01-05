package com.car.service.service;

import com.car.service.model.Owner;
import com.car.service.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(int id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public List<Owner> getOwnerList() {
            return ownerRepository.findAll();
    }
}
