package io.pkgonan.elasticsearch.example.abusereport.domain

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName="#{@abuse_report_index_name}",type = "_doc")
class AbuseReport internal constructor() {
    private val id: Long = 0L
    private val dateCreated: Long = 0L
    private val s3BucketName: String = ""
    private val s3ObjectName: String = ""
    private val s3PublicUrl: String = ""
    private val status: Int = 0
    private val reportedUserId: Long = 0L
    private val userId: Long = 0L
    private val credibility: Double = 0.0
    private val autoSuspended: Boolean = false
    private val abuseType: String? = null
    private val reportMethod: String? = null
    private val incidentDate: Long? = null
    private val rewarded: Boolean = false
    private val userSuspensionId: Long? = null
    private val blockedDeviceId: Long? = null
    private val reporteePlatform: String? = null
    private val safeMatchResult: String? = null
    private val matchId: String? = null

    fun getId() = id
    fun getDateCreated() = dateCreated
    fun getS3BucketName() = s3BucketName
    fun getS3ObjectName() = s3ObjectName
    fun getS3PublicUrl() = s3PublicUrl
    fun getStatus() = status
    fun getReportedUserId() = reportedUserId
    fun getUserId() = userId
    fun getCredibility() = credibility
    fun getAutoSuspended() = autoSuspended
    fun getAbuseType() = abuseType
    fun getReportMethod() = reportMethod
    fun getIncidentDate() = incidentDate
    fun getRewarded() = rewarded
    fun getUserSuspensionId() = userSuspensionId
    fun getBlockedDeviceId() = blockedDeviceId
    fun getReporteePlatform() = reporteePlatform
    fun getSafeMatchResult() = safeMatchResult
    fun getMatchId() = matchId
}