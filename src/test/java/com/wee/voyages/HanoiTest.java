package com.wee.voyages;

import com.wee.mis.Hanoi;
import org.junit.Test;
import org.junit.Assert;

/**问题 有3个柱子(1，2，3)和3个不同尺寸的圆盘(A，B，C)。
 * 在每个圆盘的中心有个孔，所以圆盘可以堆叠在柱子上。
 * 最初，全部3个圆盘都堆在柱子1上：最大的圆盘C在底部，最小的圆盘A在顶部。
 * 要求把所有圆盘都移到柱子3上，每次只许移动一个，而且只能先搬动柱子顶部的圆盘，
 * 还不许把尺寸较大的圆盘堆放在尺寸较小的圆盘上
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-3
 * Time: 20:41:28
 * To change this template use File | Settings | File Templates.
 */
public class HanoiTest {

    @Test
    public void hanoiTest(){
      Assert.assertEquals(7,new Hanoi(3).steps());
      
    }
}

