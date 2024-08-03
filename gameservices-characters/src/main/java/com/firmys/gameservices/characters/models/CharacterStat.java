package com.firmys.gameservices.characters.models;

import com.firmys.gameservices.common.CommonEntity;
import java.util.UUID;
import lombok.Builder;
import lombok.With;
import org.springframework.data.annotation.Id;

@With
@Builder(toBuilder = true)
public record CharacterStat(
    @Id UUID uuid, UUID statId, String name, Long statValue, String description)
    implements CommonEntity {}
