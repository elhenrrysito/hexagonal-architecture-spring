package com.henrry.personaslicencias.infrastructure.configuration;

import com.henrry.personaslicencias.domain.ports.api.LicenseServicePort;
import com.henrry.personaslicencias.domain.ports.api.PersonServicePort;
import com.henrry.personaslicencias.domain.ports.spi.LicensePersistencePort;
import com.henrry.personaslicencias.domain.ports.spi.PersonPersistencePort;
import com.henrry.personaslicencias.domain.services.LicenseServiceImpl;
import com.henrry.personaslicencias.domain.services.PersonServiceImpl;
import com.henrry.personaslicencias.infrastructure.adapters.LicenseJpaAdapter;
import com.henrry.personaslicencias.infrastructure.adapters.PersonJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    // PERSON
    @Bean
    public PersonPersistencePort personPersistence() {
        return new PersonJpaAdapter();
    }

    @Bean
    public PersonServicePort bookService() {
        return new PersonServiceImpl(personPersistence());
    }

    // LICENSE

    @Bean
    public LicensePersistencePort licensePersistence() {
        return new LicenseJpaAdapter();
    }

    @Bean
    public LicenseServicePort licenseService() {
        return new LicenseServiceImpl(licensePersistence());
    }
}
