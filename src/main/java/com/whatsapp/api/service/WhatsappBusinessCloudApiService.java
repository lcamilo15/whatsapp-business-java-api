package com.whatsapp.api.service;

import com.whatsapp.api.domain.block.BlockUserRequest;
import com.whatsapp.api.domain.block.BlockUserResponse;
import com.whatsapp.api.domain.block.BlockedUsers;
import com.whatsapp.api.domain.media.Media;
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
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * The interface Whatsapp business cloud api service.
 */
public interface WhatsappBusinessCloudApiService {

    /**
     * Send message call.
     *
     * @param phoneNumberId the phone number id
     * @param message       the message
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}/messages")
    Call<MessageResponse> sendMessage(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body Message message);

    /**
     * Upload media call.
     *
     * @param phoneNumberId  the phone number id
     * @param file           the file
     * @param messageProduct the message product
     * @return the call
     */
    @Multipart
    @POST("/{api-version}/{Phone-Number-ID}/media")
    Call<UploadResponse> uploadMedia(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Part MultipartBody.Part file,
                                     @Part MultipartBody.Part messageProduct);

    /**
     * Retrieve media url call.
     *
     * @param mediaId the media id
     * @return the call
     */
    @GET("/{api-version}/{media-id}")
    Call<Media> retrieveMediaUrl(@Path("api-version") String apiVersion, @Path("media-id") String mediaId);

    /**
     * Download media file call.
     *
     * @param url the url
     * @return the call
     */
    @GET
    @Streaming
    @Headers(value = "User-Agent:curl/7.64.1")
    Call<ResponseBody> downloadMediaFile(@Url String url);

    /**
     * Delete media call.
     *
     * @param mediaId the media id
     * @return the call
     */
    @DELETE("/{api-version}/{media-id}")
    Call<Response> deleteMedia(@Path("api-version") String apiVersion, @Path("media-id") String mediaId);

    /**
     * Send mark Meassge as read call.
     *
     * @param phoneNumberId the phone number id
     * @param message       the message
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}/messages")
    Call<Response> markMessageAsRead(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body ReadMessage message);

    /**
     * Two-step verification call.
     *
     * @param phoneNumberId the phone number id
     * @param twoStepCode   the two-step code
     * @return the call
     */
    @POST("/{api-version}/{Phone-Number-ID}")
    Call<Response> twoStepVerification(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body TwoStepCode twoStepCode);

    // --- QR Codes ---

    /**
     * Get a specific QR code by ID.
     */
    @GET("/{api-version}/{Phone-Number-ID}/message_qrdls/{qr-code-id}")
    Call<QrCodes> getQrCode(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Path("qr-code-id") String qrCodeId);

    /**
     * Get all QR codes for a phone number.
     */
    @GET("/{api-version}/{Phone-Number-ID}/message_qrdls")
    Call<QrCodes> getAllQrCodes(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId);

    /**
     * Get all QR codes with query parameters (fields, format, etc.).
     */
    @GET("/{api-version}/{Phone-Number-ID}/message_qrdls")
    Call<QrCodes> getAllQrCodes(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @QueryMap Map<String, String> queryParams);

    /**
     * Create a new QR code.
     */
    @POST("/{api-version}/{Phone-Number-ID}/message_qrdls")
    Call<QrCode> createQrCode(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body CreateQrCode createQrCode);

    /**
     * Update an existing QR code.
     */
    @POST("/{api-version}/{Phone-Number-ID}/message_qrdls")
    Call<QrCode> updateQrCode(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body UpdateQrCode updateQrCode);

    /**
     * Delete a QR code.
     */
    @DELETE("/{api-version}/{Phone-Number-ID}/message_qrdls/{qr-code-id}")
    Call<Response> deleteQrCode(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Path("qr-code-id") String qrCodeId);

    // --- Block Users ---

    /**
     * Get blocked users for a phone number.
     */
    @GET("/{api-version}/{Phone-Number-ID}/block_users")
    Call<BlockedUsers> getBlockedUsers(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId);

    /**
     * Block one or more users.
     */
    @POST("/{api-version}/{Phone-Number-ID}/block_users")
    Call<BlockUserResponse> blockUsers(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body BlockUserRequest request);

    /**
     * Unblock one or more users (DELETE with body).
     */
    @HTTP(method = "DELETE", path = "/{api-version}/{Phone-Number-ID}/block_users", hasBody = true)
    Call<BlockUserResponse> unblockUsers(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body BlockUserRequest request);

    // --- Resumable Upload ---

    /**
     * Create a resumable upload session.
     */
    @POST("/{api-version}/app/uploads")
    Call<UploadSession> createUploadSession(@Path("api-version") String apiVersion, @Query("file_length") long fileLength, @Query("file_type") String fileType, @Query("file_name") String fileName);

    /**
     * Upload file data to a resumable upload session.
     */
    @POST("/{api-version}/{upload-id}")
    Call<UploadFileResponse> uploadFileData(@Path("api-version") String apiVersion, @Path("upload-id") String uploadId, @Header("file_offset") long fileOffset, @Body RequestBody fileData);

    /**
     * Query the status of a resumable upload session.
     */
    @GET("/{api-version}/{upload-id}")
    Call<UploadStatus> queryUploadStatus(@Path("api-version") String apiVersion, @Path("upload-id") String uploadId);

    // --- Typing Indicators ---

    /**
     * Send a typing indicator and/or read receipt.
     */
    @POST("/{api-version}/{Phone-Number-ID}/messages")
    Call<Response> sendTypingIndicator(@Path("api-version") String apiVersion, @Path("Phone-Number-ID") String phoneNumberId, @Body TypingMessage typingMessage);

    // --- Debug Token ---

    /**
     * Debug/inspect an access token.
     */
    @GET("/{api-version}/debug_token")
    Call<DebugTokenResponse> debugToken(@Path("api-version") String apiVersion, @Query("input_token") String inputToken);
}
