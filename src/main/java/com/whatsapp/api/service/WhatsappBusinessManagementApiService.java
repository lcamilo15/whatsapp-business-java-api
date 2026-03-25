package com.whatsapp.api.service;

import com.whatsapp.api.domain.analytics.AnalyticsResponse;
import com.whatsapp.api.domain.analytics.ConversationAnalyticsResponse;
import com.whatsapp.api.domain.billing.ExtendedCredits;
import com.whatsapp.api.domain.compliance.ComplianceInfoResponse;
import com.whatsapp.api.domain.compliance.CreateComplianceInfo;
import com.whatsapp.api.domain.config.CommerceDataItem;
import com.whatsapp.api.domain.config.GraphCommerceSettings;
import com.whatsapp.api.domain.flow.*;
import com.whatsapp.api.domain.phone.PhoneNumber;
import com.whatsapp.api.domain.phone.PhoneNumbers;
import com.whatsapp.api.domain.phone.RegisterPhone;
import com.whatsapp.api.domain.phone.RequestCode;
import com.whatsapp.api.domain.phone.VerifyCode;
import com.whatsapp.api.domain.profile.BusinessProfileResponse;
import com.whatsapp.api.domain.profile.UpdateBusinessProfile;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.subscription.OverrideCallbackUrl;
import com.whatsapp.api.domain.subscription.SubscribedApps;
import com.whatsapp.api.domain.templates.MessageTemplate;
import com.whatsapp.api.domain.templates.response.MessageTemplates;
import com.whatsapp.api.domain.templates.response.Template;
import com.whatsapp.api.domain.waba.BusinessPortfolio;
import com.whatsapp.api.domain.waba.WhatsappBusinessAccount;
import com.whatsapp.api.domain.waba.WhatsappBusinessAccounts;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Whatsapp business management api service.
 */
public interface WhatsappBusinessManagementApiService {

    // --- Message Templates ---

    /**
     * Create message template call.
     */
    @POST("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<Template> createMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Body MessageTemplate messageTemplate);

    /**
     * Update message template call.
     */
    @POST("/{api-version}/{whatsapp-business-account-ID}/message_templates/{message-template-id}")
    Call<Template> updateMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Path("message-template-id") String messageTemplateId, @Body MessageTemplate messageTemplate);

