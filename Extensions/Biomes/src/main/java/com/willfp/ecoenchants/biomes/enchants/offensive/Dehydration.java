package com.willfp.ecoenchants.biomes.enchants.offensive;

import com.willfp.ecoenchants.biomes.BiomesEnchantment;
import org.bukkit.block.Biome;

import java.util.Arrays;

public class Dehydration extends BiomesEnchantment {
    public Dehydration() {
        super("dehydration", EnchantmentType.NORMAL);
    }

    @Override
    public boolean isValid(Biome biome) {
        return Arrays.stream(new String[]{"desert", "badlands", "savanna"}).anyMatch(biome.name().toLowerCase()::contains);
    }
}
