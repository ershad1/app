package com.app.server.entity.branch;

import com.app.server.entity.address.Address;
import com.app.server.entity.address.AddressRepository;
import com.app.server.entity.country.Country;
import com.app.server.entity.country.CountryRepository;
import com.app.server.entity.organization.Organization;
import com.app.server.entity.organization.OrganizationRepository;
import com.app.server.error.DataNotFoundException;
import com.app.server.error.InvalidSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {


    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Branch create(Branch request) {


        Organization organization = organizationRepository.getOne(request.getOrganization().getId());
        request.setOrganization(organization);

        Address address = request.getAddress();
        Country country = organization.getAddress().getCountry();
        address.setCountry(country);

        Address addressSaved = addressRepository.save(address);

        request.setAddress(addressSaved);

        Branch regionSaved = branchRepository.save(request);
        if (regionSaved == null) {
            throw new InvalidSearchException("Failed to create book!");
        }
        return regionSaved;
    }


    public Branch update(Long id, Branch request) {
        Branch region = branchRepository.getOne(id);
        if (region == null) {
            throw new DataNotFoundException(
                    "Book with id " + id + " not found!");
        }

        region.setFullName(request.getFullName());
        region.getAddress().setAddressOne(request.getAddress().getAddressOne());
        region.getAddress().setDivision(request.getAddress().getDivision());
        region.getAddress().setDistrict(request.getAddress().getDistrict());
        region.getAddress().setSubDistrict(request.getAddress().getSubDistrict());


        Branch organizationSaved = branchRepository.save(region);
        if (organizationSaved == null) {
            throw new InvalidSearchException("Failed to create book!");
        }
        return organizationSaved;
    }
}
