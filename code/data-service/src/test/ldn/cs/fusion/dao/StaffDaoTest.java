package ldn.cs.fusion.dao;

import ldn.cs.fusion.BaseTest;
import ldn.cs.fusion.pojo.staff.Person;
import ldn.cs.fusion.pojo.staff.Position;
import ldn.cs.fusion.pojo.staff.Skill;
import ldn.cs.fusion.pojo.staff.Staff;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StaffDaoTest extends BaseTest {
    @Autowired
    private StaffDao staffDao;

    @Test
    public void addStaffInfos() {
        Staff staff = new Staff();
        staff.setCategories(1);
        staff.setCorporation("test");
        staff.setPosition(1);
        staff.setSkill("测试");
        staff.setEventTime(20231112001L);
        staff.setUpdateTime(202307172250L);
        List<Staff> staffs = new ArrayList<>();
        staffs.add(staff);

        int count = staffDao.addStaffInfos(staffs);
        Assert.assertEquals(1, count);
        System.out.println(staffDao.getStaffInfos("test",1,5,0));
    }

    @Test
    public void addPersonInfos() {
        Person person = new Person();
        person.setCorporation("test");
        person.setCategories(1);
        person.setEventTime(1690185315000L);
        List<Person> persons = new ArrayList<>();
        persons.add(person);

        int count = staffDao.addPersonInfos(persons);
        Assert.assertEquals(1, count);
    }

    @Test
    public void addPositionInfos() {
        Position position = new Position();
        position.setCorporation("test");
        position.setPosition(1);
        position.setEventTime(1690185315000L);
        List<Position> positions = new ArrayList<>();
        positions.add(position);

        int count = staffDao.addPositionInfos(positions);
        Assert.assertEquals(1, count);
    }

    @Test
    public void addSkillInfos() {
        Skill skill = new Skill();
        skill.setCorporation("test");
        skill.setSkill("测试");
        skill.setEventTime(1690185315000L);
        List<Skill> skills = new ArrayList<>();
        skills.add(skill);

        int count = staffDao.addSkillInfos(skills);
        Assert.assertEquals(1, count);
    }

    @Test
    public void getStaffInfos() {
        System.out.println(staffDao.getStaffInfos("",1,5,0));
        System.out.println(staffDao.getStaffInfos("比亚迪",1,5,0));
        System.out.println(staffDao.getStaffInfos("202012121212",2,5,0));
    }

    @Test
    public void getTotalStaff() {
        int count1 = staffDao.getTotalStaff("比亚迪", 1);
        System.out.println(count1);
        int count2 = staffDao.getTotalStaff("202307172250", 2);
        System.out.println(count2);
    }

    @Test
    public void getPositionInfos() {
        List<Position> positions = staffDao.getPositionInfos(1,2);
        Map<String, List<Position>> collect = positions.stream().collect(Collectors.groupingBy(Position::getCorporation));
        System.out.println("");
    }

    @Test
    public void getPersonInfos() {
        List<Person> persons = staffDao.getPersonInfos(1,2);
        Map<String, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(Person::getCorporation));
        System.out.println("");
    }

    @Test
    public void getSkillInfos() {
        List<Skill> skills = staffDao.getSkillInfos(1,2);
        Map<String, List<Skill>> collect = skills.stream().collect(Collectors.groupingBy(Skill::getCorporation));
        System.out.println("");
    }
}