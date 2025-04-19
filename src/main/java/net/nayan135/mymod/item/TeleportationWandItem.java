package net.nayan135.mymod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class TeleportationWandItem extends Item {
    public TeleportationWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            // Get where the player is looking
            BlockHitResult hitResult = (BlockHitResult) player.pick(100.0, 1.0F, false);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = hitResult.getBlockPos();

                // Find a safe position to teleport to (on top of the block)
                BlockPos teleportPos = blockPos.above();

                // Check if the position is safe (not inside a block)
                if (level.getBlockState(teleportPos).isAir() && level.getBlockState(teleportPos.above()).isAir()) {
                    // Teleport the player
                    player.teleportTo(teleportPos.getX() + 0.5, teleportPos.getY(), teleportPos.getZ() + 0.5);
                    player.sendSystemMessage(Component.literal("Teleported!"));

                    // Apply cooldown
                    player.getCooldowns().addCooldown(this, 20); // 1 second cooldown
                } else {
                    player.sendSystemMessage(Component.literal("Cannot teleport to that location!"));
                }
            } else {
                player.sendSystemMessage(Component.literal("No valid teleport target!"));
            }
        }

        return InteractionResultHolder.success(itemStack);
    }
}
