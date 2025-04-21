package net.nayan135.mymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;

public class BreadItem extends Item {
    public BreadItem(Properties properties) {
        super(properties.food(new FoodProperties.Builder()
                .nutrition(4) // hunger points
                .saturationModifier(0.3f)
                .alwaysEdible()
                .build()));// allows eating even if not hungry

    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        // Call parent logic (handles hunger, etc.)
        ItemStack itemstack = super.finishUsingItem(stack, world, entity);

        // Only apply effects on the server side
        if (!world.isClientSide) {
            entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 1)); // 10 sec, level 2
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1)); // 10 sec, level 2
        }

        return itemstack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
}
