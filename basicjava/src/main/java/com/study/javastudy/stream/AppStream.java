package com.study.javastudy.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppStream {

    /**
     * 父子菜单
     */
    @Test
    public void test01(){
        List<Menu> menus = Arrays.asList(
                new Menu("1","0","菜单1",0),
                new Menu("2","0","菜单2",0),
                new Menu("3","0","菜单3",1),
                new Menu("4","1","子菜单1",0),
                new Menu("5","1","子菜单2",0),
                new Menu("6","2","子菜单3",0),
                new Menu("7","2","子菜单4",0),
                new Menu("8","2","子菜单5",0),
                new Menu("9","2","子菜单6",0),
                new Menu("10","4","子子菜单1",1),
                new Menu("11","4","子子菜单2",0),
                new Menu("12","3","子菜单7",0),
                new Menu("13","3","子菜单8",0)
                );

//        List<Menu> collect1 = menus.stream().peek(e -> e.setId(e.getId() + "_AA")).collect(Collectors.toList());
//        System.out.println(collect1);

        List<Menu> collect = menus.stream()
                .filter(e -> "0".equals(e.getPid()))
                .map(e -> {
                    e.setChild(getChild(e,menus));
                    return e;
                })
                .sorted(Comparator.comparingInt(Menu::getSort))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect, SerializerFeature.WRITE_MAP_NULL_FEATURES));


    }

    private List<Menu> getChild(Menu root,List<Menu> allMenu){
        List<Menu> collect = allMenu.stream()
                .filter(e -> root.getId().equals(e.getPid()))
                .peek(
                    e->e.setChild(getChild(e,allMenu))
                )
                .collect(Collectors.toList());
        return collect;
    }

}

@Data
class Menu{
    private String id;
    private String pid;
    private String name;
    private int sort;
    public Menu(String id, String pid, String name, int sort){
        this.id = id;
        this.pid= pid;
        this.name = name;
        this.sort= sort;
    }
    private List<Menu> child;
}
