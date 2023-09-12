package com.s2w.preassignment.attackmanager.presentation.api;

import com.s2w.preassignment.attackmanager.application.CveService;
import com.s2w.preassignment.attackmanager.application.SeedService;
import com.s2w.preassignment.attackmanager.application.SoftwareService;
import com.s2w.preassignment.attackmanager.application.SubdomainService;
import com.s2w.preassignment.attackmanager.presentation.dto.req.CveRequest;
import com.s2w.preassignment.attackmanager.presentation.dto.req.SeedSaveRequest;
import com.s2w.preassignment.attackmanager.presentation.dto.res.SoftwareCveSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AttackManagerApiController {
    public static final String SEED_URI_PREFIX = "/api/seed/";

    private final SeedService seedService;
    private final SubdomainService subdomainService;
    private final SoftwareService softwareService;
    private final CveService cveService;

    @PostMapping("/seed")
    public ResponseEntity saveSeed(@RequestBody SeedSaveRequest request) {
        String seedId = seedService.save(request);
        return ResponseEntity.created(URI.create(SEED_URI_PREFIX + seedId)).build();
    }

    @GetMapping("/{seedId}/subdomains")
    public ApiResponse findSubdomains(@PathVariable String seedId,
                                      @RequestParam int size,
                                      @RequestParam int page) {
        return ApiResponse.of(subdomainService.findSubDomains(seedId, Pageable.ofSize(size).withPage(page)));
    }

    @GetMapping("/{seedId}/softwares")
    public ApiResponse findSoftwares(@PathVariable String seedId,
                                     @RequestParam int size,
                                     @RequestParam int page) {
        return ApiResponse.of(softwareService.findSoftwares(seedId, Pageable.ofSize(size).withPage(page)));
    }

    @PostMapping("/cve")
    public ApiResponse saveSoftwareCves(@RequestBody CveRequest request) {
        return ApiResponse.of(softwareService.saveSoftwareCves(request),
                SoftwareCveSaveResponse.UN_EXIST_SOFTWARE_MESSAGE);
    }

    @GetMapping("/{seedId}/cves")
    public ApiResponse findSoftwareCves(@PathVariable String seedId,
                                        @RequestParam int size,
                                        @RequestParam int page) {
        return ApiResponse.of(cveService.findCves(seedId, Pageable.ofSize(size).withPage(page)));
    }
}
