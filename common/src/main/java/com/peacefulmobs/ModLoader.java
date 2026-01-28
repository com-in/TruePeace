package com.peacefulmobs;

public interface ModLoader {
    // 注册怪物生成
    void registerMobSpawns();
    
    // 注册事件监听器
    void registerEventListeners();
    
    // 注册交易系统
    void registerTradingSystem();
    
    // 注册成就系统
    void registerAchievements();
}
