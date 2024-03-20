package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.Packages;
import com.tourism.Travel_Buddy.repository.PackageRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;


    //---------------------------------Add Package-------------------------------------------------

    public Packages addPackage(Packages pack) throws IOException {
        return packageRepo.save(pack);
    }

    //---------------------------------Get Package-------------------------------------------------

    public Optional<Packages> getPackage(int id) {
        return packageRepo.findById(id);
    }


    //---------------------------------Get all Packages-------------------------------------------------

    public List<Packages> getAllPackages() {
        System.out.println("packages send");
        return packageRepo.findAll();
    }

    //---------------------------------Get all Packages-------------------------------------------------

    public Packages updatePackage(Packages pack, int id) {
        Optional<Packages> existingPackageOptional = packageRepo.findById(id);
        if (existingPackageOptional.isPresent()) {
            Packages existingPackage = existingPackageOptional.get();

            existingPackage.setLocation(pack.getLocation());
            existingPackage.setDescription(pack.getDescription());
            existingPackage.setPrice(pack.getPrice());
            existingPackage.setImg(pack.getImg());

            return packageRepo.save(existingPackage);
        } else {
            return null;
        }
    }

    //---------------------------------Delete Packages-------------------------------------------------

    public void deletePackage(int id) {
        packageRepo.deleteById(id);
    }

}
