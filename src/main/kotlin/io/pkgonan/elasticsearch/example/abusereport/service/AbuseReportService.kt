package io.pkgonan.elasticsearch.example.abusereport.service

import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReport
import io.pkgonan.elasticsearch.example.abusereport.domain.AbuseReportRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class AbuseReportService(
    private val repository: AbuseReportRepository
) {
    fun integratedSearch(text: String, page: Pageable): Page<AbuseReport> {
        return repository.findAllByText(text, page)
    }

    fun fieldSearch(field: String, text: String, page: Pageable): Page<AbuseReport> {
        return repository.findByField(field, text, page)
    }
}