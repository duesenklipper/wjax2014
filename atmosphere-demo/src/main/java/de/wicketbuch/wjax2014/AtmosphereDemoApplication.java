package de.wicketbuch.wjax2014;

import de.agilecoders.wicket.webjars.WicketWebjars;
import org.apache.wicket.atmosphere.EventBus;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see de.wicketbuch.wjax2014.Start#main(String[])
 */
public class AtmosphereDemoApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		WicketWebjars.install(this);
		final EventBus eventBus = new EventBus(this);
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		final Runnable beeper = new Runnable() {
			@Override
			public void run() {
				try {
					eventBus.post(new Date());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		scheduler.scheduleWithFixedDelay(beeper, 2, 2, TimeUnit.SECONDS);
	}
}
