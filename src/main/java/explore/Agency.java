package explore;

import java.util.UUID;

import jakarta.validation.constraints.Size;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.core.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.ToString;

@Data
@Serdeable
@MappedEntity(value = "agency")
@NoArgsConstructor(onConstructor_ = @Creator())
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
public class Agency {

        @ToString.Include
        @NonNull
        @Id
        @TypeDef( type = DataType.UUID)
        private UUID id;

        @ToString.Include
        @NonNull
        @Size(max = 32)
        private String code;

        @ToString.Include
        @NonNull
        @Size(max = 200)
        private String name;

        @Nullable
        @Size(max = 64)
        private String authProfile;

        @ToString.Include
        @Nullable
        @Size(max = 200)
        private String idpUrl;
}
