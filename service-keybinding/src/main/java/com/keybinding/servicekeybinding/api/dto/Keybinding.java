package com.keybinding.servicekeybinding.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Keybinding {
    private String up;
    private String down;
    private String left;
    private String right;
}
