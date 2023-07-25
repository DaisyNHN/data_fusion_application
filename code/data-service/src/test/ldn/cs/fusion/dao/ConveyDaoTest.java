package ldn.cs.fusion.dao;

import ldn.cs.fusion.BaseTest;
import ldn.cs.fusion.pojo.convey.Convey;
import ldn.cs.fusion.pojo.convey.Inventory;
import ldn.cs.fusion.pojo.convey.Traffic;
import ldn.cs.fusion.pojo.staff.Position;
import ldn.cs.fusion.pojo.wealth.Finance;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ConveyDaoTest extends BaseTest {
    @Autowired
    private ConveyDao conveyDao;

    @Test
    public void addConveyInfos() {
        Convey convey = new Convey();
        convey.setCorporation("test");
        convey.setGoods("test");
        convey.setEventTime(20231112001L);
        convey.setUpdateTime(202307172250L);
        List<Convey> conveys = new ArrayList<>();
        conveys.add(convey);

        int count = conveyDao.addConveyInfos(conveys);
        Assert.assertEquals(1, count);
    }

    @Test
    public void addTrafficInfos() {
        Traffic traffic = new Traffic();
        traffic.setCorporation("test");
        traffic.setCost(10000);
        traffic.setEventTime(20231112001L);
        traffic.setUpdateTime(202307172250L);
        List<Traffic> traffics = new ArrayList<>();
        traffics.add(traffic);

        int count = conveyDao.addTrafficInfos(traffics);
        Assert.assertEquals(1, count);
    }

    @Test
    public void addInventoryInfos() {
        Inventory inventory = new Inventory();
        inventory.setCorporation("test");
        inventory.setGoods("服务器");
        inventory.setEventTime(20231112001L);
        inventory.setUpdateTime(202307172250L);
        List<Inventory> inventories = new ArrayList<>();
        inventories.add(inventory);

        int count = conveyDao.addInventoryInfos(inventories);
        Assert.assertEquals(1, count);
    }

    @Test
    public void getConveyInfos() {
        System.out.println(conveyDao.getConveyInfos("",1,2,0));
        System.out.println(conveyDao.getConveyInfos("比亚迪",1,2,0));
        System.out.println(conveyDao.getConveyInfos("202012121212",2,5,0));
    }

    @Test
    public void getTotalConvey() {
        int count1 = conveyDao.getTotalConvey("比亚迪", 1);
        System.out.println(count1);
        int count2 = conveyDao.getTotalConvey("", 2);
        System.out.println(count2);
    }

    @Test
    public void getTrafficInfos() {
        List<Traffic> traffics = conveyDao.getTrafficInfos(2023,1);
        Map<String, List<Traffic>> collect = traffics.stream().collect(Collectors.groupingBy(Traffic::getCorporation));
        System.out.println("");
    }

    @Test
    public void getInventoryInfos() {
        List<Inventory> inventories = conveyDao.getInventoryInfos(2023,1);
        Map<String, List<Inventory>> collect = inventories.stream().collect(Collectors.groupingBy(Inventory::getCorporation));
        System.out.println("");
    }
}