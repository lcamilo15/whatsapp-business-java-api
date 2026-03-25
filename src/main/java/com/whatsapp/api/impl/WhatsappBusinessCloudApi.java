package com.whatsapp.api.impl;

import com.whatsapp.api.configuration.ApiVersion;
import com.whatsapp.api.domain.block.BlockUserRequest;
import com.whatsapp.api.domain.block.BlockUserResponse;
import com.whatsapp.api.domain.block.BlockedUsers;
import com.whatsapp.api.domain.media.FileType;
import com.whatsapp.api.domain.media.Media;
import com.whatsapp.api.domain.media.MediaFile;
import com.whatsapp.api.domain.media.UploadFileResponse;
import com.whatsapp.api.domain.media.UploadResponse;
import com.whatsapp.api.domain.media.UploadSession;
import com.whatsapp.api.domain.media.UploadStatus;
import com.whatsapp.api.domain.messages.Message;
import com.whatsapp.api.domain.messages.ReadMessage;
import com.whatsapp.api.domain.messages.TypingMessage;
import com.whatsapp.api.domain.messages.response.MessageResponse;
import com.whatsapp.api.domain.phone.TwoStepCode;
import com.whatsapp.api.domain.qrcode.CreateQrCode;
import com.whatsapp.api.domain.qrcode.QrCode;
import com.whatsapp.api.domain.qrcode.QrCodes;
import com.whatsapp.api.domain.qrcode.UpdateQrCode;
import com.whatsapp.api.domain.response.Response;
import com.whatsapp.api.domain.token.DebugTokenResponse;
import com.whatsapp.api.service.WhatsappBusinessCloudApiService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

import java.util.Map;

import static com.whatsapp.api.WhatsappApiServiceGenerator.*;
import static com.whatsapp.api.configuration.WhatsappApiConfig.getApiVersion;

/**
 * Implementation of WhatsApp Business Platform Cloud API with synchronous/blocking
 * method calls.
 *
 * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api">WhatsApp Business Platform Cloud API</a>
 */
public class WhatsappBusinessCloudApi {

    private final WhatsappBusinessCloudApiService whatsappBusinessCloudApiService;

    private final ApiVersion apiVersion;

    /**
     * Instantiates a new Whatsapp business cloud api.
     *
     * @param token the token
     */
    public WhatsappBusinessCloudApi(String token) {
        this.apiVersion = getApiVersion();
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }


    /**
     * Instantiates a new Whatsapp business cloud api, specifying API version
     *
     * @param token      the token
     * @param apiVersion api version
     */
    public WhatsappBusinessCloudApi(String token, ApiVersion apiVersion) {
        this.apiVersion = apiVersion;
        this.whatsappBusinessCloudApiService = createService(WhatsappBusinessCloudApiService.class, token);

    }

    /**
     * Use this endpoint to send text, media, contacts, location, and interactive messages,
     * as well as message templates to your customers.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link Message} object.
     * @return {@link MessageResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/messages">official documentation</a>
     */
    public MessageResponse sendMessage(String phoneNumberId, Message message) {

        return executeSync(whatsappBusinessCloudApiService.sendMessage(apiVersion.getValue(), phoneNumberId, message));
    }

