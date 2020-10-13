package io.pkgonan.elasticsearch.example.localization.domain

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName="#{@localization_index_name}",type = "_doc")
class Localization internal constructor() {
    private val id: Long = 0L
    private val key: String? = null
    private val description: String? = null
    private val arValue: String? = null
    private val enValue: String? = null
    private val koValue: String? = null
    private val zhValue: String? = null
    private val zhCnValue: String? = null
    private val jaValue: String? = null
    private val ruValue: String? = null
    private val esValue: String? = null
    private val frValue: String? = null
    private val deValue: String? = null
    private val hiValue: String? = null
    private val ptValue: String? = null
    private val thValue: String? = null
    private val idValue: String? = null
    private val viValue: String? = null
    private val itValue: String? = null
    private val trValue: String? = null
    private val ptPtValue: String? = null
    private val esEsValue: String? = null
    private val svValue: String? = null

    fun getId() = id
    fun getKey() = key
    fun getDescription() = description
    fun getArValue() = arValue
    fun getEnValue() = enValue
    fun getKoValue() = koValue
    fun getZhValue() = zhValue
    fun getZhCnValue() = zhCnValue
    fun getJaValue() = jaValue
    fun getRuValue() = ruValue
    fun getEsValue() = esValue
    fun getFrValue() = frValue
    fun getDeValue() = deValue
    fun getHiValue() = hiValue
    fun getPtValue() = ptValue
    fun getThValue() = thValue
    fun getIdValue() = idValue
    fun getViValue() = viValue
    fun getItValue() = itValue
    fun getTrValue() = trValue
    fun getPtPtValue() = ptPtValue
    fun getEsEsValue() = esEsValue
    fun getSvValue() = svValue
}