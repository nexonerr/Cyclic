package com.lothrazar.cyclicmagic.registry;
import com.lothrazar.cyclicmagic.fluid.BlockFluidExp;
import com.lothrazar.cyclicmagic.fluid.BlockFluidMilk;
import com.lothrazar.cyclicmagic.fluid.BlockFluidPoison;
import com.lothrazar.cyclicmagic.fluid.FluidExp;
import com.lothrazar.cyclicmagic.fluid.FluidMilk;
import com.lothrazar.cyclicmagic.fluid.FluidPoison;
import net.minecraft.init.Items;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class FluidsRegistry {
  public static FluidMilk fluid_milk;
  public static BlockFluidMilk block_milk;
  public static FluidExp fluid_exp;
  public static BlockFluidExp block_exp;
  public static FluidPoison fluid_poison;
  public static BlockFluidPoison block_poison;
  public static void onRegistryEvent() {
    registerMilk();
    registerExp();
    registerPoison();
  }
  private static void registerPoison() {
    fluid_poison = new FluidPoison();
    FluidRegistry.registerFluid(fluid_poison);
    block_poison = new BlockFluidPoison();
    fluid_poison.setBlock(block_poison);
    BlockRegistry.registerBlock(block_poison, "poison", null);
    FluidRegistry.addBucketForFluid(fluid_poison);
  }
  private static void registerMilk() {
    fluid_milk = new FluidMilk();
    FluidRegistry.registerFluid(fluid_milk);
    block_milk = new BlockFluidMilk();
    fluid_milk.setBlock(block_milk);
    BlockRegistry.registerBlock(block_milk, "milk", null);
    FluidRegistry.addBucketForFluid(fluid_milk);
  }
  private static void registerExp() {
    fluid_exp = new FluidExp();
    FluidRegistry.registerFluid(fluid_exp);
    block_exp = new BlockFluidExp();
    fluid_exp.setBlock(block_exp);
    BlockRegistry.registerBlock(block_exp, "xpjuice", null);
    FluidRegistry.addBucketForFluid(fluid_exp);
  }
  public static void addRecipes() {
    RecipeRegistry.addShapelessRecipe(FluidUtil.getFilledBucket(new FluidStack(FluidsRegistry.fluid_poison, Fluid.BUCKET_VOLUME)),
        FluidUtil.getFilledBucket(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME)),
        Items.SPIDER_EYE, Items.POISONOUS_POTATO, Items.SUGAR);
  }
}