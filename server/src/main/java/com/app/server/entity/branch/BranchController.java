package com.app.server.entity.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    private static final String BRANCH_SAVE_URL = "/save";

    private static final String BRANCH_SAVE_BY_ID_URL = BRANCH_SAVE_URL + "/{id}";

    @Autowired
    private BranchService branchService;


    @PostMapping(BRANCH_SAVE_URL)
    public Branch save(@RequestBody Branch request) {
        return branchService.create(request);
    }

    @PutMapping(BRANCH_SAVE_BY_ID_URL)
    public Branch update(@PathVariable Long id, @RequestBody Branch request) {
        return branchService.update(id, request);
    }
}
