package it.braincenter.dto;

import lombok.Builder;


@Builder
public record AccountDto (Long id, String username) {}
