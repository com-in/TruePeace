package com.peacefulmobs.core.features;

public class MobSpawningManager {
    // 缓存是否启用和平模式怪物生成
    private static boolean peacefulMobSpawningEnabled = false;
    
    public static void enablePeacefulMobSpawning() {
        // 核心逻辑：确保和平模式下怪物能够生成
        // 具体实现由各加载器负责
        if (!peacefulMobSpawningEnabled) {
            peacefulMobSpawningEnabled = true;
            System.out.println("Enabled mob spawning in peaceful mode");
        }
    }
    
    public static boolean shouldSpawnMob(String mobType) {
        // 检查是否应该生成特定类型的怪物
        // 可以添加额外的生成条件
        return peacefulMobSpawningEnabled;
    }
    
    public static boolean isPeacefulMobSpawningEnabled() {
        return peacefulMobSpawningEnabled;
    }
}
