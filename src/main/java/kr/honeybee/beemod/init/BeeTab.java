package kr.honeybee.beemod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BeeTab extends CreativeTabs {
    public BeeTab() {
        super("BeeTab");
    }

    @Override
    public ItemStack createIcon() {
        return Items.DIAMOND.getDefaultInstance();
    }
}
