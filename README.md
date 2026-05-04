### MINING GAME TEST

- This game is a Java Swing playground as well as an overall game systems learning experiment.
- There has not been a firm plan for this game, as it has simply been something that gets attention at random.

##  THE GOAL RIGHT NOW

- The current goal is to clean up the old code, identify my weak spots, and refine my Java skills.
- Along with that, I am identifying the core loop, and defining the game for a firmer foundation to build on.

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
# (Req level) Item Name -> required resources, Quality range (sometimes variable, sometimes flat)
- (1) Crude Sharpening Stone -> 5 Rocks, 1;
- (5) Rock Hammer -> 2 Rocks, 1-10;
- (5) Bronze Ingot -> 2 Copper + 2 Tin, 5;
- (5) Bronze Pickaxe -> 3 Bronze Ingots, 5-25;
- (7) Bronze Sword -> 5 Bronze Ingots, 5-25;
- (10) Bronze Axe -> 5 Bronze Ingots, 5-25;