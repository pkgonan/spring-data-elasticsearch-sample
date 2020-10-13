package io.pkgonan.elasticsearch.example.localization.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface LocalizationRepository : ElasticsearchRepository<Localization, Long> {
    @Query("{\"bool\" : {\"must\" : [ {\"multi_match\" : {\"query\" : \"?0\", \"type\" : \"cross_fields\", \"analyzer\" : \"whitespace\"}} ]}}\"")
    fun findAllByText(text: String, pageable: Pageable): Page<Localization>

    @Query("{\"bool\" : {\"must\" : [ {\"multi_match\" : {\"query\" : \"?1\", \"type\" : \"cross_fields\", \"analyzer\" : \"whitespace\", \"fields\" : [ \"?0\" ]}} ]}}\"")
    fun findByField(field: String, text: String, pageable: Pageable): Page<Localization>
}