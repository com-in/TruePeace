package com.peacefulmobs.core.features;

import java.util.HashSet;
import java.util.Set;

public class AchievementManager {
    public static final String TRAITOR_ACHIEVEMENT_ID = "traitor";
    public static final String TRAITOR_ACHIEVEMENT_NAME = "叛徒";
    public static final String TRAITOR_ACHIEVEMENT_DESCRIPTION = "攻击了和平的怪物";
    
    // 缓存已授予叛徒成就的玩家
    private static final Set<Object> TRAITOR_ACHIEVEMENT_PLAYERS = new HashSet<>();
    
    public static void registerAchievements() {
        // 注册成就
        System.out.println("Registered achievements");
    }
    
    public static void grantTraitorAchievement(Object player, boolean isPeacefulMode) {
        // 授予玩家"叛徒"成就，只有在和平模式下才会授予
        // 具体实现由各加载器负责
        if (player != null && isPeacefulMode && !TRAITOR_ACHIEVEMENT_PLAYERS.contains(player)) {
            TRAITOR_ACHIEVEMENT_PLAYERS.add(player);
            System.out.println("Granted traitor achievement to player in peaceful mode");
        }
    }
    
    public static boolean hasTraitorAchievement(Object player) {
        // 检查玩家是否已经拥有"叛徒"成就
        // 具体实现由各加载器负责
        return TRAITOR_ACHIEVEMENT_PLAYERS.contains(player);
    }
    
    public static void clearPlayerAchievements(Object player) {
        // 清除玩家的成就（用于玩家离开服务器时）
        if (player != null) {
            TRAITOR_ACHIEVEMENT_PLAYERS.remove(player);
        }
    }
}
