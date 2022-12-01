package com.example.application.views.services;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Services")
@Route(value = "services", layout = MainLayout.class)
public class ServicesView extends VerticalLayout {

    private Text serviceSelected = new Text("");

    public ServicesView() {
        VerticalLayout layout = new VerticalLayout();

        Div head = new Div();
        H1 pageTitle = new H1("Services");
        pageTitle.addClassNames("my-m", "me-auto", "text-c");
        head.add(pageTitle);
        layout.add(head);

        Text clickBelow = new Text("Select services by:");
        layout.add(clickBelow);

        layout.add(createDropDownMenu());
        layout.add(createTextArea());

        layout.setSizeFull();
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.getStyle().set("text-align", "center");

        add(layout);
    }

    private Component createDropDownMenu() {
        MenuBar menuBar = new MenuBar();
        ComponentEventListener<ClickEvent<MenuItem>> listener = e -> serviceSelected
                .setText(e.getSource().getText());

        MenuItem share = menuBar.addItem("Name");
        SubMenu shareSubMenu = share.getSubMenu();
        shareSubMenu.addItem("Slowest", listener);
        shareSubMenu.addItem("Slower", listener);
        shareSubMenu.addItem("Normal", listener);
        shareSubMenu.addItem("Quicker", listener);
        shareSubMenu.addItem("Quickest", listener);

        return menuBar;
    }

    private Component createTextArea() {
        Div area = new Div();
        VerticalLayout textArea = new VerticalLayout();
        textArea.add(serviceSelected);
        Tab overview = new Tab("Overview");
        Tab details = new Tab("Details");
        Tabs options = new Tabs(overview, details);
        options.setOrientation(Tabs.Orientation.HORIZONTAL);
        options.setEnabled(false);
        textArea.add(options);
        area.add(textArea);

        return area;
    }

}
