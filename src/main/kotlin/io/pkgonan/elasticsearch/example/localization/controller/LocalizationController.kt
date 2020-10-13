package io.pkgonan.elasticsearch.example.localization.controller

import io.pkgonan.elasticsearch.example.localization.domain.Localization
import io.pkgonan.elasticsearch.example.localization.service.LocalizationService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LocalizationController(
    private val service: LocalizationService
) {
    @GetMapping("/localizations/integrated-search")
    fun integratedSearch(
        @RequestParam text: String,
        @PageableDefault(size = 10, page = 0, sort = ["id"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<Localization> {
        return service.integratedSearch(text, page)
    }

    @GetMapping("/localizations/field-search")
    fun fieldSearch(
        @RequestParam text: String,
        @RequestParam field: String,
        @PageableDefault(size = 10, page = 0, sort = ["id"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<Localization> {
        return service.fieldSearch(field, text, page)
    }
}