package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public abstract class ItemUmbrella extends BeeItem {
    public ItemUmbrella(String registryName, String translationKey) {
        super(registryName, translationKey);

        setMaxStackSize(1);
        setCreativeTab(BeeMod.beeItemTab);
    }

    public static class WhiteUmbrella extends ItemUmbrella {
        public WhiteUmbrella() {
            super("white_umbrella", "white_umbrella");
        }
    }

    public static class YellowUmbrella extends ItemUmbrella {
        public YellowUmbrella() {
            super("yellow_umbrella", "yellow_umbrella");
        }
    }

    public static class WhiteYellowUmbrella extends ItemUmbrella {
        public WhiteYellowUmbrella() {
            super("white_yellow_umbrella", "white_yellow_umbrella");
        }
    }
}
