package com.peacefulmobs.forge;

import com.peacefulmobs.core.features.TradingSystemManager;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TradingSystemListener {
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        // 检查玩家是否右键点击了怪物
        if (event.getTarget() != null && event.getTarget().isAlive()) {
            String mobType = event.getTarget().getType().getRegistryName().toString().replace("minecraft:", "");
            
            // 检查是否是可交易的怪物
            if (TradingSystemManager.getMobFavorite(mobType) != null && !TradingSystemManager.getMobFavorite(mobType).isEmpty()) {
                // 打开交易界面
                System.out.println("Opening trade interface for " + mobType);
                // 这里可以实现交易界面的打开逻辑
            }
        }
    }
    
    // 可以添加其他与交易系统相关的事件监听器
}
