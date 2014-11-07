package de.wicketbuch.wjax2014;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        final Form<?> form = new Form<Void>("form");
        this.add(form);
        WebMarkupContainer person = new WebMarkupContainer("person");
        form.add(person);
        person.add(new TextField<String>("firstname"));
        person.add(new TextField<String>("lastname"));

        WebMarkupContainer address = new WebMarkupContainer("address");
        form.add(address);
        address.add(new TextField<String>("street"));
        address.add(new TextField<String>("zip"));
        address.add(new TextField<String>("city"));

        WebMarkupContainer online = new WebMarkupContainer("online");
        form.add(online);
        online.add(new TextField<String>("email"));
        online.add(new TextField<String>("twitter"));
    }
}
