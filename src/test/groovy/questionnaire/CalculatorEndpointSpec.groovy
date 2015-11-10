package questionnaire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import questionnaire.client.web.CalculatorEndpoint
import spock.lang.Specification

@ContextConfiguration(classes = [ CalculatorEndpoint.class ])
class CalculatorEndpointSpec extends Specification {

	@Autowired
	CalculatorEndpoint calculatorEndpoint

	def "does it calc?"() {
		setup:
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Pavel");
		map.put("age", 24);
		map.put("x", 10);
		map.put("y", 20);

		expect: calculatorEndpoint.sum(10, 20) == map
	}
}
