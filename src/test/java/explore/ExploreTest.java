package explore;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import explore.*;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;


@MicronautTest(transactional = false)
class ExploreTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    AgencyRepository agencyRepository;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());

        Agency a = Agency.builder()
                .id(java.util.UUID.randomUUID())
                .code("aaa")
                .name("aaa")
                .build();

        Mono.from(agencyRepository.save(a))
                .block();
        
        Mono.from(agencyRepository.findAll())
                .block();
    }

}
