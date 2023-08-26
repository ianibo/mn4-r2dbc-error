package explore;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import org.reactivestreams.Publisher;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

import java.util.UUID;

import jakarta.transaction.Transactional;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsPageableRepository;
import jakarta.inject.Singleton;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.reactivestreams.Publisher;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@SuppressWarnings("unchecked")
@Singleton
@R2dbcRepository(dialect = Dialect.POSTGRES)
@Transactional
public interface AgencyRepository extends ReactiveStreamsPageableRepository<Agency, UUID> {

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
