package kr.honeybee.beemod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BeeBlockTab extends CreativeTabs {
    public BeeBlockTab() {
        super("BeeBlockTab");
    }

    @Override
    public ItemStack createIcon() {
        return Items.BRICK.getDefaultInstance();
    }
}
