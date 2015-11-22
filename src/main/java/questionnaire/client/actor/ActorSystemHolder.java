package questionnaire.client.actor;

import org.springframework.stereotype.Component;

import akka.actor.ActorSystem;

@Component
public class ActorSystemHolder {
	private final ActorSystem actorSystem;
	
	public ActorSystemHolder() {
		this.actorSystem = ActorSystem.create("QuistionnaireActorSystem");
	}

	public ActorSystem getActorSystem() {
		return actorSystem;
	}
}
