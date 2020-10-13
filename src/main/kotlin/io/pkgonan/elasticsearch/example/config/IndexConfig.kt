package io.pkgonan.elasticsearch.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class IndexConfig {

    @Profile("stage", "prod")
    @Bean(name = ["localization_index_name"])
    fun localizationIndexNameProd() = "cdc-data.azar.azar.stringlocalizationv2"

    @Profile("qa", "dev", "local", "default")
    @Bean(name = ["localization_index_name"])
    fun localizationIndexNameDev() = "cdc-data.azar.azar_test.stringlocalizationv2"

    @Profile("stage", "prod")
    @Bean(name = ["abuse_report_index_name"])
    fun abuseReportIndexNameProd() = "cdc-data.azar.azar.abusereport"

    @Profile("qa", "dev", "local", "default")
    @Bean(name = ["abuse_report_index_name"])
    fun abuseReportIndexNameDev() = "cdc-data.azar.azar_test.abusereport"
}