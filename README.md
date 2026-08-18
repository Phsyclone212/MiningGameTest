### MINING GAME TEST

- This game is a Java Swing playground as well as an overall game systems learning experiment.
- There has not been a firm plan for this game, as it has simply been something that gets attention at random.

##  THE GOAL RIGHT NOW

- The current goal is to clean up the old code, identify my weak spots, and refine my Java skills.
- Along with that, I am identifying the core loop, and defining the game for a firmer foundation to build on.
- This game is meant to be HUMAN CODED. Any and all AI use will be for rubber-ducking or large code scans - NO EDITS.

# THE GAME ITSELF

- Players will be able to click on a node to mine a type of rock/ore. After mining, they gain xp and a quantity of ore to use in crafting.
- Leveling up Mining allows for more rock types to be mined. Combinations of ores may create better ingots for crafting.
- Crafting any item will produce resources or gear of varying qualities based on what it's made from and the maker's related-crafted level (I may introduce more skills than simply "Crafting")
- After Crafting an Item (No longer any type of Resource to be used in further crafting) Players put the Items up for sale, and it will sell to NPC's (timer based random selection of an item).
- A finished session should look like a Player fully stocking their shop, selling out, upgrading what they can, and either restarting the loop of stocking their shop, or end.


---
# The core loop
- waiting for input by default (Mining, Crafting, or Checking their Store (future addition))
- Player clicks node -> success/fail based on level and difficulty -> gets ore -> Wait for input.
- Player clicks craft -> menu opens with known/available recipes based on level and current owned resources -> click one -> calculates quality of new item and gives to Player -> list it for sale

# Mineable Ore/Rock List (and req level)
- Rocks (1)
- Copper (5)
- Tin (5)
- Iron (15)
- Silver (20)
- Coal (30)
- Granite (40)
- Gold (40)
- Gemstone Rocks (50)
- Obsidian (70)
- Dragonglass (85)

# Ore Node loop/activity
- Node exists and can be mined by someone with a level  >= reqLevel of it's ore.
- Success is based on (miningLevel/reqLevel)*.1 <!-- temporary formula?? It scales kind of nicely in early levels, but previous nodes hit >=100% chances pretty quickly. Later levels this is bad. -->
- After success, Player will receive ONE ore guaranteed. Respawn timer starts (N ticks).
- Secondary loot table rolls for a GEM_GEODE (starts after Rocks, rarity decreases with higher tier rocks)
- Node will wait N ticks before respawning.

## Crafting options
# (Req level) Item Name -> required resources (Tiered Qualities will now calculate)
- (1) Crude Sharpening Stone -> 5 Rocks;
- (5) Rock Hammer -> 2 Rocks;
- (5) Bronze Ingot -> 2 Copper + 2 Tin;
- (5) Bronze Pickaxe -> 3 Bronze Ingots;
- (7) Bronze Sword -> 5 Bronze Ingots;
- (10) Bronze Axe -> 5 Bronze Ingots;

---
# Crafting Quality & Mastery (design notes - not yet implemented)

## Quality is tiers, not a raw number range
Quality resolves to a discrete named tier rather than a continuous value, since it's meant to be a one-time
determination at craft time for items that get sold off (player doesn't wear/wield crafted gear here).
Discrete tiers also mean crafted items can stack cleanly per-tier (e.g. "3 Good Bronze Pickaxes"), the same
way OreType stacks in Inventory - a tier is just a label, similar in spirit to how OreType works as an enum.

Tiers (low to high): Poor, Fair, Basic, Good, Great, Excellent, Perfect, and a rare God-tier roll above Perfect.

OPEN QUESTION: crafted items stacking "per tier" means an item's identity as an Inventory/HashMap key becomes
(recipe + tier), not just recipe. OreType's enum-singleton trick (identity-based equals/hashCode is safe because
there's only ever one instance) doesn't directly apply here - still need to decide how (recipe, tier) gets a
consistent identity for stacking.

## Mastery curve
As a player's level clears an item's requirement by a wider margin, quality trends toward the top tier, with a
small chance at God-tier once truly mastered. Below the requirement, rolls skew toward failure/poor results.

Rough formula shape being considered:
- if (TargetItemSkill >= TargetItemDifficulty) -> rollMasteryQuality() [guaranteed high tier + rare God-tier chance]
- else -> rollQuality() using something like (OverallCraftingLvl + ResourceQuality) / (TargetItemDifficulty - TargetItemSkill)
  - ResourceQuality = an inherent difficulty value on the resource/OreType itself (like reqLevel already is),
    NOT a rolled/tracked quality on the ore - keeps raw resources simple and stackable as-is.

OPEN QUESTION: ratio-based vs flat-offset scaling for how level maps to tier (mirrors the same open question the
mining success formula already has - see Ore Node loop/activity above). Ratios and flat offsets behave very
differently at low vs high req levels; need to pick one on purpose.

## Per-recipe mastery tracking
Craft more of a specific recipe -> better at that specific recipe, independent of overall Crafting level (e.g.
someone who's crafted 100 swords and 10 axes should craft better swords than axes, even at the same Crafting level).

Modeled as data, not new classes per item: CraftingSkill holds something like a Map<Recipe, SubSkill>, where
SubSkill is a single class (quantity crafted -> ability level) instantiated once per recipe - same shape as
Inventory's HashMap<Item, Integer>, rather than one hand-written subclass per craftable item.

Successful craft is two separate bookkeeping steps that happen to fire together: bump the recipe's SubSkill
progress, AND add the resulting item to inventory/shop stock. Easy to conflate since one event triggers both,
but they answer different questions later ("how good am I at this" vs "what do I have to sell").