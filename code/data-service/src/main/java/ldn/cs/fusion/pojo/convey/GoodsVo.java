package ldn.cs.fusion.pojo.convey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Daisy
 * @date 2023-11-29 17:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {

    private String groupName;

    private List<String> item;

    private List<Integer> transport;

    private List<Integer> inventory;
}
