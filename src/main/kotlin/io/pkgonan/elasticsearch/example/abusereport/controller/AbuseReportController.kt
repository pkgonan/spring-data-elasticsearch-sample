package io.pkgonan.elasticsearch.example.abusereport.controller

import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReport
import io.pkgonan.elasticsearch.example.abusereport.service.AbuseReportService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AbuseReportController(
    private val service: AbuseReportService
) {
    @GetMapping("/abuse-reports/integrated-search")
    fun integratedSearch(
        @RequestParam text: String,
        @PageableDefault(size = 10, page = 0, sort = ["id"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<AbuseReport> {
        return service.integratedSearch(text, page)
    }

    @GetMapping("/abuse-reports/field-search")
    fun fieldSearch(
        @RequestParam text: String,
        @RequestParam field: String,
        @PageableDefault(size = 10, page = 0, sort = ["id"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<AbuseReport> {
        return service.fieldSearch(field, text, page)
    }
}