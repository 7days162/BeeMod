package kr.honeybee.beemod.init;

import kr.honeybee.beemod.blocks.BlockClearGlass;
import net.minecraft.block.Block;

public class BeeBlocks {
    public static Block CLEAR_GLASS;

    static {
        // BLOCK
        CLEAR_GLASS = new BlockClearGlass();
    }

    public static void register() {
        registerBlock(CLEAR_GLASS);
    }

    private static void registerBlock(Block block) {
        RegistrationHandler.Blocks.add(block);
    }
}
