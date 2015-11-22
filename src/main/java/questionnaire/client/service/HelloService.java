package questionnaire.client.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import questionnaire.client.actor.ActorSystemHolder;
import questionnaire.client.actor.HelloUntypedActor;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;

@Service
public class HelloService {
	@Autowired
	private ActorSystemHolder actorSystemHolder;
	private ActorRef helloUntypedActor;

	public String hello(String name) {
		String result = "";
		Timeout timeout = new Timeout(Duration.create(5, "seconds"));
		Future<Object> future = Patterns.ask(helloUntypedActor, new HelloUntypedActor.Msg(name), timeout);
		try {
			HelloUntypedActor.Msg msg = (HelloUntypedActor.Msg) Await.result(future, timeout.duration());
			result = msg.getMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@PostConstruct
	public void init() {
		helloUntypedActor = actorSystemHolder.getActorSystem().actorOf(HelloUntypedActor.props("Hello, "));
	}

}
