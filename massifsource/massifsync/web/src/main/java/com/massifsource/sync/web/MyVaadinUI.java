package com.massifsource.sync.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.massifsource.sync.db.h2.repository.DirectoryRepository;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@Component
public class MyVaadinUI extends UI
{
	
	@Autowired
	DirectoryRepository directoryRepository;
	
	private static final long serialVersionUID = 2582897831380309074L;

	@Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(new TestComposite());
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
                
            }
        });
        layout.addComponent(button);
        layout.addComponent(new TestComposite());
    }

}
