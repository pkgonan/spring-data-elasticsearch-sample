package io.pkgonan.elasticsearch.example.localization.service

import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReport
import io.pkgonan.elasticsearch.example.localization.domain.Localization
import io.pkgonan.elasticsearch.example.localization.domain.LocalizationRepository
import org.elasticsearch.ElasticsearchStatusException
import org.elasticsearch.rest.RestStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.UncategorizedElasticsearchException
import org.springframework.stereotype.Service

@Service
class LocalizationService(
    private val repository: LocalizationRepository
) {
    fun integratedSearch(text: String, page: Pageable): Page<Localization> {
        return trySearch { repository.findAllByText(text, page) }
    }

    fun fieldSearch(field: String, text: String, page: Pageable): Page<Localization> {
        return trySearch { repository.findByField(field, text, page) }
    }

    private fun trySearch(function: () -> Page<Localization>): Page<Localization> {
        try {
            return function.invoke()
        } catch (e: UncategorizedElasticsearchException) {
            val cause = e.cause

            if (cause !is ElasticsearchStatusException) throw e

            if (RestStatus.BAD_REQUEST == cause.status()) {
                // TODO : Throw Business Exception
            }
        }
        return Page.empty()
    }
}