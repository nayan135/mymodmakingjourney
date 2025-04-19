package net.nayan135.mymod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class TimeFreezeOrbItem extends Item {
    private static final int FREEZE_RADIUS = 10; // Radius in blocks
    private static final int FREEZE_DURATION = 200; // Duration in

    public TimeFreezeOrbItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {

            AABB boundingBox = new AABB(
                    player.getX() - FREEZE_RADIUS, player.getY() - FREEZE_RADIUS, player.getZ() - FREEZE_RADIUS,
                    player.getX() + FREEZE_RADIUS, player.getY() + FREEZE_RADIUS, player.getZ() + FREEZE_RADIUS
            );

            List<Entity> entities = level.getEntities(player, boundingBox);
            int frozenCount = 0;

            for (Entity entity : entities) {
                if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                    LivingEntity livingEntity = (LivingEntity) entity;

                    // Apply extreme slowness (level 5)
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, FREEZE_DURATION, 5));

                    // Apply mining fatigue to prevent actions
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, FREEZE_DURATION, 5));

                    // If it's a mob, stop its AI temporarily
                    if (entity instanceof Mob) {
                        Mob mob = (Mob) entity;
                        mob.setNoAi(true);

                        // Schedule a task to re-enable AI after the duration
                        level.getServer().tell(new net.minecraft.server.TickTask(level.getServer().getTickCount() + FREEZE_DURATION, () -> {
                            mob.setNoAi(false);
                        }));
                    }

                    frozenCount++;
                }
            }

            // Notify the player
            if (frozenCount > 0) {
                player.sendSystemMessage(Component.literal("Froze " + frozenCount + " entities for " + (FREEZE_DURATION / 20) + " seconds!"));

                // Apply cooldown
                player.getCooldowns().addCooldown(this, 60);

                // Consume the item if not in creative mode
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            } else {
                player.sendSystemMessage(Component.literal("TRY AGAIN! EVERYONE LEFT THE AREAA"));
            }
        }

        return InteractionResultHolder.success(itemStack);
    }
}
