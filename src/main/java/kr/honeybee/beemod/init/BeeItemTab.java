package kr.honeybee.beemod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BeeItemTab extends CreativeTabs {
    public BeeItemTab() {
        super("BeeItemTab");
    }

    @Override
    public ItemStack createIcon() {
        return Items.DIAMOND.getDefaultInstance();
    }
}
