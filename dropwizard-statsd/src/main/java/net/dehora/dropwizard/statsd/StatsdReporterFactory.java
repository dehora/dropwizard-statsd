package net.dehora.dropwizard.statsd;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.github.jjagged.metrics.reporting.StatsDReporter;
import com.github.jjagged.metrics.reporting.statsd.StatsD;
import com.google.common.collect.Lists;
import io.dropwizard.metrics.BaseReporterFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;

@JsonTypeName("statsd")
public class StatsdReporterFactory extends BaseReporterFactory {

    private static final Logger logger = LoggerFactory.getLogger(StatsdReporterFactory.class);

    @JsonProperty
    @NotEmpty
    private String host = "localhost";

    @JsonProperty
    @Range(min = 0, max = 49151)
    private int port = 8125;

    @JsonProperty
    @NotNull
    private String prefix = "";

    @JsonProperty
    @NotNull
    private List<String> tags = Lists.newArrayList();

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public ScheduledReporter build(MetricRegistry registry) {
        final StatsD statsd = new StatsD(getHost(), getPort());
        final StatsDReporter reporter = StatsDReporter
            .forRegistry(registry)
            .prefixedWith(getPrefix())
            .withTags(getTags().toArray(new String[getTags().size()]))
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS).filter(getFilter())
            .build(statsd);
        logger.info("registering StatsdReporterFactory "+reporter);
        return reporter;
    }
}
