package net.nayan135.mymod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class AutoSmeltPickaxeItem extends Item {
    // Higher mining speed when not using ability
    private static final float BASE_DESTROY_SPEED = 10.0F;
    // Slightly lower mining speed when using ability
    private static final float ABILITY_DESTROY_SPEED = 8.0F;

    private boolean isAbilityActive = false;

    public AutoSmeltPickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        // Check if the block is mineable with a pickaxe
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return isAbilityActive ? ABILITY_DESTROY_SPEED : BASE_DESTROY_SPEED;
        }
        return 1.0F;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if (!level.isClientSide() && player != null) {
            // Simple auto-smelt logic for demonstration
            boolean abilityUsed = false;

            // Example: Convert iron ore to iron ingot
            if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) {
                level.destroyBlock(blockPos, false);
                Block.popResource(level, blockPos, new net.minecraft.world.item.ItemStack(net.minecraft.world.item.Items.IRON_INGOT, 1));
                player.sendSystemMessage(Component.literal("Auto-smelted iron ore!"));
                abilityUsed = true;
            }

            // Example: Convert gold ore to gold ingot
            else if (block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE) {
                level.destroyBlock(blockPos, false);
                Block.popResource(level, blockPos, new net.minecraft.world.item.ItemStack(net.minecraft.world.item.Items.GOLD_INGOT, 1));
                player.sendSystemMessage(Component.literal("Auto-smelted gold ore!"));
                abilityUsed = true;
            }

            // Example: Convert copper ore to copper ingot
            else if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) {
                level.destroyBlock(blockPos, false);
                Block.popResource(level, blockPos, new net.minecraft.world.item.ItemStack(net.minecraft.world.item.Items.COPPER_INGOT, 1));
                player.sendSystemMessage(Component.literal("Auto-smelted copper ore!"));
                abilityUsed = true;
            }

            // Set ability active state when used
            if (abilityUsed) {
                isAbilityActive = true;
                player.sendSystemMessage(Component.literal("Auto-smelt ability activated!"));
                return InteractionResult.SUCCESS;
            } else {

                if (isAbilityActive) {
                    isAbilityActive = false;
                    player.sendSystemMessage(Component.literal("Auto-smelt ability deactivated!"));
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }
}
