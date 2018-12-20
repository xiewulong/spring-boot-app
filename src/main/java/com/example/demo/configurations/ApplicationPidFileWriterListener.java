package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationPidFileWriterListener extends ApplicationPidFileWriter {

  @Value("${spring.pid.stored}")
  private boolean STORED;

  @Override
  public void onApplicationEvent(SpringApplicationEvent event) {
    if(!STORED) return;

    super.onApplicationEvent(event);
  }

}
