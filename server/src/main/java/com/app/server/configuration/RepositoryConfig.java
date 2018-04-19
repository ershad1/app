package com.app.server.configuration;

import com.app.auth.entity.User;
import com.app.server.entity.address.Address;
import com.app.server.entity.applanguage.AppLanguage;
import com.app.server.entity.branch.Branch;
import com.app.server.entity.country.Country;
import com.app.server.entity.organization.Organization;
import com.app.server.entity.organizationtype.OrganizationType;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Address.class);
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Branch.class);
        config.exposeIdsFor(Organization.class);
        config.exposeIdsFor(OrganizationType.class);
        config.exposeIdsFor(AppLanguage.class);
    }
}