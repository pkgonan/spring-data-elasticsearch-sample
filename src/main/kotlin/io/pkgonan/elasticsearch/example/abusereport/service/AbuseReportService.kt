package io.pkgonan.elasticsearch.example.abusereport.service

import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReport
import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReportRepository
import org.elasticsearch.ElasticsearchStatusException
import org.elasticsearch.rest.RestStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.UncategorizedElasticsearchException
import org.springframework.stereotype.Service

@Service
class AbuseReportService(
    private val repository: AbuseReportRepository
) {
    fun integratedSearch(text: String, page: Pageable): Page<AbuseReport> {
        return trySearch { repository.findAllByText(text, page) }
    }

    fun fieldSearch(field: String, text: String, page: Pageable): Page<AbuseReport> {
        return trySearch { repository.findByField(field, text, page) }
    }

    private fun trySearch(function: () -> Page<AbuseReport>): Page<AbuseReport> {
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