package fr.zunf1x.carmod.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.List;

public class ItemJerrican extends Item {

    public float contain = 30;

    public ItemJerrican() {
        super();

        setRegistryName("jerrican");
        setUnlocalizedName("jerrican");
        setCreativeTab(CreativeTabs.MISC);
        setMaxDamage((int) contain);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        contain -= 0.2F;

        if (contain <= 0) {
            ItemStack stack = player.getHeldItem(hand);

            stack.setCount(0);
        }

        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        tooltip.add("Contains " + (int) contain + "L" + " of 30L");
    }
}
