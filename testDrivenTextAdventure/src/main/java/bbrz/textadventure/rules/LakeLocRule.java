package bbrz.textadventure.rules;

public class LakeLocRule implements Rule {

    @Override
    public boolean canHandle(MapRuleMark prevLocation) {
        return prevLocation == MapRuleMark.LAKE;
    }

    @Override
    public boolean isInRules(MapRuleMark prevLocation, MapRuleMark randomLocation) {
        return prevLocation != randomLocation && (
                        randomLocation == MapRuleMark.WOODS ||
                            randomLocation == MapRuleMark.MEADOW ||
                                randomLocation == MapRuleMark.EDGE_OF_THE_SWAMP
                );
    }
}
