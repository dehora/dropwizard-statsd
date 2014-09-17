## dropwizard-statsd

A Dropwizard 0.7 ReporterFactory that wraps [jjagged/metrics-statsd](https://github.com/jjagged/metrics-statsd). 

### Adding a reporter

Add a `statsd` metrics reporter to your configuration.yaml file -


```yaml
metrics:
  reporters:
    - type: statsd
      host: localhost
      port: 8125
      prefix: my.prefix
```


### Add a dependency

The distribution is hosted on [bintray](https://bintray.com/dehora/maven/dropwizard-statsd/view). To use the reporter,add jcenter to your dependencies. For example in Gradle - 

```groovy
repositories {
 jcenter()
}

dependencies { 
 compile 'net.dehora.dropwizard:dropwizard-statsd:0.0.0'
}  
```

and maven 

```xml
<project>
  ...
  <repositories>
    <repository>
      <id>jcenter</id>
      <url>http://jcenter.bintray.com</url>
    </repository>
  </repositories>
  ...
  <dependencies>
    <dependency>
        <groupId>net.dehora.dropwizard</groupId>
        <artifactId>dropwizard-statsd</artifactId>
        <version>0.0.0</version>
    </dependency>
  </dependencies>
  ...
</project>  
```

  
