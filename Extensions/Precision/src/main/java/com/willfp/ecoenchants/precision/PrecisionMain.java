package com.willfp.ecoenchants.precision;

import com.willfp.ecoenchants.EcoEnchantsPlugin;
import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.extensions.Extension;
import org.bukkit.Bukkit;

public class PrecisionMain extends Extension {
    public static final EcoEnchant PRECISION = new Precision();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(PRECISION, EcoEnchantsPlugin.getInstance());
    }

    @Override
    public void onDisable() {

    }
}
