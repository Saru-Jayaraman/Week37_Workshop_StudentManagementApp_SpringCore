package se.lexicon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ComponentScanConfig.class})
public class ImportConfig {
}
