package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBase extends ItemBlock {
    public ItemBlockBase(Block block) {
        super(block);

        assert block.getRegistryName() != null;
        setRegistryName(block.getRegistryName());
        setTranslationKey(block.getTranslationKey());

        setCreativeTab(BeeMod.beeBlockTab);
    }
}