    /**
     * You can use the endpoint to upload media:
     * All media files sent through this endpoint are encrypted and persist for 30 days, unless they are deleted earlier
     * <p>The maximum supported file size for media messages on Cloud API is 100MB. In the event the customer sends a file that is greater than 100MB, you will receive a webhook with error code 131052 and title:
     * "Media file size too big. Max file size we currently support: 100MB. Please communicate with your customer to send a media file that is smaller than 100MB"_.
     * We advise that you send customers a warning message that their media file exceeds the maximum file size when this webhook event is triggered.</p>
     *
     * @param phoneNumberId Business phone number ID. If included, the operation will only be processed if the ID matches the ID of the business phone number that the media was uploaded on.
     * @param fileName      file name. Ex: photo1.jpg
     * @param fileType      the file type. See {@link FileType}
     * @param file          byte[] - file content
     * @return {@link UploadResponse}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public UploadResponse uploadMedia(String phoneNumberId, String fileName, FileType fileType, byte[] file) {

        var requestFile = MultipartBody.create(file, MediaType.parse(fileType.getType()));
        Part body = Part.createFormData("file", fileName, requestFile);

        var messageProduct = Part.createFormData("messaging_product", "whatsapp");

        return executeSync(whatsappBusinessCloudApiService.uploadMedia(apiVersion.getValue(), phoneNumberId, body, messageProduct));
    }

    /**
     * Retrieve {@link Media} object. A successful response includes an object with a media url. The URL is only valid for 5 minutes. To use this URL, see {@link WhatsappBusinessCloudApi#downloadMediaFile(String)}
     *
     * @param mediaId the media id
     * @return the media
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public Media retrieveMediaUrl(String mediaId) {
        return executeSync(whatsappBusinessCloudApiService.retrieveMediaUrl(apiVersion.getValue(), mediaId));

    }

    /**
     * Download media file from whatsapp server
     *
     * @param url the url
     * @return the media file {@link MediaFile}
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public MediaFile downloadMediaFile(String url) {

        return executeDownloadSync(whatsappBusinessCloudApiService.downloadMediaFile(url));

    }

    /**
     * Delete media from whatsapp server
     *
     * @param mediaId the media id
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/media">official documentation</a>
     */
    public Response deleteMedia(String mediaId) {

        return executeSync(whatsappBusinessCloudApiService.deleteMedia(apiVersion.getValue(), mediaId));
    }

    /**
     * Mark a message as Read
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param message       The {@link ReadMessage} object.
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/mark-message-as-read">official documentation</a>
     */
    public Response markMessageAsRead(String phoneNumberId, ReadMessage message) {
        return executeSync(whatsappBusinessCloudApiService.markMessageAsRead(apiVersion.getValue(), phoneNumberId, message));
    }

    /**
     * Business Solution Providers (BSPs) must authenticate themselves with
     * an access token with the whatsapp_business_management permission.
     *
     * @param phoneNumberId Represents a specific phone number.
     * @param twoStepCode   The {@link TwoStepCode} object.
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/two-step-verification">official documentation</a>
     */
    public Response twoStepVerification(String phoneNumberId, TwoStepCode twoStepCode) {
        return executeSync(whatsappBusinessCloudApiService.twoStepVerification(apiVersion.getValue(), phoneNumberId, twoStepCode));
    }

    // --- QR Codes ---

    /**
     * Get a specific QR code by ID.
     *
     * @param phoneNumberId the phone number id
     * @param qrCodeId      the QR code id
     * @return the QR codes response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public QrCodes getQrCode(String phoneNumberId, String qrCodeId) {
        return executeSync(whatsappBusinessCloudApiService.getQrCode(apiVersion.getValue(), phoneNumberId, qrCodeId));
    }

    /**
     * Get all QR codes for a phone number.
     *
     * @param phoneNumberId the phone number id
     * @return the QR codes response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public QrCodes getAllQrCodes(String phoneNumberId) {
        return executeSync(whatsappBusinessCloudApiService.getAllQrCodes(apiVersion.getValue(), phoneNumberId));
    }

    /**
     * Get all QR codes with specific fields.
     *
     * @param phoneNumberId the phone number id
     * @param fields        the fields to retrieve
     * @return the QR codes response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public QrCodes getAllQrCodes(String phoneNumberId, String... fields) {
        return executeSync(whatsappBusinessCloudApiService.getAllQrCodes(apiVersion.getValue(), phoneNumberId, Map.of("fields", String.join(",", fields))));
    }

    /**
     * Create a new QR code.
     *
     * @param phoneNumberId the phone number id
     * @param createQrCode  the create QR code request
     * @return the created QR code
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public QrCode createQrCode(String phoneNumberId, CreateQrCode createQrCode) {
        return executeSync(whatsappBusinessCloudApiService.createQrCode(apiVersion.getValue(), phoneNumberId, createQrCode));
    }

    /**
     * Update an existing QR code.
     *
     * @param phoneNumberId the phone number id
     * @param updateQrCode  the update QR code request
     * @return the updated QR code
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public QrCode updateQrCode(String phoneNumberId, UpdateQrCode updateQrCode) {
        return executeSync(whatsappBusinessCloudApiService.updateQrCode(apiVersion.getValue(), phoneNumberId, updateQrCode));
    }

    /**
     * Delete a QR code.
     *
     * @param phoneNumberId the phone number id
     * @param qrCodeId      the QR code id
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/business-management-api/qr-codes">official documentation</a>
     */
    public Response deleteQrCode(String phoneNumberId, String qrCodeId) {
        return executeSync(whatsappBusinessCloudApiService.deleteQrCode(apiVersion.getValue(), phoneNumberId, qrCodeId));
    }

