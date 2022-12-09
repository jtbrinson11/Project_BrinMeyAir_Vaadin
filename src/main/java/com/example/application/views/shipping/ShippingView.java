package com.example.application.views.shipping;

import com.example.application.backend.entity.Customer;
import com.example.application.backend.entity.Service;
import com.example.application.backend.entity.Shipment;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.RegexpValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Shipping")
@Route(value = "shipping", layout = MainLayout.class)
public class ShippingView extends VerticalLayout {

    private final String CUSTOMER = "Customer Details";
    private final String SHIPMENT_DETAILS = "Shipment Details";
    private final String SHIPPING_DETAILS = "Shipping Addresses";
    private final String BILLING_DETAILS = "Billing Address";
    private final String PAYMENT_DETAILS = "Payment Details";

    private Binder<Shipment> shipmentBinder = new Binder<>(Shipment.class);

    private Binder<Service> serviceBinder = new Binder<>(Service.class);

    private Binder<Customer> customerBinder = new Binder<>(Customer.class);

    public ShippingView() {
        VerticalLayout layout = new VerticalLayout();

        Div head = new Div();
        H1 pageTitle = new H1("Shipping");
        pageTitle.addClassNames("my-m", "me-auto", "text-c");
        head.add(pageTitle);
        layout.add(head);

        layout.add(createAccordionForm());

        Button submit = new Button("Submit");
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layout.add(submit);

        layout.setSizeFull();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.getStyle().set("text-align", "center");

        add(layout);
    }

    private Component createAccordionForm() {
        Accordion accordion = new Accordion();

        FormLayout customerForm = new FormLayout();
        AccordionPanel customerFormPanel = accordion.add(CUSTOMER,
                customerForm);
        customerFormPanel.addThemeVariants(DetailsVariant.FILLED);

        VerticalLayout shipmentForm = new VerticalLayout();
        AccordionPanel shipmentFormPanel = accordion.add(SHIPMENT_DETAILS,
                shipmentForm);
        shipmentFormPanel.addThemeVariants(DetailsVariant.FILLED);

        FormLayout shippingForm = new FormLayout();
        AccordionPanel shippingFormPanel = accordion.add(SHIPPING_DETAILS,
                shippingForm);
        shippingFormPanel.addThemeVariants(DetailsVariant.FILLED);

        FormLayout billingForm = new FormLayout();
        AccordionPanel billingFormPanel = accordion.add(BILLING_DETAILS,
                billingForm);
        billingFormPanel.addThemeVariants(DetailsVariant.FILLED);

        FormLayout paymentForm = new FormLayout();
        AccordionPanel paymentFormPanel = accordion.add(PAYMENT_DETAILS,
                paymentForm);
        paymentFormPanel.addThemeVariants(DetailsVariant.FILLED);

        TextField firstName = new TextField();
        firstName.setWidthFull();
        RegexpValidator firstNameValid = new RegexpValidator("Invalid First Name", "^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$");
        customerBinder.forField(firstName)
                        .asRequired("First Name is required")
                        .withValidator(firstNameValid)
                        .bind("firstName");
        customerForm.addFormItem(firstName, "First Name");

        TextField lastName = new TextField();
        lastName.setWidthFull();
        RegexpValidator lastNameValid = new RegexpValidator("Invalid Last Name", "^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$");
        customerBinder.forField(lastName)
                        .asRequired("Last Name is required")
                        .withValidator(lastNameValid)
                        .bind("lastName");
        customerForm.addFormItem(lastName, "Last Name");

        EmailField email = new EmailField();
        email.setWidthFull();
        customerBinder.forField(email)
                        .asRequired("E-mail Address is required")
                        .withValidator(new EmailValidator("Invalid E-mail Address"))
                        .bind("email");
        customerForm.addFormItem(email, "E-mail Address");

        TextField phone = new TextField();
        phone.setPlaceholder("e.g +1 1234567890");
        phone.setWidthFull();
        RegexpValidator phoneValid = new RegexpValidator("Invalid Phone Number", "^\\+(?:[0-9] ?){6,14}[0-9]$");
        customerBinder.forField(phone)
                        .asRequired("Phone Number is required")
                        .withValidator(phoneValid)
                        .bind("phone");
        customerForm.addFormItem(phone, "Phone Number");

        customerForm.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("20em", 1),
                new FormLayout.ResponsiveStep("50em", 2));

        customerBinder.bindInstanceFields(customerForm);

        FormLayout dimensions = new FormLayout();

        NumberField length = new NumberField();
        length.setSuffixComponent(new Span("ft."));
        length.setWidthFull();
        shipmentBinder.forField(length)
                        .asRequired("Required")
                        .bind("length");
        dimensions.addFormItem(length, "Length");

        NumberField width = new NumberField();
        width.setSuffixComponent(new Span("ft."));
        width.setWidthFull();
        shipmentBinder.forField(width)
                        .asRequired("Required")
                        .bind("width");
        dimensions.addFormItem(width, "Width");

        NumberField height = new NumberField();
        height.setSuffixComponent(new Span("ft."));
        height.setWidthFull();
        shipmentBinder.forField(height)
                        .asRequired("Required")
                        .bind("height");
        dimensions.addFormItem(height, "Height");

        NumberField weight = new NumberField();
        weight.setSuffixComponent(new Span("lbs."));
        weight.setWidthFull();
        shipmentBinder.forField(weight)
                        .asRequired("Required")
                        .bind("weight");
        dimensions.addFormItem(weight, "Weight");

        shipmentForm.add(dimensions);

        VerticalLayout buttons = new VerticalLayout();
        buttons.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        RadioButtonGroup<String> hazard = new RadioButtonGroup<>("Hazardous:");
        hazard.setItems("Yes", "No");

        RadioButtonGroup<String> perish = new RadioButtonGroup<>("Perishable:");
        perish.setItems("Yes", "No");

        RadioButtonGroup<String> service = new RadioButtonGroup<>("Desired Service:");
        service.setItems("Slowest", "Slower", "Normal", "Quicker", "Quickest");

        buttons.add(hazard, perish, service);
        shipmentForm.add(buttons);

        shipmentBinder.bindInstanceFields(shipmentForm);

        TextField streetAddress1 = new TextField("Street Address:");
        TextField city1 = new TextField("City/Town:");
        TextField state1 = new TextField("State/Province:");
        TextField country1 = new TextField("Country:");
        IntegerField zipCode1 = new IntegerField("Zip code:");

        TextField streetAddress2 = new TextField("Street Address:");
        TextField city2 = new TextField("City/Town:");
        TextField state2 = new TextField("State/Province:");
        TextField country2 = new TextField("Country:");
        IntegerField zipCode2 = new IntegerField("Zip code:");

        shippingForm.add(streetAddress1, city1, state1, country1, zipCode1, streetAddress2, city2, state2, country2, zipCode2);

        TextField billingAddress = new TextField("Street Address:");
        TextField billingCity = new TextField("City/Town:");
        TextField billingState = new TextField("State/Province:");
        TextField billingCountry = new TextField("Country:");
        IntegerField billingZipCode = new IntegerField("Zip code:");

        billingForm.add(billingAddress, billingCity, billingState, billingCountry, billingZipCode);

        TextField nameOnCard = new TextField("Name on Card:");
        TextField cardNumber = new TextField("Card Number:");
        TextField cardExpiration = new TextField("Card Expiration:");
        TextField cardCVC = new TextField("Card CVC:");

        paymentForm.add(nameOnCard, cardNumber, cardExpiration, cardCVC);

        return accordion;
    }

}
