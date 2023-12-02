package ldn.cs.common;

import ldn.cs.fusion.pojo.convey.ConveyVo;
import ldn.cs.fusion.pojo.convey.GoodsVo;
import ldn.cs.fusion.pojo.production.CategoryVo;
import ldn.cs.fusion.pojo.production.ProductionVo;
import ldn.cs.fusion.pojo.sale.ExportVo;
import ldn.cs.fusion.pojo.sale.YearSaleVo;
import ldn.cs.fusion.pojo.wealth.PayVo;

import java.util.*;

public class DataSource {

    static Random random = new Random();
    static Map<String, List<Integer>> graphProductionMap = new HashMap<>();
    static Map<String, Integer> graphCategoryMap = new HashMap<>();
    static Map<String, List<Integer>> graphMonthSaleMap = new HashMap<>();
    static Map<String, Integer> graphYearSaleMap = new HashMap<>();
    static Map<String, List<Integer>> graphExport = new HashMap<>();
    static Map<String, List<Integer>> graphPay = new HashMap<>();
    static Map<String, List<Integer>> graphConveyTimes = new HashMap<>();
    static Map<String, List<Integer>> graphConveyCost = new HashMap<>();
    static Map<String, List<Integer>> graphGoodsInventory = new HashMap<>();
    static Map<String, List<Integer>> graphGoodsTransport = new HashMap<>();

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

    public static void graphYearSale(List<YearSaleVo> vos) {
        List<String> yearList = Arrays.asList("2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023");
        for (YearSaleVo vo : vos) {
            vo.setYear(yearList);
            Map<String, List<Integer>> monthData = new HashMap<>();
            for (String year : yearList) {
                monthData.put(year, fillMonthSale(vo.getGroupName(), year));
            }
            vo.setMonthData(monthData);
            List<Integer> yearData = new ArrayList<>();
            for (String year : yearList) {
                yearData.add(fillYearSale(vo.getGroupName(), year));
            }
            vo.setYearData(yearData);
        }
    }

    private static List<Integer> fillMonthSale(String groupName, String key) {
        if (graphMonthSaleMap.containsKey(groupName + key)) {
            return graphMonthSaleMap.get(groupName + key);
        } else {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                int value = random.nextInt(250);
                sum += value;
                list.add(value);
            }
            graphMonthSaleMap.put(groupName + key, list);
            graphYearSaleMap.put(groupName + key, sum);
        }
        return graphMonthSaleMap.get(groupName + key);
    }

    private static Integer fillYearSale(String groupName, String key) {
        if (graphYearSaleMap.containsKey(groupName + key)) {
            return graphYearSaleMap.get(groupName + key);
        } else {
            graphYearSaleMap.put(groupName + key, random.nextInt(2500) + 500);
        }
        return graphYearSaleMap.get(groupName + key);
    }

    public static void graphExport(List<ExportVo> vos) {
        List<String> countries = Arrays.asList("沙特阿拉伯", "埃及", "英国", "美国", "智利", "俄罗斯", "法国", "马来西亚");
        for (ExportVo vo : vos) {
            vo.setCountries(countries);
            List<ExportVo.Data> data = new ArrayList<>();
            for (int i = 2016; i < 2024; i++) {
                data.add(new ExportVo.Data(Integer.toString(i), "类型1", fillExport(vo.getGroupName(), i + "类型1")));
                data.add(new ExportVo.Data(Integer.toString(i), "类型2", fillExport(vo.getGroupName(), i + "类型2")));
            }
            vo.setData(data);
        }
    }

    private static List<Integer> fillExport(String groupName, String key) {
        if (graphExport.containsKey(groupName + key)) {
            return graphExport.get(groupName + key);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                list.add(random.nextInt(90000) + 10000);
            }
            graphExport.put(groupName + key, list);
        }
        return graphExport.get(groupName + key);
    }

    public static void graphPay(List<PayVo> vos) {
        List<String> item = Arrays.asList("研发支出", "人员工资支出", "运输支出", "仓储支出", "物料支出", "设备支出", "生产支出", "总收入");
        for (PayVo vo : vos) {
            vo.setItem(item);
            List<PayVo.Data> data = new ArrayList<>();
            for (int i = 2016; i < 2024; i++) {
                data.add(new PayVo.Data(Integer.toString(i), fillPay(vo.getGroupName(), Integer.toString(i))));
            }
            vo.setData(data);
        }
    }

    private static List<Integer> fillPay(String groupName, String key) {
        if (graphPay.containsKey(groupName + key)) {
            return graphPay.get(groupName + key);
        } else {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                int value = random.nextInt(100000) + 10000;
                sum += value;
                list.add(value);
            }
            list.add(sum);
            graphPay.put(groupName + key, list);
        }
        return graphPay.get(groupName + key);
    }

    public static void graphConvey(List<ConveyVo> vos) {
        List<String> item = Arrays.asList("铁路", "公路", "航空", "水路", "管道");
        for (ConveyVo vo : vos) {
            vo.setItem(item);
            vo.setTimes(fillConveyTimes(vo.getGroupName()));
            vo.setCost(fillConveyCost(vo.getGroupName()));
        }
    }

    private static List<Integer> fillConveyTimes(String groupName) {
        if (graphConveyTimes.containsKey(groupName)) {
            return graphConveyTimes.get(groupName);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add(random.nextInt(500) + 1000);
            }
            graphConveyTimes.put(groupName, list);
        }
        return graphConveyTimes.get(groupName);
    }

    private static List<Integer> fillConveyCost(String groupName) {
        if (graphConveyCost.containsKey(groupName)) {
            return graphConveyCost.get(groupName);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add(random.nextInt(70) + 50);
            }
            graphConveyCost.put(groupName, list);
        }
        return graphConveyCost.get(groupName);
    }

    public static void graphGoods(List<GoodsVo> vos) {
        List<String> item = Arrays.asList("冷却系统", "燃油电喷及点火系统", "曲柄连杆机构", "进排气系统", "发动机");
        for (GoodsVo vo : vos) {
            vo.setItem(item);
            vo.setInventory(fillGoodsInventory(vo.getGroupName()));
            vo.setTransport(fillGoodsTransport(vo.getGroupName()));
        }

    }

    private static List<Integer> fillGoodsInventory(String groupName) {
        if (graphGoodsInventory.containsKey(groupName)) {
            return graphGoodsInventory.get(groupName);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add(random.nextInt(70) + 10);
            }
            graphGoodsInventory.put(groupName, list);
        }
        return graphGoodsInventory.get(groupName);
    }

    private static List<Integer> fillGoodsTransport(String groupName) {
        if (graphGoodsTransport.containsKey(groupName)) {
            return graphGoodsTransport.get(groupName);
        } else {
            List<Integer> list = new ArrayList<>();
            List<Integer> inventory = graphGoodsInventory.get(groupName);
            for (int i = 0; i < 5; i++) {
                list.add(random.nextInt(inventory.get(i) - 10));
            }
            graphGoodsTransport.put(groupName, list);
        }
        return graphGoodsTransport.get(groupName);
    }
}
