package com.lothrazar.cyclicmagic.registry;
import java.util.HashMap;
import java.util.Map;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.ModMain;
import com.lothrazar.cyclicmagic.item.BaseItem;
import com.lothrazar.cyclicmagic.item.ItemAppleEmerald;
import com.lothrazar.cyclicmagic.item.ItemChestSack;
import com.lothrazar.cyclicmagic.item.ItemChestSackEmpty;
import com.lothrazar.cyclicmagic.item.ItemCyclicWand;
import com.lothrazar.cyclicmagic.item.ItemEmeraldArmor;
import com.lothrazar.cyclicmagic.item.ItemEmeraldAxe;
import com.lothrazar.cyclicmagic.item.ItemEmeraldHoe;
import com.lothrazar.cyclicmagic.item.ItemEmeraldPickaxe;
import com.lothrazar.cyclicmagic.item.ItemEmeraldSpade;
import com.lothrazar.cyclicmagic.item.ItemEmeraldSword;
import com.lothrazar.cyclicmagic.item.ItemEnderBook;
import com.lothrazar.cyclicmagic.item.ItemToolPearlReuse;
import com.lothrazar.cyclicmagic.item.ItemFoodCorruptedChorus;
import com.lothrazar.cyclicmagic.item.ItemFoodCrafting;
import com.lothrazar.cyclicmagic.item.ItemFoodHeart;
import com.lothrazar.cyclicmagic.item.ItemFoodHorse;
import com.lothrazar.cyclicmagic.item.ItemFoodInventory;
import com.lothrazar.cyclicmagic.item.ItemInventoryStorage;
import com.lothrazar.cyclicmagic.item.ItemPaperCarbon;
import com.lothrazar.cyclicmagic.item.ItemPotionCustom;
import com.lothrazar.cyclicmagic.item.ItemSleepingBag;
import com.lothrazar.cyclicmagic.item.ItemSproutSeeds;
import com.lothrazar.cyclicmagic.item.ItemToolHarvest;
import com.lothrazar.cyclicmagic.item.ItemToolPush;
import com.lothrazar.cyclicmagic.item.ItemToolSpawnInspect;
import com.lothrazar.cyclicmagic.item.projectile.*;
import com.lothrazar.cyclicmagic.util.Const;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
  public static Map<String, Item> itemMap = new HashMap<String, Item>();
  public static final ItemFoodCorruptedChorus corrupted_chorus = new ItemFoodCorruptedChorus();
  //	public static final ItemToolLaunch corrupted_elytra = new ItemToolLaunch();
  public static final ItemCyclicWand cyclic_wand_build = new ItemCyclicWand();
  public static final ItemPotionCustom potion_viscous = new ItemPotionCustom(false);
  public static final ItemPotionCustom potion_levitation = new ItemPotionCustom(true, MobEffects.LEVITATION, 60 * 3);
  public static final ItemPotionCustom potion_levitation_long = new ItemPotionCustom(true, MobEffects.LUCK, 60 * 8);
  public static final ItemPotionCustom potion_luck = new ItemPotionCustom(true, MobEffects.LUCK, 60 * 3);
  public static final ItemPotionCustom potion_luck_long = new ItemPotionCustom(true, MobEffects.LEVITATION, 60 * 8);
  public static final ItemPotionCustom potion_snow = new ItemPotionCustom(true);
  public static final ItemPotionCustom potion_ender = new ItemPotionCustom(true);
  public static final ItemPotionCustom potion_ender_long = new ItemPotionCustom(true);
  public static final ItemPotionCustom potion_magnet = new ItemPotionCustom(false);
  public static final ItemPotionCustom potion_magnet_long = new ItemPotionCustom(false);
  public static final ItemPotionCustom potion_waterwalk = new ItemPotionCustom(false);
  public static final ItemPotionCustom potion_waterwalk_long = new ItemPotionCustom(false);
  public static final ItemPotionCustom potion_slowfall = new ItemPotionCustom(true);
  public static final ItemPotionCustom potion_slowfall_long = new ItemPotionCustom(true);
  //	public static final ItemPotionCustom potion_glowing = new ItemPotionCustom(MobEffects.GLOWING, 60*3);
  //	public static final ItemPotionCustom potion_glowing_long = new ItemPotionCustom(MobEffects.GLOWING, 60*8);
  public static final ItemPotionCustom potion_resistance = new ItemPotionCustom(true, MobEffects.RESISTANCE, 60 * 3);
  public static final ItemPotionCustom potion_resistance_strong = new ItemPotionCustom(true, MobEffects.RESISTANCE, 90, PotionRegistry.II);
  public static final ItemPotionCustom potion_resistance_long = new ItemPotionCustom(true, MobEffects.RESISTANCE, 60 * 8);
  public static final ItemPotionCustom potion_boost = new ItemPotionCustom(true, MobEffects.HEALTH_BOOST, 60 * 3, PotionRegistry.V);
  public static final ItemPotionCustom potion_boost_long = new ItemPotionCustom(true, MobEffects.HEALTH_BOOST, 60 * 8, PotionRegistry.V);
  public static final ItemPotionCustom potion_haste = new ItemPotionCustom(false, MobEffects.HASTE, 60 * 3);
  public static final ItemPotionCustom potion_haste_strong = new ItemPotionCustom(false, MobEffects.HASTE, 90, PotionRegistry.II);
  public static final ItemPotionCustom potion_haste_long = new ItemPotionCustom(false, MobEffects.HASTE, 60 * 8);
  public static final ItemFoodHeart heart_food = new ItemFoodHeart();
  public static final ItemProjectileTNT ender_tnt_1 = new ItemProjectileTNT(1);
  public static final ItemProjectileTNT ender_tnt_2 = new ItemProjectileTNT(2);
  public static final ItemProjectileTNT ender_tnt_3 = new ItemProjectileTNT(3);
  public static final ItemProjectileTNT ender_tnt_4 = new ItemProjectileTNT(4);
  public static final ItemProjectileTNT ender_tnt_5 = new ItemProjectileTNT(5);
  public static final ItemProjectileTNT ender_tnt_6 = new ItemProjectileTNT(6);
  public static ItemEmeraldArmor emerald_boots;
  public static final Item tool_push = new ItemToolPush();
  public static final ItemAppleEmerald apple_emerald = new ItemAppleEmerald();
  public static final ItemToolHarvest tool_harvest_weeds = new ItemToolHarvest(ItemToolHarvest.HarvestType.WEEDS);
  public static final ItemToolHarvest tool_harvest_crops = new ItemToolHarvest(ItemToolHarvest.HarvestType.CROPS);
  public static final ItemToolHarvest tool_harvest_leaves = new ItemToolHarvest(ItemToolHarvest.HarvestType.LEAVES);
  public static final ItemChestSackEmpty chest_sack_empty = new ItemChestSackEmpty();
  public static final ItemChestSack chest_sack = new ItemChestSack();
  public static final ItemToolSpawnInspect tool_spawn_inspect = new ItemToolSpawnInspect();
  public static final ItemSleepingBag sleeping_mat = new ItemSleepingBag();
  public static final ItemToolPearlReuse ender_pearl_reuse = new ItemToolPearlReuse();
  public static final ItemEnderBook book_ender = new ItemEnderBook();
  public static final ItemProjectileBlaze ender_blaze = new ItemProjectileBlaze()  ;
  public static final ItemProjectileDungeon ender_dungeon = new ItemProjectileDungeon();
  public static final ItemProjectileFishing ender_fishing = new ItemProjectileFishing();
  public static final ItemProjectileWool ender_wool = new ItemProjectileWool()   ;
  public static final ItemProjectileTorch ender_torch = new ItemProjectileTorch()  ;
  public static final ItemProjectileWater ender_water = new ItemProjectileWater()  ;
  public static final ItemProjectileSnow ender_snow = new ItemProjectileSnow()   ;
  public static final ItemProjectileLightning ender_lightning = new ItemProjectileLightning()   ;
  public static final ItemPaperCarbon carbon_paper = new ItemPaperCarbon()   ;
  public static final ItemInventoryStorage storage_bag = new ItemInventoryStorage()   ;
  
  
  public static void construct() {

    addItem(storage_bag, "storage_bag");
    addItem(carbon_paper, "carbon_paper");
    addItem(ender_blaze, "ender_blaze");
    addItem(ender_dungeon, "ender_dungeon");
    addItem(ender_fishing, "ender_fishing");
    addItem(ender_wool  , "ender_wool");
    addItem(ender_torch  , "ender_torch");
    addItem(ender_water , "ender_water");
    addItem(ender_snow  , "ender_snow");
    addItem(ender_lightning, "ender_lightning");
    addItem(book_ender, "book_ender");
    addItem(sleeping_mat, "sleeping_mat");
    addItem(new ItemFoodCrafting(), "crafting_food");
    addItem(new ItemFoodInventory(), "inventory_food");
    addItem(tool_spawn_inspect, "tool_spawn_inspect");
    addItem(ender_pearl_reuse, "ender_pearl_reuse");
    addItem(tool_harvest_weeds, "tool_harvest_weeds");
    addItem(tool_harvest_crops, "tool_harvest_crops");
    addItem(tool_harvest_leaves, "tool_harvest_leaves");
    addItem(tool_push, "tool_push");
    chest_sack.setHidden();
    addItem(chest_sack, "chest_sack");
    addItem(chest_sack_empty, "chest_sack_empty");
    addItem(ender_tnt_1, "ender_tnt_1");
    addItem(ender_tnt_2, "ender_tnt_2");
    addItem(ender_tnt_3, "ender_tnt_3");
    addItem(ender_tnt_4, "ender_tnt_4");
    addItem(ender_tnt_5, "ender_tnt_5");
    addItem(ender_tnt_6, "ender_tnt_6");
    addItem(new ItemFoodHorse(new ItemStack(Items.EMERALD)), "horse_upgrade_type");
    addItem(new ItemFoodHorse(new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage())), "horse_upgrade_variant");
    addItem(new ItemFoodHorse(new ItemStack(Items.DIAMOND)), "horse_upgrade_health");
    addItem(new ItemFoodHorse(new ItemStack(Items.REDSTONE)), "horse_upgrade_speed");
    addItem(new ItemFoodHorse(new ItemStack(Items.ENDER_EYE)), "horse_upgrade_jump");
    addItem(corrupted_chorus, "corrupted_chorus");
    addItem(heart_food, "heart_food");
    addItem(potion_viscous, "potion_viscous");
    addItem(potion_boost, "potion_boost");
    addItem(potion_boost_long, "potion_boost_long");
    addItem(potion_resistance, "potion_resistance");
    addItem(potion_resistance_long, "potion_resistance_long");
    addItem(potion_resistance_strong, "potion_resistance_strong");
    addItem(potion_waterwalk, "potion_waterwalk");
    addItem(potion_waterwalk_long, "potion_waterwalk_long");
    addItem(potion_slowfall, "potion_slowfall");
    addItem(potion_slowfall_long, "potion_slowfall_long");
    addItem(potion_magnet, "potion_magnet");
    addItem(potion_magnet_long, "potion_magnet_long");
    addItem(potion_haste, "potion_haste");
    addItem(potion_haste_long, "potion_haste_long");
    addItem(potion_haste_strong, "potion_haste_strong");
    addItem(potion_ender, "potion_ender");
    addItem(potion_ender_long, "potion_ender_long");
    addItem(potion_luck, "potion_luck");
    addItem(potion_luck_long, "potion_luck_long");
    addItem(potion_levitation, "potion_levitation");
    addItem(potion_levitation_long, "potion_levitation_long");
    addItem(cyclic_wand_build, "cyclic_wand_build");
    addItem(apple_emerald, "apple_emerald");
    addItem(potion_snow,"potion_snow");
  }
  private static Item addItem(Item i, String key) {
    i.setUnlocalizedName(key);
    itemMap.put(key, i);
    return i;
  }
  //	private static boolean emeraldGearEnabled ; 
  public static ToolMaterial TOOL_MATERIAL_EMERALD;
  public static ArmorMaterial ARMOR_MATERIAL_EMERALD;
  public static ItemSproutSeeds sprout_seed;
  public final static Item REPAIR_EMERALD = Items.EMERALD;
  // only because theyre private, with no getters
  //	private static final int		diamondDurability				= 33;
  //private static final int[]	diamondreductionAmounts	= new int[] { 3, 6, 8, 3 };
  public static void syncConfig(Configuration config) {
    //		Property prop;
    Item item;
    for (String key : itemMap.keySet()) {
      item = itemMap.get(key);
      if (item instanceof IHasConfig) {
        ((IHasConfig) item).syncConfig(config);
      }
    }
 
    ItemFoodHorse.syncConfig(config);
  }
  private static void registerRecipes() {
    Item item;
    for (String key : itemMap.keySet()) {
      item = itemMap.get(key);
      if (item instanceof IHasRecipe) {
        ((IHasRecipe) item).addRecipe();
      }
    }

    registerBrewing();
  }
  private static void registerBrewing() {
    ItemStack awkward = BrewingRecipeRegistry.getOutput(new ItemStack(Items.POTIONITEM), new ItemStack(Items.NETHER_WART));
 
    BrewingRecipeRegistry.addRecipe(
        awkward,
        new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()),
        new ItemStack(ItemRegistry.potion_viscous));
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_viscous),
        new ItemStack(Items.CHORUS_FRUIT),
        new ItemStack(ItemRegistry.potion_levitation));
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_levitation),
        new ItemStack(Items.REDSTONE),
        new ItemStack(ItemRegistry.potion_levitation_long));
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_viscous),
        new ItemStack(Items.SLIME_BALL),
        new ItemStack(ItemRegistry.potion_luck));
    addBrewingRecipe(
        ItemRegistry.potion_viscous,
        Items.ENDER_EYE,
        ItemRegistry.potion_ender);
    addBrewingRecipe(
        ItemRegistry.potion_ender,
        Items.REDSTONE,
        ItemRegistry.potion_ender_long);
    addBrewingRecipe(
        ItemRegistry.potion_viscous,
        Items.EMERALD,
        ItemRegistry.potion_haste);
    addBrewingRecipe(
        ItemRegistry.potion_haste,
        Items.REDSTONE,
        ItemRegistry.potion_haste_long);
    addBrewingRecipe(
        ItemRegistry.potion_haste,
        Items.GLOWSTONE_DUST,
        ItemRegistry.potion_haste_strong);
    addBrewingRecipe(
        ItemRegistry.potion_viscous,
        Items.PRISMARINE_CRYSTALS,
        ItemRegistry.potion_waterwalk);
    addBrewingRecipe(
        ItemRegistry.potion_waterwalk,
        Items.REDSTONE,
        ItemRegistry.potion_waterwalk_long);
    addBrewingRecipe(
        ItemRegistry.potion_viscous,
        Items.GOLDEN_APPLE,
        ItemRegistry.potion_boost);
    addBrewingRecipe(
        ItemRegistry.potion_boost,
        Items.REDSTONE,
        ItemRegistry.potion_boost_long);
    addBrewingRecipe(
        ItemRegistry.potion_viscous,
        Items.DIAMOND,
        ItemRegistry.potion_resistance);
    addBrewingRecipe(
        ItemRegistry.potion_resistance,
        Items.REDSTONE,
        ItemRegistry.potion_resistance_long);
    addBrewingRecipe(
        ItemRegistry.potion_resistance,
        Items.GLOWSTONE_DUST,
        ItemRegistry.potion_resistance_strong);
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_viscous),
        new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()),
        new ItemStack(ItemRegistry.potion_magnet));
    addBrewingRecipe(
        ItemRegistry.potion_magnet,
        Items.REDSTONE,
        ItemRegistry.potion_magnet_long);
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_viscous),
        new ItemStack(Items.FISH, 1, ItemFishFood.FishType.CLOWNFISH.getMetadata()),
        new ItemStack(ItemRegistry.potion_slowfall));
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_slowfall),
        new ItemStack(Items.REDSTONE),
        new ItemStack(ItemRegistry.potion_slowfall_long));
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(ItemRegistry.potion_viscous),
        new ItemStack(Blocks.ICE),
        new ItemStack(ItemRegistry.potion_snow));
  }
  private static void addBrewingRecipe(Item input, Item ingredient, Item output) {
    BrewingRecipeRegistry.addRecipe(
        new ItemStack(input),
        new ItemStack(ingredient),
        new ItemStack(output));
  }
  public static void register() {
    registerMaterials();
    // thanks for help:
    // http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-7/custom-tools-swords/
    addItem(new ItemEmeraldSword(), ItemEmeraldSword.name);
    addItem(new ItemEmeraldPickaxe(), ItemEmeraldPickaxe.name);
    addItem(new ItemEmeraldAxe(), ItemEmeraldAxe.name);
    addItem(new ItemEmeraldSpade(), ItemEmeraldSpade.name);
    addItem(new ItemEmeraldHoe(), ItemEmeraldHoe.name);
    addItem(new ItemEmeraldArmor(EntityEquipmentSlot.HEAD), "emerald_helmet");
    addItem(new ItemEmeraldArmor(EntityEquipmentSlot.CHEST), "emerald_chestplate");
    addItem(new ItemEmeraldArmor(EntityEquipmentSlot.LEGS), "emerald_leggings");
    emerald_boots = new ItemEmeraldArmor(EntityEquipmentSlot.FEET);
    addItem(emerald_boots, "emerald_boots");
    //		addItem(new ItemFlintTool(),"flint_tool");
    potion_snow.addEffect(PotionRegistry.snow, 60 * 3, PotionRegistry.I);
    potion_ender.addEffect(PotionRegistry.ender, 60 * 3, PotionRegistry.I);
    potion_magnet.addEffect(PotionRegistry.magnet, 60 * 3, PotionRegistry.I);
    potion_waterwalk.addEffect(PotionRegistry.waterwalk, 60 * 3, PotionRegistry.I);
    potion_slowfall.addEffect(PotionRegistry.slowfall, 60 * 3, PotionRegistry.I);
    potion_ender_long.addEffect(PotionRegistry.ender, 60 * 8, PotionRegistry.I);
    potion_magnet_long.addEffect(PotionRegistry.magnet, 60 * 8, PotionRegistry.I);
    potion_waterwalk_long.addEffect(PotionRegistry.waterwalk, 60 * 8, PotionRegistry.I);
    potion_slowfall_long.addEffect(PotionRegistry.slowfall, 60 * 8, PotionRegistry.I);
    //maybe one day it will be all base items
    Item item;
    for (String key : itemMap.keySet()) {
      item = itemMap.get(key);
      if (item instanceof BaseItem) {
        ((BaseItem) item).register(key);
      }
      else {
        registerItem(item, key);
      }
    }
    registerRecipes();
  }
  //from ArmorMaterial.DIAMOND, second constuctor param
  //used as a ratio for durability
  private static final int maxDamageFactorDiamond = 33;
  private static final String emeraldName = "emerald";
  /*
   * as of 1.9.4 : LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15,
   * SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), CHAIN("chainmail", 15, new
   * int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
   * IRON("iron", 15, new int[]{2, 5, 6, 2}, 9,
   * SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F), GOLD("gold", 7, new int[]{1, 3,
   * 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F), DIAMOND("diamond", 33,
   * new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
   */
  private static void registerMaterials() {
    ARMOR_MATERIAL_EMERALD = EnumHelper.addArmorMaterial(emeraldName, Const.MODRES + emeraldName,
        maxDamageFactorDiamond - 2, //affects DURABILITY 
        new int[] {
            ArmorMaterial.DIAMOND.getDamageReductionAmount(EntityEquipmentSlot.FEET), ArmorMaterial.DIAMOND.getDamageReductionAmount(EntityEquipmentSlot.LEGS), ArmorMaterial.DIAMOND.getDamageReductionAmount(EntityEquipmentSlot.CHEST), ArmorMaterial.DIAMOND.getDamageReductionAmount(EntityEquipmentSlot.HEAD)
        },
        ArmorMaterial.GOLD.getEnchantability(),
        ArmorMaterial.DIAMOND.getSoundEvent(),
        ArmorMaterial.DIAMOND.getToughness() / 2);
    //max uses is durability ex The number of uses this material allows.
    //as of 1.9.4 :  (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
    TOOL_MATERIAL_EMERALD = EnumHelper.addToolMaterial(emeraldName,
        ToolMaterial.DIAMOND.getHarvestLevel(),
        ToolMaterial.DIAMOND.getMaxUses() - 261,
        ToolMaterial.DIAMOND.getEfficiencyOnProperMaterial(),
        ToolMaterial.DIAMOND.getDamageVsEntity() - 0.25F,
        ToolMaterial.GOLD.getEnchantability());
    // EnumHelper.addToolMaterial("emerald", 3, harvestLevel 3 same as diamond
    // 1600,3.5F, 5+25 );
  }
  public static void registerItem(Item item, String name) {
    registerItem(item, name, false);// default is not hidden
  }
  public static void registerItem(Item item, String name, boolean isHidden) {
    //item.setUnlocalizedName(name);
    GameRegistry.register(item, new ResourceLocation(Const.MODID, name));
    if (isHidden == false) {
      item.setCreativeTab(ModMain.TAB);
    }
  }
}
