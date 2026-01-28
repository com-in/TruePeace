package com.peacefulmobs.core.features;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TradingSystemManager {
    private static final Map<String, String> MOB_FAVORITES = new HashMap<>();
    private static final Map<String, Map<String, Integer>> TRADE_OFFERS = new HashMap<>();
    
    static {
        // 初始化怪物喜好物品
        MOB_FAVORITES.put("zombie", "rotten_flesh");
        MOB_FAVORITES.put("skeleton", "bone");
        MOB_FAVORITES.put("creeper", "gunpowder");
        MOB_FAVORITES.put("spider", "string");
        MOB_FAVORITES.put("enderman", "ender_pearl");
        
        // 初始化交易内容
        // 僵尸的交易
        Map<String, Integer> zombieOffers = new HashMap<>();
        zombieOffers.put("rotten_flesh", 1);
        zombieOffers.put("iron_ingot", 8); // 8个腐肉换1个铁锭
        TRADE_OFFERS.put("zombie", Collections.unmodifiableMap(zombieOffers));
        
        // 骷髅的交易
        Map<String, Integer> skeletonOffers = new HashMap<>();
        skeletonOffers.put("bone", 1);
        skeletonOffers.put("arrow", 4); // 1个骨头换4个箭
        TRADE_OFFERS.put("skeleton", Collections.unmodifiableMap(skeletonOffers));
        
        // 苦力怕的交易
        Map<String, Integer> creeperOffers = new HashMap<>();
        creeperOffers.put("gunpowder", 1);
        creeperOffers.put("tnt", 1); // 1个火药换1个TNT
        TRADE_OFFERS.put("creeper", Collections.unmodifiableMap(creeperOffers));
        
        // 蜘蛛的交易
        Map<String, Integer> spiderOffers = new HashMap<>();
        spiderOffers.put("string", 1);
        spiderOffers.put("web", 1); // 1个线换1个蜘蛛网
        TRADE_OFFERS.put("spider", Collections.unmodifiableMap(spiderOffers));
        
        // 末影人的交易
        Map<String, Integer> endermanOffers = new HashMap<>();
        endermanOffers.put("ender_pearl", 1);
        endermanOffers.put("end_stone", 8); // 1个末影珍珠换8个末地石
        TRADE_OFFERS.put("enderman", Collections.unmodifiableMap(endermanOffers));
    }
    
    public static String getMobFavorite(String mobType) {
        return MOB_FAVORITES.getOrDefault(mobType, "");
    }
    
    public static Map<String, Integer> getTradeOffers(String mobType) {
        Map<String, Integer> offers = TRADE_OFFERS.get(mobType);
        return offers != null ? offers : Collections.emptyMap();
    }
    
    public static boolean canTrade(String mobType, String item, int amount) {
        // 检查是否可以用指定物品和数量进行交易
        String favorite = getMobFavorite(mobType);
        if (!favorite.equals(item)) {
            return false;
        }
        
        Map<String, Integer> offers = TRADE_OFFERS.get(mobType);
        return offers != null && offers.containsKey(item) && amount >= offers.get(item);
    }
    
    public static String getTradeResult(String mobType, String item, int amount) {
        // 获取交易结果
        if (!canTrade(mobType, item, amount)) {
            return "";
        }
        
        Map<String, Integer> offers = TRADE_OFFERS.get(mobType);
        if (offers == null) {
            return "";
        }
        
        String favorite = getMobFavorite(mobType);
        for (Map.Entry<String, Integer> entry : offers.entrySet()) {
            if (!entry.getKey().equals(favorite)) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
