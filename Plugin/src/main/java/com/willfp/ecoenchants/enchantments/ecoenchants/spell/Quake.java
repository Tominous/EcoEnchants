package com.willfp.ecoenchants.enchantments.ecoenchants.spell;

import com.willfp.ecoenchants.enchantments.EcoEnchants;
import com.willfp.ecoenchants.enchantments.itemtypes.Spell;
import com.willfp.ecoenchants.integrations.antigrief.AntigriefManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collection;

public class Quake extends Spell {
    public Quake() {
        super("quake");
    }

    @Override
    public void onUse(Player player, int level, PlayerInteractEvent event) {
        int radius = this.getConfig().getInt(EcoEnchants.CONFIG_LOCATION + "radius-per-level") * level;
        int damage = this.getConfig().getInt(EcoEnchants.CONFIG_LOCATION + "damage-per-level") * level;


        Collection<Entity> entities = player.getWorld().getNearbyEntities(player.getLocation(), radius, 3, radius);

        for (Entity entity : entities) {
            if (entity.equals(player))
                continue;
            if(!(entity instanceof LivingEntity)) continue;
            if(!AntigriefManager.canInjure(player, (LivingEntity) entity))
                continue;

            ((LivingEntity) entity).damage(damage);
        }
    }
}
