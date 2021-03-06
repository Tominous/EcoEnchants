package com.willfp.ecoenchants.enchantments.ecoenchants.normal;

import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import com.willfp.ecoenchants.util.VectorUtils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;
public class Grapple extends EcoEnchant {
    public Grapple() {
        super(
                "grapple", EnchantmentType.NORMAL
        );
    }

    // START OF LISTENERS


    @Override
    public void onMeleeAttack(LivingEntity attacker, LivingEntity victim, int level, EntityDamageByEntityEvent event) {
        double baseMultiplier = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "velocity-multiplier");
        Vector vector = attacker.getLocation().toVector().clone().subtract(victim.getLocation().toVector()).normalize().multiply(level * baseMultiplier);

        if(VectorUtils.isFinite(vector)) {
            victim.setVelocity(vector);
        }
    }
}
