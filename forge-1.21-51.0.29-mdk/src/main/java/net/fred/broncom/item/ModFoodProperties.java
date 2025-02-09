package net.fred.broncom.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    static MobEffectInstance mobEffectInstance1 = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400);
   public static final FoodProperties SMOOD = new FoodProperties.Builder().nutrition(7).saturationModifier(5.0f)
           .effect(mobEffectInstance1, 0.5f).build();
}
