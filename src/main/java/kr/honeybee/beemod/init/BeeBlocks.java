package kr.honeybee.beemod.init;

import kr.honeybee.beemod.blocks.BlockATM;
import kr.honeybee.beemod.blocks.BlockClearGlass;
import net.minecraft.block.Block;

public class BeeBlocks {
    public static Block ATM;
    public static Block CLEAR_GLASS;

    static {
        // BLOCK
        CLEAR_GLASS = new BlockClearGlass();
        ATM = new BlockATM();
    }

    public static void register() {
        registerBlock(CLEAR_GLASS);
        registerBlock(ATM);
    }

    private static void registerBlock(Block block) {
        RegistrationHandler.Blocks.add(block);
    }
}
