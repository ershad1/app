package com.app.server.entity.organization;

import com.app.server.entity.address.Address;
import com.app.server.entity.address.AddressRepository;
import com.app.server.entity.applanguage.AppLanguage;
import com.app.server.entity.applanguage.AppLanguageRepository;
import com.app.server.entity.country.Country;
import com.app.server.entity.country.CountryRepository;
import com.app.server.entity.organizationtype.OrganizationType;
import com.app.server.entity.organizationtype.OrganizationTypeRepository;
import com.app.server.error.DataNotFoundException;
import com.app.server.error.InvalidSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {


    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private OrganizationTypeRepository organizationProfileRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AppLanguageRepository appLanguageRepository;

    public Organization create(Organization request) {


        OrganizationType organizationProfile = organizationProfileRepository.getOne(request.getOrganizationProfile().getId());
        request.setOrganizationProfile(organizationProfile);

        AppLanguage appLanguage = appLanguageRepository.getOne(request.getAppLanguage().getId());
        request.setAppLanguage(appLanguage);

        Address address = request.getAddress();
        Country country = countryRepository.getOne(request.getAddress().getCountry().getId());
        address.setCountry(country);

        Address addressSaved = addressRepository.save(address);

        request.setAddress(addressSaved);

        Organization organizationSaved = organizationRepository.save(request);
        if (organizationSaved == null) {
            throw new InvalidSearchException("Failed to create book!");
        }
        return organizationSaved;
    }


    public Organization update(Long id, Organization request) {
        Organization organization = organizationRepository.getOne(id);
        if (organization == null) {
            throw new DataNotFoundException(
                    "Book with id " + id + " not found!");
        }
        OrganizationType organizationProfile = organizationProfileRepository.getOne(request.getOrganizationProfile().getId());
        Country country = countryRepository.getOne(request.getAddress().getCountry().getId());
        AppLanguage appLanguage = appLanguageRepository.getOne(request.getAppLanguage().getId());

        organization.setFullName(request.getFullName());
        organization.setOrganizationProfile(organizationProfile);
        organization.getAddress().setAddressOne(request.getAddress().getAddressOne());
        organization.getAddress().setDivision(request.getAddress().getDivision());
        organization.getAddress().setDistrict(request.getAddress().getDistrict());
        organization.getAddress().setSubDistrict(request.getAddress().getSubDistrict());
        organization.getAddress().setCountry(country);
        organization.setAppLanguage(appLanguage);


        Organization organizationSaved = organizationRepository.save(organization);
        if (organizationSaved == null) {
            throw new InvalidSearchException("Failed to create book!");
        }
        return organizationSaved;
    }
}
