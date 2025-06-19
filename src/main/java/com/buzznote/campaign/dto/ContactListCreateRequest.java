package com.buzznote.campaign.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ContactListCreateRequest {
    @NotBlank
    String name;
}
