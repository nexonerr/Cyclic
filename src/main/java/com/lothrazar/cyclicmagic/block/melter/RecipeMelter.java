/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (C) 2014-2018 Sam Bassett (aka Lothrazar)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.lothrazar.cyclicmagic.block.melter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.lothrazar.cyclicmagic.util.Const;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeMelter extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

  @GameRegistry.ObjectHolder(Const.MODRES + "crystallized_amber")
  public static final Item amber = null;
  public static ArrayList<RecipeMelter> recipes = new ArrayList<RecipeMelter>();
  private NonNullList<ItemStack> recipeInput = NonNullList.withSize(TileMelter.RECIPE_SIZE, ItemStack.EMPTY);// new ItemStack[4];
  private Fluid fluidResult = null;
  private int fluidSize;
  private int size = 0;


  public RecipeMelter(ItemStack[] in, String fluidName, int w) {
    this.setFluidResult(FluidRegistry.getFluid(fluidName));
    if (in.length > TileMelter.RECIPE_SIZE || in.length == 0) {
      throw new IllegalArgumentException("Input array must be length 4 or less");
    }
    //how many do we have 
    for (ItemStack itemStack : in) {
      if (itemStack != null && itemStack.isEmpty() == false) {
        recipeInput.set(size, itemStack);
        size++;
      }
    }
    this.fluidSize = w;
    this.setRegistryName(new ResourceLocation(Const.MODID, "melter_" + UUID.randomUUID().toString() + fluidName));
  }

  public int getSize() {
    return size;
  }

  @Override
  public boolean matches(InventoryCrafting inv, World worldIn) {
    this.sanityCheckInput();
    int countFull = 0;
    for (int i = 0; i < inv.getSizeInventory(); i++) {
      if (inv.getStackInSlot(i).isEmpty() == false) {
        countFull++;
      }
    }
    if (countFull != this.size) {
      //      ModCyclic.logger.info("hydrate recipe shortcut " + countNonEmpty + "_" + size);
      return false;
    }
    boolean match0 = recipeSlotMatches(inv.getStackInSlot(0), recipeInput.get(0));
    boolean match1 = recipeSlotMatches(inv.getStackInSlot(1), recipeInput.get(1));
    boolean match2 = recipeSlotMatches(inv.getStackInSlot(2), recipeInput.get(2));
    boolean match3 = recipeSlotMatches(inv.getStackInSlot(3), recipeInput.get(3));
    boolean all = match0 && match1 && match2 && match3;
    //    if (all) {
    //      ModCyclic.logger.info("MATCH" + this.getRecipeOutput() + this.size + "___" + countFull);
    //    }
    return all;
  }

  /**
   * Clean out errors/bad data. Example: Oak sapling that has metadata zero gets converted to 32767
   */
  private void sanityCheckInput() {
    for (int i = 0; i < recipeInput.size(); i++) {
      ItemStack s = recipeInput.get(i);
      if (s.isEmpty()) {
        continue;
      }
      if (s.getMetadata() == 32767) {
        ItemStack snew = new ItemStack(s.getItem(), 1, 0);
        snew.setTagCompound(s.getTagCompound());
        recipeInput.set(i, snew);
      }
    }
  }

  public static boolean recipeSlotMatches(ItemStack sInvo, ItemStack sRecipe) {
    if (sInvo.isEmpty() != sRecipe.isEmpty()) {
      return false;//empty matching empty
    }
    //if item matches, then we are fine. check ore dict as well after that if item doesnt match 
    return sInvo.getCount() >= sRecipe.getCount() &&
        (sInvo.isItemEqual(sRecipe)
            || OreDictionary.itemMatches(sInvo, sRecipe, false));
  }

  public boolean tryPayCost(IInventory invoSource, FluidTank tank, boolean keepOneMinimum) {
    if (tank.getFluidAmount() < this.getFluidSize()) {
      return false;//not enough fluid, so stop now
    }
    //if minimum is 2, then the recipe slots always stay locked with at least 1 in each spot
    //otherwise its allowed to drain empty
    int minimum = (keepOneMinimum) ? 2 : 1;
    //TODO: merge/codeshare between shaped and shapeless!
    //  int inputStackToPay = -1, inputCountToPay = -1;
    //first test before we try to pay
    for (int i = 0; i < recipeInput.size(); i++) {
      if (recipeInput.get(i).isEmpty()) {
        continue; //pay zero
      }
      if (invoSource.getStackInSlot(i).getCount() < recipeInput.get(i).getCount() + (minimum - 1)) {
        return false;//at least one of the stacks cannot pay
      }
    }
    //now actually pay, since they all can
    for (int i = 0; i < recipeInput.size(); i++) {
      if (recipeInput.get(i).isEmpty()) {
        continue; //pay zero
      }
      invoSource.decrStackSize(i, recipeInput.get(i).getCount());
    }
    //    }
    //pay fluid last. same for shaped and shapeless
    tank.drain(this.getFluidSize(), true);
    return true;
  }

  @Override
  public ItemStack getCraftingResult(InventoryCrafting inv) {
    return ItemStack.EMPTY;
  }

  @Override
  public boolean canFit(int width, int height) {
    return (width <= 2 && height <= 2);
  }

  @Override
  public ItemStack getRecipeOutput() {
    return ItemStack.EMPTY;
  }

  public List<ItemStack> getRecipeInput() {
    return recipeInput;
  }

  public int getFluidSize() {
    return fluidSize;
  }

  public void setFluidCost(int fluidCost) {
    this.fluidSize = fluidCost;
  }

  // static init
  public static void initAllRecipes() {
    addRecipe(new RecipeMelter(
        new ItemStack[] { new ItemStack(Blocks.ICE), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY },
        "water", 1000));
    addRecipe(new RecipeMelter(
        new ItemStack[] { new ItemStack(Blocks.ICE), new ItemStack(Blocks.ICE), new ItemStack(Blocks.ICE), new ItemStack(Blocks.ICE) },
        "water", 4000));
  }

  public static void addRecipe(RecipeMelter rec) {
    recipes.add(rec);
  }

  public Fluid getFluidResult() {
    return fluidResult;
  }

  public void setFluidResult(Fluid fluidResult) {
    this.fluidResult = fluidResult;
  }
}
