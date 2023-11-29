package ldn.cs.common;

import ldn.cs.fusion.pojo.production.CategoryVo;
import ldn.cs.fusion.pojo.production.ProductionVo;

import java.util.*;

public class DataSource {

    static Random random = new Random();
    static Map<String, List<Integer>> graphProductionMap = new HashMap<>();
    static Map<String, Integer> graphCategoryMap = new HashMap<>();

    public static void graphProduction(List<ProductionVo> vos) {
        for (ProductionVo vo : vos) {
            List<ProductionVo.Data> data = new ArrayList<>();
            data.add(new ProductionVo.Data("乘用车", fillProduction(vo.getGroupName(), "乘用", vo.getCompanyName().size())));
            data.add(new ProductionVo.Data("商用车", fillProduction(vo.getGroupName(), "商用", vo.getCompanyName().size())));
            vo.setSeries(data);
        }
    }

    private static List<Integer> fillProduction(String groupName, String key, int size) {
        if (graphProductionMap.containsKey(groupName + key)) {
            return graphProductionMap.get(groupName + key);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(random.nextInt(20000) + 10000);
            }
            graphProductionMap.put(groupName + key, list);
        }
        return graphProductionMap.get(groupName + key);
    }

    public static void graphCategory(List<CategoryVo> vos) {
        for (CategoryVo vo : vos) {
            List<CategoryVo.Data> data = new ArrayList<>();
            data.add(new CategoryVo.Data("基础型", fillCategory(vo.getGroupName(), "基础型")));
            data.add(new CategoryVo.Data("交叉型", fillCategory(vo.getGroupName(), "交叉型")));
            data.add(new CategoryVo.Data("SUV", fillCategory(vo.getGroupName(), "SUV")));
            data.add(new CategoryVo.Data("MPV", fillCategory(vo.getGroupName(), "MPV")));
            vo.setSeries(data);
        }
    }

    private static Integer fillCategory(String groupName, String key) {
        if (graphCategoryMap.containsKey(groupName + key)) {
            return graphCategoryMap.get(groupName + key);
        } else {
            graphCategoryMap.put(groupName + key, random.nextInt(500) + 500);
        }
        return graphCategoryMap.get(groupName + key);
    }
}
