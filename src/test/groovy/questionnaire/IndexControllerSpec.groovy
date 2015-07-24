package questionnaire

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

import questionnaire.client.config.RootConfig
import questionnaire.client.web.IndexController
import spock.lang.Specification

@ContextConfiguration(classes = [ IndexController.class ])
class IndexControllerSpec extends Specification {

	@Autowired
	IndexController indexController

	def "is it greets"() {
		expect: indexController.greeting() == "hello"
	}
}
