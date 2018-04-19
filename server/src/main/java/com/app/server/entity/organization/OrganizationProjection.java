package com.app.server.entity.organization;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Organization.class)
public interface OrganizationProjection {

    Long getId();

    String getFullName();

    AppLanguage getAppLanguage();

    OrganizationProfile getOrganizationProfile();

    Address getAddress();

    interface OrganizationProfile {
        Long getId();

        String getFullName();
    }

    interface AppLanguage {
        Long getId();

        String getFullName();

        String getCode();
    }

    interface Address {
        Long getId();

        String getAddressOne();

        String getDivision();

        String getDistrict();

        String getSubDistrict();

        Country getCountry();

        interface Country {
            Long getId();

            String getFullName();
        }
    }


}
