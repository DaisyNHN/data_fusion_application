package ldn.cs.fusion.controller;

import ldn.cs.common.BaseResponse;
import ldn.cs.common.DataSource;
import ldn.cs.fusion.dao.CompanyDao;
import ldn.cs.fusion.dao.CompanyGroupDao;
import ldn.cs.fusion.pojo.company.Company;
import ldn.cs.fusion.pojo.company.CompanyGroup;
import ldn.cs.fusion.pojo.production.*;
import ldn.cs.fusion.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/data/element/production")
public class ProductionController {
    @Autowired
    ProductionService productionService;
    @Resource
    CompanyGroupDao companyGroupDao;
    @Resource
    CompanyDao companyDao;

    /**
     * 数据融合 -- 生产链查询
     *
     * @param statement 查询条件
     * @param types     条件类型 ：1为按企业查询，2为按更新时间查询
     * @param limit     单页限制 这里要让前台记得乘以limit 要不然会重复
     * @param offset    偏移量
     * @return 生产链报表数据ProductionInfo
     */
    @GetMapping("/fusion/query")
    public ProductionInfo query(String statement, int types, int limit, int offset) {
        return productionService.getProductionInfos(statement, types, limit, offset);
    }

    /**
     * 数据感知 -- 企业整体产量趋势可视化查询
     *
     * @param time 查询条件年份
     * @return key-企业，value-对象列表
     */
    @GetMapping("/perception/trend/query")
    public Map<String, List<Trend>> getTrendInfos(int time) {
        return productionService.getTrendInfos(time);
    }

    /**
     * 数据感知 -- 企业产量分布可视化查询
     *
     * @param time        查询条件时间戳（毫秒级）
     * @param granularity 条件类型：1-按年份 2-按季度 3-按月份
     * @return key-企业，value-对象列表
     */
    @GetMapping("/perception/yield/query")
    public Map<String, List<Yield>> getYieldInfos(long time, int granularity) {
        return productionService.getYieldInfos(time, granularity);
    }

    /**
     * 数据感知 -- 企业产地分布可视化查询
     *
     * @param time        查询条件时间戳（毫秒级）
     * @param granularity 条件类型：1-按年份 2-按季度 3-按月份
     * @return key-企业，value-对象列表
     */
    @GetMapping("/perception/birth/query")
    public Map<String, List<Birth>> getBirthInfos(long time, int granularity) {
        return productionService.getBirthInfos(time, granularity);
    }

    @GetMapping("/graph/production")
    public BaseResponse<List<ProductionVo>> graphProduction() {
        List<ProductionVo> vos = new ArrayList<>();
        List<CompanyGroup> companyGroups = companyGroupDao.selectAll();
        for (CompanyGroup companyGroup : companyGroups) {
            vos.add(new ProductionVo(companyGroup.getName(),
                    companyDao.getByGroupId(companyGroup.getId()).stream().map(Company::getName).collect(Collectors.toList()),
                    null));
        }
        DataSource.graphProduction(vos);
        return BaseResponse.success(vos);
    }

    @GetMapping("/graph/category")
    public BaseResponse<List<CategoryVo>> graphCategory() {
        List<CategoryVo> vos = new ArrayList<>();
        List<CompanyGroup> companyGroups = companyGroupDao.selectAll();
        for (CompanyGroup companyGroup : companyGroups) {
           vos.add(new CategoryVo(companyGroup.getName(),null));
        }
        DataSource.graphCategory(vos);
        return BaseResponse.success(vos);
    }

}

