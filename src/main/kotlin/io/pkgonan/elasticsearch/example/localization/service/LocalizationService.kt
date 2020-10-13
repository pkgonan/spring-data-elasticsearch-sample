package io.pkgonan.elasticsearch.example.localization.service

import io.pkgonan.elasticsearch.example.localization.domain.Localization
import io.pkgonan.elasticsearch.example.localization.domain.LocalizationRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LocalizationService(
    private val repository: LocalizationRepository
) {
    fun integratedSearch(text: String, page: Pageable): Page<Localization> {
        return repository.findAllByText(text, page)
    }

    fun fieldSearch(field: String, text: String, page: Pageable): Page<Localization> {
        return repository.findByField(field, text, page)
    }
}