    /**
     * Delete message template by name.
     */
    @DELETE("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<Response> deleteMessageTemplate(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Query("name") String name);

    /**
     * Delete message template by name and HSM ID.
     */
    @DELETE("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<Response> deleteMessageTemplateById(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @Query("name") String name, @Query("hsm_id") String hsmId);

    /**
     * Retrieve templates call.
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Retrieve templates with filters.
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/message_templates")
    Call<MessageTemplates> retrieveTemplates(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId, @QueryMap Map<String, Object> filters);

    /**
     * Retrieve a single template by its ID.
     */
    @GET("/{api-version}/{template-ID}")
    Call<Template> retrieveTemplateById(@Path("api-version") String apiVersion, @Path("template-ID") String templateId);

    // --- Phone Numbers ---

    /**
     * Retrieve phone number call.
     */
    @GET("/{api-version}/{phone-number-ID}")
    Call<PhoneNumber> retrievePhoneNumber(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, Object> queryParams);

    /**
     * Retrieve phone numbers call.
     */
    @GET("/{api-version}/{whatsapp-business-account-ID}/phone_numbers")
    Call<PhoneNumbers> retrievePhoneNumbers(@Path("api-version") String apiVersion, @Path("whatsapp-business-account-ID") String whatsappBusinessAccountId);

    /**
     * Request verification code.
     */
    @POST("/{api-version}/{phone-number-ID}/request_code")
    Call<Response> requestCode(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body RequestCode requestCode);

    /**
     * Verify code.
     */
    @POST("/{api-version}/{phone-number-ID}/verify_code")
    Call<Response> verifyCode(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body VerifyCode verifyCode);

    // --- Phone Registration ---

    /**
     * Register a phone number.
     */
    @POST("/{api-version}/{phone-number-ID}/register")
    Call<Response> registerPhone(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body RegisterPhone registerPhone);

    /**
     * Deregister a phone number.
     */
    @POST("/{api-version}/{phone-number-ID}/deregister")
    Call<Response> deregisterPhone(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId);

    // --- Commerce Settings ---

    /**
     * Get commerce settings.
     */
    @GET("/{api-version}/{phone-number-ID}/whatsapp_commerce_settings")
    Call<GraphCommerceSettings> getWhatsappCommerceSettings(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, String> queryParams);

    /**
     * Update commerce settings.
     */
    @POST("/{api-version}/{phone-number-ID}/whatsapp_commerce_settings")
    Call<Response> updateWhatsappCommerceSettings(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body CommerceDataItem commerceDataItem);

    // --- Business Profile ---

    /**
     * Get business profile.
     */
    @GET("/{api-version}/{phone-number-ID}/whatsapp_business_profile")
    Call<BusinessProfileResponse> getBusinessProfile(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @QueryMap Map<String, String> queryParams);

    /**
     * Update business profile.
     */
    @POST("/{api-version}/{phone-number-ID}/whatsapp_business_profile")
    Call<Response> updateBusinessProfile(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body UpdateBusinessProfile profile);

    // --- Webhook Subscriptions ---

    /**
     * Subscribe app to WABA webhooks.
     */
    @POST("/{api-version}/{waba-ID}/subscribed_apps")
    Call<Response> subscribeApp(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId);

    /**
     * Override callback URL for WABA webhooks.
     */
    @POST("/{api-version}/{waba-ID}/subscribed_apps")
    Call<SubscribedApps> overrideCallbackUrl(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId, @Body OverrideCallbackUrl override);

    /**
     * Get all subscribed apps for a WABA.
     */
    @GET("/{api-version}/{waba-ID}/subscribed_apps")
    Call<SubscribedApps> getSubscribedApps(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId);

    /**
     * Unsubscribe app from WABA webhooks.
     */
    @DELETE("/{api-version}/{waba-ID}/subscribed_apps")
    Call<Response> unsubscribeApp(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId);

    // --- WABA Management ---

    /**
     * Get WhatsApp Business Account details.
     */
    @GET("/{api-version}/{waba-ID}")
    Call<WhatsappBusinessAccount> getWhatsappBusinessAccount(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId);

    /**
     * Get all WABAs owned by a business.
     */
    @GET("/{api-version}/{business-ID}/owned_whatsapp_business_accounts")
    Call<WhatsappBusinessAccounts> getOwnedWhatsappBusinessAccounts(@Path("api-version") String apiVersion, @Path("business-ID") String businessId);

    /**
     * Get all WABAs shared with a business.
     */
    @GET("/{api-version}/{business-ID}/client_whatsapp_business_accounts")
    Call<WhatsappBusinessAccounts> getSharedWhatsappBusinessAccounts(@Path("api-version") String apiVersion, @Path("business-ID") String businessId);

    /**
     * Get business portfolio details.
     */
    @GET("/{api-version}/{business-ID}")
    Call<BusinessPortfolio> getBusinessPortfolio(@Path("api-version") String apiVersion, @Path("business-ID") String businessId, @QueryMap Map<String, String> queryParams);

    // --- Flows ---

    /**
     * Create a new flow.
     */
    @POST("/{api-version}/{waba-ID}/flows")
    Call<Flow> createFlow(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId, @Body CreateFlow createFlow);

    /**
     * List all flows for a WABA.
     */
    @GET("/{api-version}/{waba-ID}/flows")
    Call<Flows> listFlows(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId);

    /**
     * Get a flow by ID with optional fields.
     */
    @GET("/{api-version}/{flow-ID}")
    Call<Flow> getFlow(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId, @QueryMap Map<String, String> queryParams);

    /**
     * Update flow metadata.
     */
    @POST("/{api-version}/{flow-ID}")
    Call<Response> updateFlowMetadata(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId, @Body UpdateFlowMetadata metadata);

    /**
     * Delete a draft flow.
     */
    @DELETE("/{api-version}/{flow-ID}")
    Call<Response> deleteFlow(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId);

    /**
     * Publish a flow (irreversible).
     */
    @POST("/{api-version}/{flow-ID}/publish")
    Call<Response> publishFlow(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId);

    /**
     * Deprecate a flow (irreversible).
     */
    @POST("/{api-version}/{flow-ID}/deprecate")
    Call<Response> deprecateFlow(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId);

    /**
     * Upload flow JSON asset.
     */
    @Multipart
    @POST("/{api-version}/{flow-ID}/assets")
    Call<FlowAssetUploadResponse> updateFlowJson(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId, @Part MultipartBody.Part file, @Part MultipartBody.Part name, @Part MultipartBody.Part assetType);

    /**
     * List flow assets.
     */
    @GET("/{api-version}/{flow-ID}/assets")
    Call<FlowAssets> listFlowAssets(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId);

    /**
     * Migrate flows between WABAs.
     */
    @POST("/{api-version}/{waba-ID}/migrate_flows")
    Call<MigrateFlowsResponse> migrateFlows(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId, @Body MigrateFlowsRequest request);

    /**
     * Get flow metrics.
     */
    @GET("/{api-version}/{flow-ID}")
    Call<FlowMetricResponse> getFlowMetrics(@Path("api-version") String apiVersion, @Path("flow-ID") String flowId, @QueryMap Map<String, String> queryParams);

    // --- Analytics ---

    /**
     * Get message analytics for a WABA.
     */
    @GET("/{api-version}/{waba-ID}")
    Call<AnalyticsResponse> getAnalytics(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId, @QueryMap Map<String, String> queryParams);

    /**
     * Get conversation analytics for a WABA.
     */
    @GET("/{api-version}/{waba-ID}")
    Call<ConversationAnalyticsResponse> getConversationAnalytics(@Path("api-version") String apiVersion, @Path("waba-ID") String wabaId, @QueryMap Map<String, String> queryParams);

    // --- Billing ---

    /**
     * Get extended credit lines for a business.
     */
    @GET("/{api-version}/{business-ID}/extendedcredits")
    Call<ExtendedCredits> getExtendedCredits(@Path("api-version") String apiVersion, @Path("business-ID") String businessId);

    // --- Business Compliance ---

    /**
     * Get business compliance info (India).
     */
    @GET("/{api-version}/{phone-number-ID}/business_compliance_info")
    Call<ComplianceInfoResponse> getBusinessComplianceInfo(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId);

    /**
     * Add business compliance info (India).
     */
    @POST("/{api-version}/{phone-number-ID}/business_compliance_info")
    Call<Response> addBusinessComplianceInfo(@Path("api-version") String apiVersion, @Path("phone-number-ID") String phoneNumberId, @Body CreateComplianceInfo complianceInfo);
}
