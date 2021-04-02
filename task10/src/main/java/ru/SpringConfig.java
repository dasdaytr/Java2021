package ru;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru") // поиск Component
@PropertySource("classpath:musicPlayer.properties") //даем понять где находится наш properties файл
public class SpringConfig {
}
