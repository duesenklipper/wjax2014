package de.wicketbuch.wjax2014;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

public class QueuingPage extends WebPage {
    public QueuingPage() {
        this.queue(new Form<Void>("form"));
        this.queue(new WebMarkupContainer("person"));
        this.queue(new TextField<String>("firstname"));
        this.queue(new TextField<String>("lastname"));

        this.queue(new WebMarkupContainer("address"));
        this.queue(new TextField<String>("street"));
        this.queue(new TextField<String>("zip"));
        this.queue(new TextField<String>("city"));

        this.queue(new WebMarkupContainer("online"));
        this.queue(new TextField<String>("email"));
        this.queue(new TextField<String>("twitter"));
    }
}
