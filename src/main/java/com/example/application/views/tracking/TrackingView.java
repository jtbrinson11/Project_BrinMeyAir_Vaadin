package com.example.application.views.tracking;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tracking")
@Route(value = "tracking", layout = MainLayout.class)
public class TrackingView extends VerticalLayout {

    public TrackingView() {
        VerticalLayout layout = new VerticalLayout();

        Div head = new Div();
        H1 pageTitle = new H1("Tracking");
        pageTitle.addClassNames("my-m", "me-auto", "text-c");
        head.add(pageTitle);
        layout.add(head);

        layout.add(createTrackingForm());

        layout.setSizeFull();
        layout.setHorizontalComponentAlignment(Alignment.CENTER);
        layout.getStyle().set("text-align", "center");

        this.add(layout);
    }

    private Component createTrackingForm() {
        VerticalLayout main = new VerticalLayout();
        TextField orderNo = new TextField();
        orderNo.setValue("Enter tracking number . . .");
        Button submit = new Button("Track item");
        FormLayout form = new FormLayout(orderNo);
        main.add(form, submit);
        main.setHorizontalComponentAlignment(Alignment.CENTER);

        return main;
    }

}
