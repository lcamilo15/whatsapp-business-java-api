package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.whatsapp.api.domain.messages.payment.OrderStatusAction;
import com.whatsapp.api.domain.messages.payment.PaymentAction;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 *  <li> <p> <b>button</b> - Required for List Messages - It cannot be an empty string and must be unique within the message.
 *  Emojis are supported, markdown is not. Maximum length: 20 characters</p></li>
 *
 *  <li> <p> <b>buttons</b> - Required for Reply Buttons - A button object can contain the following parameters:</p>
 *      <ul>
 *         <li><p><b>type:</b> only supported type is reply (for Reply Button)</p>
 *         <li><p><b>title:</b> Button title. It cannot be an empty string and must be unique within the message. Emojis are supported, markdown is not. Maximum length: 20 characters.</p>
 *         <li><p><b>id:</b> Unique identifier for your button. This ID is returned in the webhook when the button is clicked by the user. Maximum length: 256 characters.</p>
 *      </ul>
 *       <p>You can have up to 3 buttons. You cannot have leading or trailing spaces when setting the ID.</p></li>
 *
 *  <li> <b>catalog_id</b> - Required for Single Product Messages and Multi-Product Messages - Unique identifier of the
 *  Facebook catalog linked to your WhatsApp Business Account. This ID can be retrieved via the Meta Commerce Manager.</li>
 *
 *  <li> <b>product_retailer_id</b> - Required for Single Product Messages and Multi-Product Messages - Unique identifier of the product in a catalog.
 *      <p> To get this ID go to Meta Commerce Manager and select your Meta Business account. You will see a list of shops connected to your account.
 *      Click the shop you want to use. On the left-side panel, click Catalog > Items, and find the item you want to mention.
 *      The ID for that item is displayed under the item's name.</li>
 *
 *  <li> <b>sections</b> - Required for List Messages and Multi-Product Messages - Array of section objects. Minimum of 1, maximum of 10. See section object.</li>
 * </ul>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {

    @JsonProperty("catalog_id")
    private String catalogId;
    @JsonProperty("product_retailer_id")
    private String productRetailerId;
    @JsonProperty("button")
    private String buttonText;
    @JsonProperty("buttons")
    private List<Button> buttons;
    @JsonProperty("sections")
    private List<Section> sections;

    @JsonProperty("name")
    private String name;

    @JsonProperty("parameters")
    private FlowParameters flowParameters;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("payment_configuration")
    private String paymentConfiguration;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("total_amount")
    private com.whatsapp.api.domain.messages.payment.OrderAmount totalAmount;

    @JsonProperty("order")
    private com.whatsapp.api.domain.messages.payment.Order order;

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * Sets catalog id.
     *
     * @param catalogId Required for Single Product Messages and Multi-Product Messages - Unique identifier of the                  Facebook catalog linked to your WhatsApp Business Account. This ID can be retrieved via the Meta Commerce Manager.
     * @return the catalog id
     */
    public Action setCatalogId(String catalogId) {
        this.catalogId = catalogId;
        return this;
    }

    /**
     * Gets product retailer id.
     *
     * @return the product retailer id
     */
    public String getProductRetailerId() {
        return productRetailerId;
    }

    /**
     * Sets product retailer id.
     *
     * @param productRetailerId the product retailer id
     * @return the product retailer id
     */
    public Action setProductRetailerId(String productRetailerId) {
        this.productRetailerId = productRetailerId;
        return this;
    }

    /**
     * Gets button text.
     *
     * @return the button text
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * Sets button text.
     *
     * @param buttonText the button text
     * @return the button text
     */
    public Action setButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    /**
     * Gets buttons.
     *
     * @return the buttons
     */
    public List<Button> getButtons() {
        return buttons;
    }

    /**
     * Sets buttons.
     *
     * @param buttons the buttons
     * @return the buttons
     */
    public Action setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * Add button action.
     *
     * @param button the type {@link Button}
     * @return the action
     */
    public Action addButton(Button button) {
        if (this.buttons == null) this.buttons = new ArrayList<>();

        this.buttons.add(button);
        return this;
    }

    /**
     * Gets sections.
     *
     * @return the sections
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Sets sections.
     *
     * @param sections List of @{@link Section}
     * @return the sections
     */
    public Action setSections(List<Section> sections) {
        this.sections = sections;
        return this;
    }

    /**
     * Add section action.
     *
     * @param section the section
     * @return the action
     */
    public Action addSection(Section section) {
        if (this.sections == null) this.sections = new ArrayList<>();

        this.sections.add(section);
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name. Used for flow actions (e.g. "flow") and payment actions (e.g. "review_and_pay", "review_order").
     *
     * @param name the action name
     * @return the action
     */
    public Action setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets flow parameters.
     *
     * @return the flow parameters
     */
    public FlowParameters getFlowParameters() {
        return flowParameters;
    }

    /**
     * Sets flow parameters. Used when sending flow interactive messages.
     *
     * @param flowParameters the flow parameters
     * @return the action
     */
    public Action setFlowParameters(FlowParameters flowParameters) {
        this.flowParameters = flowParameters;
        return this;
    }

    /**
     * Gets reference id.
     *
     * @return the reference id
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Sets reference id. Used for payment order details messages.
     *
     * @param referenceId the reference id
     * @return the action
     */
    public Action setReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type. Used for payment actions (e.g. "digital-goods").
     *
     * @param type the type
     * @return the action
     */
    public Action setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets payment type.
     *
     * @return the payment type
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets payment type (e.g. "upi", "p2m-lite:stripe").
     *
     * @param paymentType the payment type
     * @return the action
     */
    public Action setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    /**
     * Gets payment configuration.
     *
     * @return the payment configuration
     */
    public String getPaymentConfiguration() {
        return paymentConfiguration;
    }

    /**
     * Sets payment configuration name.
     *
     * @param paymentConfiguration the payment configuration
     * @return the action
     */
    public Action setPaymentConfiguration(String paymentConfiguration) {
        this.paymentConfiguration = paymentConfiguration;
        return this;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency (e.g. "INR", "SGD").
     *
     * @param currency the currency
     * @return the action
     */
    public Action setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Gets total amount.
     *
     * @return the total amount
     */
    public com.whatsapp.api.domain.messages.payment.OrderAmount getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets total amount for payment order details.
     *
     * @param totalAmount the total amount
     * @return the action
     */
    public Action setTotalAmount(com.whatsapp.api.domain.messages.payment.OrderAmount totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public com.whatsapp.api.domain.messages.payment.Order getOrder() {
        return order;
    }

    /**
     * Sets order for payment order details.
     *
     * @param order the order
     * @return the action
     */
    public Action setOrder(com.whatsapp.api.domain.messages.payment.Order order) {
        this.order = order;
        return this;
    }
}
