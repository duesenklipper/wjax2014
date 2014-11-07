package de.wicketbuch.wjax2014;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.atmosphere.Subscribe;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Date;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	private final IModel<String> tickModel = Model.of("");
	private final Label tickLabel;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		tickLabel = new Label("tick", tickModel);
		tickLabel.setOutputMarkupId(true);
		add(tickLabel);
    }

	@Subscribe
	public void tick(AjaxRequestTarget ajax, Date date) {
		tickModel.setObject(date.toString());
		ajax.add(tickLabel);
	}
}
