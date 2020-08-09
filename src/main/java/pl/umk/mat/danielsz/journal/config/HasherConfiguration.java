package pl.umk.mat.danielsz.journal.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.LongPasswordStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HasherConfiguration {
    @Bean
    public BCrypt.Hasher hasher(){
        return BCrypt.withDefaults();
    }
}
