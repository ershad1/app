package com.app.server.entity.branch;


public interface BranchProjection {
    Long getId();

    String getFullName();

    Organization getOrganization();

    Address getAddress();

    interface Organization {
        Long getId();

        String getFullName();
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
