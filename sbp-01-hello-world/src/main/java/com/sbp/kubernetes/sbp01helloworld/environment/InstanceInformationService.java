package com.sbp.kubernetes.sbp01helloworld.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;

@Service
public class InstanceInformationService
{
    @Autowired(required = false)
    private MetricsEndpoint metrics;

    private static final String HOST_NAME = "HOSTNAME";

    private static final String DEFAULT_ENV_INSTANCE_GUID = "LOCAL";

    //@Value(${ENVIRONMENT_VARIABLE_NAME:DEFAULT_VALUE})
    @Value(HOST_NAME + ":" + DEFAULT_ENV_INSTANCE_GUID )
    private String hostname;

    public String retrieveInstanceInfo()
    {
        metrics.metric("health", null).getName();

        return hostname.substring(hostname.length() - 5);
    }
}
