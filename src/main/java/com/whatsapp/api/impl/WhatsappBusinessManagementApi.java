package com.whatsapp.api.impl;

import com.whatsapp.api.configuration.ApiVersion;
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
import com.whatsapp.api.service.WhatsappBusinessManagementApiService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.whatsapp.api.WhatsappApiServiceGenerator.createService;
import static com.whatsapp.api.WhatsappApiServiceGenerator.executeSync;
import static com.whatsapp.api.configuration.WhatsappApiConfig.getApiVersion;

/**
 * The type Whatsapp business management api.
 */
public class WhatsappBusinessManagementApi {

    private final ApiVersion apiVersion;

    private final WhatsappBusinessManagementApiService whatsappBusinessManagementApiService;

    /**
     * Instantiates a new Whatsapp business management api.
     *
     * @param token the token
     */
    public WhatsappBusinessManagementApi(String token) {
        this.apiVersion = getApiVersion();
        this.whatsappBusinessManagementApiService = createService(WhatsappBusinessManagementApiService.class, token);
    }

    /**
     * Instantiates a new Whatsapp business management api, specifying api version
     *
     * @param token      the token
     * @param apiVersion api version
     */
    public WhatsappBusinessManagementApi(String token, ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
        this.whatsappBusinessManagementApiService = createService(WhatsappBusinessManagementApiService.class, token);
    }

    // --- Message Templates ---

