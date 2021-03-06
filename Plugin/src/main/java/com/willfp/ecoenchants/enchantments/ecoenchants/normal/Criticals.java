package com.willfp.ecoenchants.enchantments.ecoenchants.normal;

import com.willfp.ecoenchants.enchantments.EcoEnchant;
import com.willfp.ecoenchants.enchantments.EcoEnchants;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
public class Criticals extends EcoEnchant {
    public Criticals() {
        super(
                "criticals", EnchantmentType.NORMAL
        );
    }

    // START OF LISTENERS


    @Override
    public void onMeleeAttack(LivingEntity attacker, LivingEntity victim, int level, EntityDamageByEntityEvent event) {
        if (!(attacker.getFallDistance() > 0 && !attacker.isOnGround()))
            return;

        double damage = event.getDamage();
        double multiplier = this.getConfig().getDouble(EcoEnchants.CONFIG_LOCATION + "multiplier");
        if(this.getConfig().getBool(EcoEnchants.CONFIG_LOCATION + "use-additive")) {
            damage = damage/1.5;
            double bonus = damage * (multiplier * level);
            damage = damage + bonus + damage/2;
            event.setDamage(damage);
        } else {
            double bonus = 1 + (multiplier * level);
            event.setDamage(damage * bonus);
        }
    }
}
