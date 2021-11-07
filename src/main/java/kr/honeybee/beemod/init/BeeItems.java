package kr.honeybee.beemod.init;

import kr.honeybee.beemod.items.ItemBankBook;
import kr.honeybee.beemod.items.ItemBlockBase;
import kr.honeybee.beemod.items.ItemCard;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BeeItems {
    public static Item CARD, BANKBOOK;

    public static ItemBlock CLEAR_GLASS_ITEM;


    static {
        CARD = new ItemCard();
        BANKBOOK = new ItemBankBook();

        // ITEM BLOCK
        CLEAR_GLASS_ITEM = new ItemBlockBase(BeeBlocks.CLEAR_GLASS);
    }

    public static void register() {
        registerItem(CARD);
        registerItem(BANKBOOK);

        registerItem(CLEAR_GLASS_ITEM);
    }

    private static void registerItem(Item item) {
        RegistrationHandler.Items.add(item);
    }
}
