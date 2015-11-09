## dropwizard-statsd

A Dropwizard ReporterFactory that wraps [jjagged/metrics-statsd](https://github.com/jjagged/metrics-statsd). 

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

There are 3 releases of this JAR, one that brings in dropwizard:0.7.1, one for dropwizard:0.8.1 and one for dropwizard:0.9.1.  Pick the version of this JAR appropriate to your Dropwizard project:

| dropwizard-statsd version | dropwizard-version |
|---------------------------|--------------------|
| 0.0.0                     | 0.7.1              |
| 0.8.1                     | 0.8.1              |
| 0.9.1                     | 0.9.1              |

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

  
