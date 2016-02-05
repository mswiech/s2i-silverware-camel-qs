package io.silverware.microservices.demo.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import io.silverware.microservices.demo.util.ProjectProps;

public class LowPriorityRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("mqtt:inLo?subscribeTopicName=low/message/basic&" + ProjectProps.getMqttEndpointParams())
				.routeId("low-priority-route").streamCaching()
				.log(LoggingLevel.INFO, "priority.low", "received in low priority queue: ${body}");
	}
}
