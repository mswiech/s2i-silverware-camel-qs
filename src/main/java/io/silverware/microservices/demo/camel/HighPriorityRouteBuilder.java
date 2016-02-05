package io.silverware.microservices.demo.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import io.silverware.microservices.demo.util.ProjectProps;

public class HighPriorityRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("mqtt:inHi?subscribeTopicName=high/message/basic&" + ProjectProps.getMqttEndpointParams())
				.routeId("high-priority-route").streamCaching()
				.log(LoggingLevel.INFO, "priority.high", "received in high priority queue: ${body}");
	}
}
