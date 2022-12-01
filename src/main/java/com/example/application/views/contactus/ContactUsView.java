package com.example.application.views.contactus;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contact Us")
@Route(value = "contact", layout = MainLayout.class)
public class ContactUsView extends VerticalLayout {

    public ContactUsView() {
        VerticalLayout layout = new VerticalLayout();

        Div head = new Div();
        H1 pageTitle = new H1("Shipping");
        pageTitle.addClassNames("my-m", "me-auto", "text-c");
        head.add(pageTitle);
        layout.add(head);

        layout.add(createContactForm());

        layout.setSizeFull();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.getStyle().set("text-align", "center");

        add(layout);
    }

    private Component createContactForm() {
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        EmailField email = new EmailField("E-mail Address");
        TextField phone = new TextField("Phone Number");
        Checkbox company = new Checkbox("On behalf of a company");

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>("How can we help?");
        radioGroup.setItems("General", "Shipping", "Tracking", "Other");
        TextArea other = new TextArea("Enter message here:");
        Button submit = new Button("Submit");

        FormLayout form = new FormLayout(firstName, lastName, email, phone, company, radioGroup, other, submit);

        return form;
    }

}
