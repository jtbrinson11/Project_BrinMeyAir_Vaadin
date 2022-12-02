package com.example.application.views.index;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Home")
@Route(value = "index", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class IndexView extends VerticalLayout {

    public IndexView() {
        VerticalLayout layout = new VerticalLayout();

        Div head = new Div();
        H1 pageTitle = new H1("Welcome to BrinMey Air");
        pageTitle.addClassNames("my-m", "me-auto", "text-c");
        head.add(pageTitle);
        layout.add(head);

        Paragraph para = new Paragraph("Welcome to BrinMey Air. We ship all over the world, but our focus is always you.");
        layout.add(para);

        layout.setSizeFull();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.getStyle().set("text-align", "center");

        add(layout);
    }

}
