package io.silverware.microservices.demo.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import io.silverware.microservices.demo.util.ProjectProps;

public class PriorityChoiceRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer://foo?period=2000").routeId("priority-choice-route").streamCaching()
				.setBody().simple("3")
				.bean("microserviceBean", "randomNumeric")
				.choice()
					.when().simple("${body} > 500")
						.log(LoggingLevel.INFO, "priority.choice", "sending to high priority queue: ${body}")
						.to("mqtt:outHi?publishTopicName=high/message/basic&" + ProjectProps.getMqttEndpointParams())
					.otherwise()
						.log(LoggingLevel.INFO, "priority.choice", "sending to low priority queue: ${body}")
						.to("mqtt:outLo?publishTopicName=low/message/basic&" + ProjectProps.getMqttEndpointParams())
				.end();
	}
}
