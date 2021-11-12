package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;
import kr.honeybee.beemod.gui.GUIBankBook;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class ItemBankBook extends BeeItem {
    public ItemBankBook() {
        super("bankbook", "bankbook");

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World worldIn, @Nonnull EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        if(!worldIn.isRemote) {
            GUIBankBook gui = new GUIBankBook(new ArrayList<>());
            Minecraft.getMinecraft().displayGuiScreen(gui);
        }

        return ActionResult.newResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
