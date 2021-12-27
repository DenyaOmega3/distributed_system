package com.keybinding.servicekeybinding.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Keybinding {
    private char up;
    private char down;
    private char left;
    private char right;
}
