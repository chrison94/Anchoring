package hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import listener.PostInsertListenerImp;
import listener.PostUpdateEventListenerImp;

public class EventListenerIntegrator implements Integrator {

	@Override
	public void integrate(Metadata metadata, SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {

		EventListenerRegistry eventListenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);

		eventListenerRegistry.getEventListenerGroup(EventType.POST_UPDATE)
				.appendListener(new PostUpdateEventListenerImp());
		eventListenerRegistry.getEventListenerGroup(EventType.POST_INSERT).appendListener(new PostInsertListenerImp());
	}

	public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

	}
}