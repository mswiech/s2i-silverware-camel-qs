package io.silverware.microservices.demo.util;

public final class ProjectProps {

	private static final String MQTT_USER_KEY = "mqtt.user";
	private static final String MQTT_PASS_KEY = "mqtt.pass";
	private static final String MQTT_HOST_KEY = "mqtt.host";

	private final String mqttUser;
	private final String mqttPass;
	private final String mqttHost;

	private static ProjectProps instance;

	private static ProjectProps getInstance() {
		if (instance == null) {
			instance = new ProjectProps();
		}
		return instance;
	}

	private ProjectProps() {
		mqttUser = System.getProperty(MQTT_USER_KEY, "mqtt");
		mqttPass = System.getProperty(MQTT_PASS_KEY, "mqtt");
		mqttHost = System.getProperty(MQTT_HOST_KEY, "mqtt.example.com:1883");
		System.out.println(mqttUser);
		System.out.println(mqttPass);
		System.out.println(mqttHost);
	}

	public static String getMqttUser() {
		return getInstance().mqttUser;
	}

	public static String getMqttPass() {
		return getInstance().mqttPass;
	}

	public static String getMqttHost() {
		return getInstance().mqttHost;
	}

	public static String getMqttUrl() {
		return "tcp://" + getMqttHost();
	}

	public static String getMqttEndpointParams() {
		return "userName=" + getMqttUser() + "&password=" + getMqttPass() + "&host=" + getMqttUrl();
	}
}
