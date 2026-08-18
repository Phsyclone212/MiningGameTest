package game.skills;

import java.util.Map;

public class CraftingSkill extends Skill{

    private Map<Recipe, Skill> subSkills;

    public CraftingSkill() {
        super("Crafting");
    }

}
