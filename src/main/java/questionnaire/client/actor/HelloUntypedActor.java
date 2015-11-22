package questionnaire.client.actor;

import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloUntypedActor extends UntypedActor {

	private final String prefix;

	public HelloUntypedActor(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public void onReceive(Object inputMsg) throws Exception {
		if (inputMsg instanceof Msg) {
			String msg = ((Msg) inputMsg).getMsg();
			Msg outputMsg = new Msg(prefix + " " + msg);
			sender().tell(outputMsg, self());
		} else {
			unhandled(inputMsg);
		}
	}

	public static class Msg {
		private String msg;

		public Msg(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
	}

	public static Props props(String prefix) {
		return Props.create(HelloUntypedActor.class, () -> new HelloUntypedActor(prefix));
	}
}
