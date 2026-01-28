package com.peacefulmobs.core.features;

public class MobAggressionManager {
    // 缓存是否禁用怪物仇恨
    private static boolean mobAggressionDisabled = false;
    
    public static void disableMobAggression() {
        // 核心逻辑：禁用怪物对玩家的仇恨
        // 具体实现由各加载器负责
        if (!mobAggressionDisabled) {
            mobAggressionDisabled = true;
            System.out.println("Disabled mob aggression towards players");
        }
    }
    
    public static boolean shouldAttackPlayer(Object mob, Object player) {
        // 检查怪物是否应该攻击玩家
        // 在和平模式下，返回false
        return !mobAggressionDisabled;
    }
    
    public static void handleMobTargeting(Object mob, Object target) {
        // 处理怪物的目标选择
        // 如果目标是玩家，取消攻击
        if (mobAggressionDisabled && target != null && target.getClass().getSimpleName().equals("Player")) {
            System.out.println("Handling mob targeting - canceling attack on player");
        }
    }
    
    public static boolean isMobAggressionDisabled() {
        return mobAggressionDisabled;
    }
}
