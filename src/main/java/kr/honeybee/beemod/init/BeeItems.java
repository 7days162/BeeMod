package kr.honeybee.beemod.init;

import kr.honeybee.beemod.items.ItemBankBook;
import kr.honeybee.beemod.items.ItemBlockBase;
import kr.honeybee.beemod.items.ItemCard;
import kr.honeybee.beemod.items.ItemBill;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BeeItems {
    public static Item CARD, BANKBOOK;
    public static Item CHEON, OCHEON, MAN, OMAN;

    public static ItemBlock CLEAR_GLASS_ITEM;
    public static ItemBlock ATM_ITEM;

    static {
        CARD = new ItemCard();
        BANKBOOK = new ItemBankBook();
        CHEON = new ItemBill("cheon");
        OCHEON = new ItemBill("ocheon");
        MAN = new ItemBill("man");
        OMAN = new ItemBill("oman");

        // ITEM BLOCK
        CLEAR_GLASS_ITEM = new ItemBlockBase(BeeBlocks.CLEAR_GLASS);
        ATM_ITEM = new ItemBlockBase(BeeBlocks.ATM);
    }

    public static void register() {
        registerItem(CARD);
        registerItem(BANKBOOK);
        registerItem(CHEON);
        registerItem(OCHEON);
        registerItem(MAN);
        registerItem(OMAN);

        registerItem(CLEAR_GLASS_ITEM);
        registerItem(ATM_ITEM);
    }

    private static void registerItem(Item item) {
        RegistrationHandler.Items.add(item);
    }
}