    /**
     * Use the WhatsApp Business Management API to create new message templates,
     * media message templates, or interactive message templates.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA). Make the API call to the WABA ID.
     * @param messageTemplate           {@link MessageTemplate} object
     * @return {@link Template} template
     */
    public Template createMessageTemplate(String whatsappBusinessAccountId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.createMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, messageTemplate));
    }

    /**
     * Update message template message template id response.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param messageTemplateId         the message template id
     * @param messageTemplate           the message template
     * @return the message template id response
     */
    public Template updateMessageTemplate(String whatsappBusinessAccountId, String messageTemplateId, MessageTemplate messageTemplate) {

        return executeSync(whatsappBusinessManagementApiService.updateMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, messageTemplateId, messageTemplate));
    }

    /**
     * Delete message template by name.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the name
     * @return the response
     */
    public Response deleteMessageTemplate(String whatsappBusinessAccountId, String name) {

        return executeSync(whatsappBusinessManagementApiService.deleteMessageTemplate(apiVersion.getValue(), whatsappBusinessAccountId, name));
    }

    /**
     * Delete a specific message template by name and HSM ID.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @param name                      the template name
     * @param hsmId                     the HSM ID of the specific template to delete
     * @return the response
     */
    public Response deleteMessageTemplateById(String whatsappBusinessAccountId, String name, String hsmId) {

        return executeSync(whatsappBusinessManagementApiService.deleteMessageTemplateById(apiVersion.getValue(), whatsappBusinessAccountId, name, hsmId));
    }

    /**
     * Retrieve all templates for a WABA.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA).
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId));
    }

    /**
     * Retrieve templates with a limit.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA).
     * @param limit                     the maximum number of template names to return
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("limit", limit)));
    }

    /**
     * Retrieve templates by name.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA).
     * @param templateName              template name.
     * @return {@link MessageTemplates} List of templates
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/message-templates">Message templates</a>
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, String templateName) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("name", templateName)));
    }

    /**
     * Retrieve templates with pagination.
     *
     * @param whatsappBusinessAccountId Represents a specific WhatsApp Business Account (WABA).
     * @param limit                     the maximum number of template names to return
     * @param after                     pagination cursor
     * @return message templates
     */
    public MessageTemplates retrieveTemplates(String whatsappBusinessAccountId, int limit, String after) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplates(apiVersion.getValue(), whatsappBusinessAccountId, Map.of("limit", limit, "after", after)));
    }

    /**
     * Retrieve a single template by its ID.
     *
     * @param templateId the template ID
     * @return the template
     */
    public Template retrieveTemplateById(String templateId) {
        return executeSync(whatsappBusinessManagementApiService.retrieveTemplateById(apiVersion.getValue(), templateId));
    }

    // --- Phone Numbers ---

    /**
     * Retrieve a phone number by ID
     *
     * @param phoneNumberId the phone number id
     * @return the phone number
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumber retrievePhoneNumber(String phoneNumberId) {

        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumber(apiVersion.getValue(), phoneNumberId, new HashMap<>()));
    }

    /**
     * Retrieve phone number with specific fields.
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields
     * @return the phone number
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumber retrievePhoneNumber(String phoneNumberId, String... fields) {
        Objects.requireNonNull(fields, "fields cannot be null");
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumber(apiVersion.getValue(), phoneNumberId, Map.of("fields", String.join(",", fields))));
    }

    /**
     * Retrieve phone numbers from a Whatsapp Business Account.
     *
     * @param whatsappBusinessAccountId the whatsapp business account id
     * @return the phone numbers
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account/phone_numbers/">api docs</a>
     */
    public PhoneNumbers retrievePhoneNumbers(String whatsappBusinessAccountId) {
        return executeSync(whatsappBusinessManagementApiService.retrievePhoneNumbers(apiVersion.getValue(), whatsappBusinessAccountId));
    }

    /**
     * Request a verification code via SMS or voice call.
     *
     * @param phoneNumberId the phone number id
     * @param requestCode   the request code
     * @return the response
     */
    public Response requestCode(String phoneNumberId, RequestCode requestCode) {
        return executeSync(whatsappBusinessManagementApiService.requestCode(apiVersion.getValue(), phoneNumberId, requestCode));
    }

    /**
     * Verify a received SMS or voice verification code.
     *
     * @param phoneNumberId the phone number id
     * @param verifyCode    the verify code
     * @return the response
     */
    public Response verifyCode(String phoneNumberId, VerifyCode verifyCode) {
        return executeSync(whatsappBusinessManagementApiService.verifyCode(apiVersion.getValue(), phoneNumberId, verifyCode));
    }

    // --- Phone Registration ---

    /**
     * Register a phone number with two-step verification.
     *
     * @param phoneNumberId the phone number id
     * @param registerPhone the register phone request with PIN
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/get-started#register">official documentation</a>
     */
    public Response registerPhone(String phoneNumberId, RegisterPhone registerPhone) {
        return executeSync(whatsappBusinessManagementApiService.registerPhone(apiVersion.getValue(), phoneNumberId, registerPhone));
    }

    /**
     * Deregister a previously registered phone number.
     *
     * @param phoneNumberId the phone number id
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/registration">official documentation</a>
     */
    public Response deregisterPhone(String phoneNumberId) {
        return executeSync(whatsappBusinessManagementApiService.deregisterPhone(apiVersion.getValue(), phoneNumberId));
    }

    // --- Commerce Settings ---

    /**
     * Get a business phone number's WhatsApp Commerce Settings.
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account-to-number-current-status/whatsapp_commerce_settings">api docs</a>
     */
    public GraphCommerceSettings getWhatsappCommerceSettings(String phoneNumberId, String... fields) {
        return executeSync(whatsappBusinessManagementApiService.getWhatsappCommerceSettings(apiVersion.getValue(), phoneNumberId, Map.of("fields", String.join(",", fields))));
    }

    /**
     * Update a business WhatsApp Commerce Settings.
     *
     * @param phoneNumberId    the phone number id
     * @param commerceDataItem the commerce configuration fields
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/graph-api/reference/whats-app-business-account-to-number-current-status/whatsapp_commerce_settings">api docs</a>
     */
    public Response updateWhatsappCommerceSettings(String phoneNumberId, CommerceDataItem commerceDataItem) {
        return executeSync(whatsappBusinessManagementApiService.updateWhatsappCommerceSettings(apiVersion.getValue(), phoneNumberId, commerceDataItem));
    }

    // --- Business Profile ---

    /**
     * Get business profile information.
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields to return (e.g., "about", "address", "description", "email", "profile_picture_url", "websites", "vertical")
     * @return the business profile response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/business-profiles">official documentation</a>
     */
    public BusinessProfileResponse getBusinessProfile(String phoneNumberId, String... fields) {
        Map<String, String> queryParams = new HashMap<>();
        if (fields != null && fields.length > 0) {
            queryParams.put("fields", String.join(",", fields));
        }
        return executeSync(whatsappBusinessManagementApiService.getBusinessProfile(apiVersion.getValue(), phoneNumberId, queryParams));
    }

    /**
     * Update business profile information.
     *
     * @param phoneNumberId the phone number id
     * @param profile       the profile update request
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/business-profiles">official documentation</a>
     */
    public Response updateBusinessProfile(String phoneNumberId, UpdateBusinessProfile profile) {
        return executeSync(whatsappBusinessManagementApiService.updateBusinessProfile(apiVersion.getValue(), phoneNumberId, profile));
    }

    // --- Webhook Subscriptions ---

    /**
     * Subscribe your app to a WABA's webhooks.
     *
     * @param wabaId the WABA ID
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/set-up-webhooks">official documentation</a>
     */
    public Response subscribeApp(String wabaId) {
        return executeSync(whatsappBusinessManagementApiService.subscribeApp(apiVersion.getValue(), wabaId));
    }

    /**
     * Override the callback URL for a WABA's webhooks.
     *
     * @param wabaId   the WABA ID
     * @param override the override callback URL request
     * @return the subscribed apps response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/set-up-webhooks">official documentation</a>
     */
    public SubscribedApps overrideCallbackUrl(String wabaId, OverrideCallbackUrl override) {
        return executeSync(whatsappBusinessManagementApiService.overrideCallbackUrl(apiVersion.getValue(), wabaId, override));
    }

    /**
     * Get all apps subscribed to a WABA's webhooks.
     *
     * @param wabaId the WABA ID
     * @return the subscribed apps response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/set-up-webhooks">official documentation</a>
     */
    public SubscribedApps getSubscribedApps(String wabaId) {
        return executeSync(whatsappBusinessManagementApiService.getSubscribedApps(apiVersion.getValue(), wabaId));
    }

    /**
     * Unsubscribe your app from a WABA's webhooks.
     *
     * @param wabaId the WABA ID
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/set-up-webhooks">official documentation</a>
     */
    public Response unsubscribeApp(String wabaId) {
        return executeSync(whatsappBusinessManagementApiService.unsubscribeApp(apiVersion.getValue(), wabaId));
    }

    // --- WABA Management ---

    /**
     * Get WhatsApp Business Account details.
     *
     * @param wabaId the WABA ID
     * @return the WhatsApp Business Account
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/manage-phone-numbers">official documentation</a>
     */
    public WhatsappBusinessAccount getWhatsappBusinessAccount(String wabaId) {
        return executeSync(whatsappBusinessManagementApiService.getWhatsappBusinessAccount(apiVersion.getValue(), wabaId));
    }

    /**
     * Get all WABAs owned by a business portfolio.
     *
     * @param businessId the business portfolio ID
     * @return the list of WABAs
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/get-started">official documentation</a>
     */
    public WhatsappBusinessAccounts getOwnedWhatsappBusinessAccounts(String businessId) {
        return executeSync(whatsappBusinessManagementApiService.getOwnedWhatsappBusinessAccounts(apiVersion.getValue(), businessId));
    }

    /**
     * Get all WABAs shared with a business portfolio.
     *
     * @param businessId the business portfolio ID
     * @return the list of WABAs
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/get-started">official documentation</a>
     */
    public WhatsappBusinessAccounts getSharedWhatsappBusinessAccounts(String businessId) {
        return executeSync(whatsappBusinessManagementApiService.getSharedWhatsappBusinessAccounts(apiVersion.getValue(), businessId));
    }

    /**
     * Get business portfolio details.
     *
     * @param businessId the business portfolio ID
     * @param fields     the fields to retrieve (e.g., "id", "name", "timezone_id")
     * @return the business portfolio
     */
    public BusinessPortfolio getBusinessPortfolio(String businessId, String... fields) {
        Map<String, String> queryParams = new HashMap<>();
        if (fields != null && fields.length > 0) {
            queryParams.put("fields", String.join(",", fields));
        }
        return executeSync(whatsappBusinessManagementApiService.getBusinessPortfolio(apiVersion.getValue(), businessId, queryParams));
    }

    // --- Flows ---

    /**
     * Create a new flow.
     *
     * @param wabaId     the WABA ID
     * @param createFlow the create flow request
     * @return the created flow
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Flow createFlow(String wabaId, CreateFlow createFlow) {
        return executeSync(whatsappBusinessManagementApiService.createFlow(apiVersion.getValue(), wabaId, createFlow));
    }

    /**
     * List all flows for a WABA.
     *
     * @param wabaId the WABA ID
     * @return the flows
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Flows listFlows(String wabaId) {
        return executeSync(whatsappBusinessManagementApiService.listFlows(apiVersion.getValue(), wabaId));
    }

    /**
     * Get a flow by ID.
     *
     * @param flowId the flow ID
     * @param fields optional fields to retrieve
     * @return the flow
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Flow getFlow(String flowId, String... fields) {
        Map<String, String> queryParams = new HashMap<>();
        if (fields != null && fields.length > 0) {
            queryParams.put("fields", String.join(",", fields));
        }
        return executeSync(whatsappBusinessManagementApiService.getFlow(apiVersion.getValue(), flowId, queryParams));
    }

    /**
     * Update flow metadata (name, categories, endpoint_uri).
     *
     * @param flowId   the flow ID
     * @param metadata the metadata to update
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Response updateFlowMetadata(String flowId, UpdateFlowMetadata metadata) {
        return executeSync(whatsappBusinessManagementApiService.updateFlowMetadata(apiVersion.getValue(), flowId, metadata));
    }

    /**
     * Delete a draft flow (irreversible).
     *
     * @param flowId the flow ID
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Response deleteFlow(String flowId) {
        return executeSync(whatsappBusinessManagementApiService.deleteFlow(apiVersion.getValue(), flowId));
    }

    /**
     * Publish a flow (irreversible, flow becomes immutable).
     *
     * @param flowId the flow ID
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Response publishFlow(String flowId) {
        return executeSync(whatsappBusinessManagementApiService.publishFlow(apiVersion.getValue(), flowId));
    }

    /**
     * Deprecate a flow (irreversible, prevents sending or opening).
     *
     * @param flowId the flow ID
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public Response deprecateFlow(String flowId) {
        return executeSync(whatsappBusinessManagementApiService.deprecateFlow(apiVersion.getValue(), flowId));
    }

    /**
     * Upload or update a flow's JSON content.
     *
     * @param flowId   the flow ID
     * @param fileName the file name (e.g., "flow.json")
     * @param flowJson the flow JSON content as bytes
     * @return the upload response with validation errors
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public FlowAssetUploadResponse updateFlowJson(String flowId, String fileName, byte[] flowJson) {
        var requestFile = okhttp3.MultipartBody.create(flowJson, MediaType.parse("application/json"));
        var filePart = MultipartBody.Part.createFormData("file", fileName, requestFile);
        var namePart = MultipartBody.Part.createFormData("name", fileName);
        var assetTypePart = MultipartBody.Part.createFormData("asset_type", "FLOW_JSON");
        return executeSync(whatsappBusinessManagementApiService.updateFlowJson(apiVersion.getValue(), flowId, filePart, namePart, assetTypePart));
    }

    /**
     * List all assets for a flow.
     *
     * @param flowId the flow ID
     * @return the flow assets
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public FlowAssets listFlowAssets(String flowId) {
        return executeSync(whatsappBusinessManagementApiService.listFlowAssets(apiVersion.getValue(), flowId));
    }

    /**
     * Migrate flows from one WABA to another.
     *
     * @param wabaId  the destination WABA ID
     * @param request the migrate flows request
     * @return the migrate flows response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public MigrateFlowsResponse migrateFlows(String wabaId, MigrateFlowsRequest request) {
        return executeSync(whatsappBusinessManagementApiService.migrateFlows(apiVersion.getValue(), wabaId, request));
    }

    /**
     * Get flow endpoint metrics.
     *
     * @param flowId      the flow ID
     * @param metricName  the metric name (e.g., ENDPOINT_REQUEST_COUNT, ENDPOINT_REQUEST_ERROR, etc.)
     * @param granularity the granularity (e.g., DAY, HOUR)
     * @param since       start timestamp
     * @param until       end timestamp
     * @return the flow metric response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/flows/reference/flowsapi">official documentation</a>
     */
    public FlowMetricResponse getFlowMetrics(String flowId, String metricName, String granularity, long since, long until) {
        String fields = String.format("metric.name(%s).granularity(%s).since(%d).until(%d)", metricName, granularity, since, until);
        return executeSync(whatsappBusinessManagementApiService.getFlowMetrics(apiVersion.getValue(), flowId, Map.of("fields", fields)));
    }

    // --- Analytics ---

    /**
     * Get message analytics for a WABA.
     *
     * @param wabaId       the WABA ID
     * @param start        start timestamp (epoch seconds)
     * @param end          end timestamp (epoch seconds)
     * @param granularity  the granularity (e.g., "DAY", "MONTH")
     * @param phoneNumbers optional list of phone numbers to filter by
     * @param countryCodes optional list of country codes to filter by
     * @return the analytics response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/analytics">official documentation</a>
     */
    public AnalyticsResponse getAnalytics(String wabaId, long start, long end, String granularity, List<String> phoneNumbers, List<String> countryCodes) {
        StringBuilder fieldsBuilder = new StringBuilder();
        fieldsBuilder.append(String.format("analytics.start(%d).end(%d).granularity(%s)", start, end, granularity));
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            fieldsBuilder.append(".phone_numbers([").append(phoneNumbers.stream().collect(Collectors.joining(","))).append("])");
        }
        if (countryCodes != null && !countryCodes.isEmpty()) {
            fieldsBuilder.append(".country_codes([").append(countryCodes.stream().map(c -> "\"" + c + "\"").collect(Collectors.joining(","))).append("])");
        }
        return executeSync(whatsappBusinessManagementApiService.getAnalytics(apiVersion.getValue(), wabaId, Map.of("fields", fieldsBuilder.toString())));
    }

    /**
     * Get conversation analytics for a WABA.
     *
     * @param wabaId                  the WABA ID
     * @param start                   start timestamp (epoch seconds)
     * @param end                     end timestamp (epoch seconds)
     * @param granularity             the granularity (e.g., "DAILY", "MONTHLY")
     * @param conversationDirections  optional list of directions (e.g., "business_initiated", "user_initiated")
     * @param dimensions              optional list of dimensions (e.g., "conversation_type", "conversation_direction")
     * @return the conversation analytics response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/analytics">official documentation</a>
     */
    public ConversationAnalyticsResponse getConversationAnalytics(String wabaId, long start, long end, String granularity, List<String> conversationDirections, List<String> dimensions) {
        StringBuilder fieldsBuilder = new StringBuilder();
        fieldsBuilder.append(String.format("conversation_analytics.start(%d).end(%d).granularity(%s)", start, end, granularity));
        if (conversationDirections != null && !conversationDirections.isEmpty()) {
            fieldsBuilder.append(".conversation_directions([").append(conversationDirections.stream().map(d -> "\"" + d + "\"").collect(Collectors.joining(","))).append("])");
        }
        if (dimensions != null && !dimensions.isEmpty()) {
            fieldsBuilder.append(".dimensions([").append(dimensions.stream().map(d -> "\"" + d + "\"").collect(Collectors.joining(","))).append("])");
        }
        return executeSync(whatsappBusinessManagementApiService.getConversationAnalytics(apiVersion.getValue(), wabaId, Map.of("fields", fieldsBuilder.toString())));
    }

    // --- Billing ---

    /**
     * Get extended credit lines for a business.
     *
     * @param businessId the business portfolio ID
     * @return the extended credits
     * @see <a href="https://developers.facebook.com/docs/marketing-api/reference/extended-credit">official documentation</a>
     */
    public ExtendedCredits getExtendedCredits(String businessId) {
        return executeSync(whatsappBusinessManagementApiService.getExtendedCredits(apiVersion.getValue(), businessId));
    }

    // --- Business Compliance ---

    /**
     * Get India-based business compliance information.
     *
     * @param phoneNumberId the phone number id
     * @return the compliance info response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/business-compliance">official documentation</a>
     */
    public ComplianceInfoResponse getBusinessComplianceInfo(String phoneNumberId) {
        return executeSync(whatsappBusinessManagementApiService.getBusinessComplianceInfo(apiVersion.getValue(), phoneNumberId));
    }

    /**
     * Add India-based business compliance information.
     *
     * @param phoneNumberId  the phone number id
     * @param complianceInfo the compliance info to add
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/business-compliance">official documentation</a>
     */
    public Response addBusinessComplianceInfo(String phoneNumberId, CreateComplianceInfo complianceInfo) {
        return executeSync(whatsappBusinessManagementApiService.addBusinessComplianceInfo(apiVersion.getValue(), phoneNumberId, complianceInfo));
    }

}
