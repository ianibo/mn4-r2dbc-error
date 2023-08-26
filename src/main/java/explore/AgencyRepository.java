package explore;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import org.reactivestreams.Publisher;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;


public interface AgencyRepository {

        @NonNull
        @SingleResult
        Publisher<? extends Agency> save(@Valid @NotNull @NonNull Agency agency);

        @NonNull
        @SingleResult
        Publisher<Agency> persist(@Valid @NotNull @NonNull Agency agency);

        @NonNull
        @SingleResult
        Publisher<? extends Agency> update(@Valid @NotNull @NonNull Agency agency);

        @NonNull
        @SingleResult
        Publisher<Agency> findById(@NonNull UUID id);

        @NonNull
        @SingleResult
        Publisher<Boolean> existsById(@NonNull UUID id);

        @NonNull
        @SingleResult
        Publisher<Page<Agency>> findAll(Pageable page);
        @NonNull
        Publisher<Agency> findOneByCode(String code);

        Publisher<Agency> findAll();

        Publisher<Void> delete(UUID id);

        Publisher<Void> deleteByCode(@NotNull String code);

}