    // --- Block Users ---

    /**
     * Get blocked users for a phone number.
     *
     * @param phoneNumberId the phone number id
     * @return the blocked users
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/block-users">official documentation</a>
     */
    public BlockedUsers getBlockedUsers(String phoneNumberId) {
        return executeSync(whatsappBusinessCloudApiService.getBlockedUsers(apiVersion.getValue(), phoneNumberId));
    }

    /**
     * Block one or more users.
     *
     * @param phoneNumberId the phone number id
     * @param request       the block user request
     * @return the block user response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/block-users">official documentation</a>
     */
    public BlockUserResponse blockUsers(String phoneNumberId, BlockUserRequest request) {
        return executeSync(whatsappBusinessCloudApiService.blockUsers(apiVersion.getValue(), phoneNumberId, request));
    }

    /**
     * Unblock one or more users.
     *
     * @param phoneNumberId the phone number id
     * @param request       the unblock user request
     * @return the block user response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/reference/block-users">official documentation</a>
     */
    public BlockUserResponse unblockUsers(String phoneNumberId, BlockUserRequest request) {
        return executeSync(whatsappBusinessCloudApiService.unblockUsers(apiVersion.getValue(), phoneNumberId, request));
    }

    // --- Resumable Upload ---

    /**
     * Create a resumable upload session for large files (e.g., profile pictures).
     *
     * @param fileLength  the file length in bytes
     * @param fileType    the MIME type (e.g., "image/jpeg")
     * @param fileName    the file name
     * @return the upload session with session ID
     * @see <a href="https://developers.facebook.com/docs/graph-api/guides/upload">official documentation</a>
     */
    public UploadSession createUploadSession(long fileLength, String fileType, String fileName) {
        return executeSync(whatsappBusinessCloudApiService.createUploadSession(apiVersion.getValue(), fileLength, fileType, fileName));
    }

    /**
     * Upload file data to a resumable upload session.
     *
     * @param uploadId    the upload session ID
     * @param fileOffset  the byte offset to start from
     * @param data        the file data bytes
     * @param contentType the content type (e.g., "image/jpeg")
     * @return the upload file response with handle
     * @see <a href="https://developers.facebook.com/docs/graph-api/guides/upload">official documentation</a>
     */
    public UploadFileResponse uploadFileData(String uploadId, long fileOffset, byte[] data, String contentType) {
        RequestBody body = RequestBody.create(data, MediaType.parse(contentType));
        return executeSync(whatsappBusinessCloudApiService.uploadFileData(apiVersion.getValue(), uploadId, fileOffset, body));
    }

    /**
     * Query the status of a resumable upload session.
     *
     * @param uploadId the upload session ID
     * @return the upload status
     * @see <a href="https://developers.facebook.com/docs/graph-api/guides/upload">official documentation</a>
     */
    public UploadStatus queryUploadStatus(String uploadId) {
        return executeSync(whatsappBusinessCloudApiService.queryUploadStatus(apiVersion.getValue(), uploadId));
    }

    // --- Typing Indicators ---

    /**
     * Send a typing indicator and/or read receipt.
     *
     * @param phoneNumberId the phone number id
     * @param typingMessage the typing message request
     * @return the response
     * @see <a href="https://developers.facebook.com/docs/whatsapp/cloud-api/guides/send-messages#typing-indicators">official documentation</a>
     */
    public Response sendTypingIndicator(String phoneNumberId, TypingMessage typingMessage) {
        return executeSync(whatsappBusinessCloudApiService.sendTypingIndicator(apiVersion.getValue(), phoneNumberId, typingMessage));
    }

    // --- Debug Token ---

    /**
     * Debug/inspect an access token to see its type and granted permissions.
     *
     * @param inputToken the token to inspect
     * @return the debug token response
     * @see <a href="https://developers.facebook.com/docs/facebook-login/access-tokens/debugging-and-error-handling">official documentation</a>
     */
    public DebugTokenResponse debugToken(String inputToken) {
        return executeSync(whatsappBusinessCloudApiService.debugToken(apiVersion.getValue(), inputToken));
    }

}
