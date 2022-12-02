package com.example.application.views.shipping;

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
import com.vaadin.flow.component.textfield.TextField;
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

        FormLayout shipmentForm = new FormLayout();
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

        TextField firstName = new TextField("First Name:");
        TextField lastName = new TextField("Last Name:");
        EmailField email = new EmailField("E-mail Address");
        TextField phone = new TextField("Phone Number:");

        customerForm.add(firstName, lastName, email, phone);

        TextField length = new TextField("Length:");
        TextField width = new TextField("Width:");
        TextField height = new TextField("Height:");
        TextField weight = new TextField("Weight:");
        RadioButtonGroup<String> hazard = new RadioButtonGroup<>("Hazardous:");
        hazard.setItems("Yes", "No");
        RadioButtonGroup<String> perish = new RadioButtonGroup<>("Perishable:");
        perish.setItems("Yes", "No");
        RadioButtonGroup<String> service = new RadioButtonGroup<>("Desired Service:");
        service.setItems("Slowest", "Slower", "Normal", "Quicker", "Quickest");

        shipmentForm.add(length, width, height, weight, hazard, perish, service);

        TextField streetAddress1 = new TextField("Street Address:");
        TextField city1 = new TextField("City/Town:");
        TextField state1 = new TextField("State/Province:");
        TextField country1 = new TextField("Country:");
        TextField zipCode1 = new TextField("Zip code:");

        TextField streetAddress2 = new TextField("Street Address:");
        TextField city2 = new TextField("City/Town:");
        TextField state2 = new TextField("State/Province:");
        TextField country2 = new TextField("Country:");
        TextField zipCode2 = new TextField("Zip code:");

        shippingForm.add(streetAddress1, city1, state1, country1, zipCode1, streetAddress2, city2, state2, country2, zipCode2);

        TextField billingAddress = new TextField("Street Address:");
        TextField billingCity = new TextField("City/Town:");
        TextField billingState = new TextField("State/Province:");
        TextField billingCountry = new TextField("Country:");
        TextField billingZipCode = new TextField("Zip code:");

        billingForm.add(billingAddress, billingCity, billingState, billingCountry, billingZipCode);

        TextField nameOnCard = new TextField("Name on Card:");
        TextField cardNumber = new TextField("Card Number:");
        TextField cardExpiration = new TextField("Card Expiration:");
        TextField cardCVC = new TextField("Card CVC:");

        paymentForm.add(nameOnCard, cardNumber, cardExpiration, cardCVC);

        return accordion;
    }

}
