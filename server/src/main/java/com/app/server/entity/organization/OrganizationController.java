package com.app.server.entity.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    private static final String ORGANIZATION_SAVE_URL = "/save";

    private static final String ORGANIZATION_SAVE_BY_ID_URL = ORGANIZATION_SAVE_URL + "/{id}";

    @Autowired
    private OrganizationService organizationService;


    @PostMapping(ORGANIZATION_SAVE_URL)
    public Organization save(@RequestBody Organization request) {
        return organizationService.create(request);
    }

    @PutMapping(ORGANIZATION_SAVE_BY_ID_URL)
    public Organization update(@PathVariable Long id, @RequestBody Organization request) {
        return organizationService.update(id, request);
    }
}
