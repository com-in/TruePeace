package com.peacefulmobs.fabric;

import com.peacefulmobs.core.features.TradingSystemManager;

public class TradingSystemListener {
    public static void handleEntityInteract(Object player, Object world, Object hand, Object entity, Object hitResult) {
        // 检查玩家是否右键点击了怪物
        if (entity != null) {
            String mobType = entity.getClass().getSimpleName().toLowerCase();
            
            // 检查是否是可交易的怪物
            if (TradingSystemManager.getMobFavorite(mobType) != null && !TradingSystemManager.getMobFavorite(mobType).isEmpty()) {
                // 打开交易界面
                System.out.println("Opening trade interface for " + mobType);
                // 这里可以实现交易界面的打开逻辑
            }
        }
    }
    
    // 可以添加其他与交易系统相关的方法
}
