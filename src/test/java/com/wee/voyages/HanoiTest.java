package com.wee.voyages;

import com.wee.mis.Hanoi;
import org.junit.Test;
import org.junit.Assert;

/**���� ��3������(1��2��3)��3����ͬ�ߴ��Բ��(A��B��C)��
 * ��ÿ��Բ�̵������и��ף�����Բ�̿��Զѵ��������ϡ�
 * �����ȫ��3��Բ�̶���������1�ϣ�����Բ��C�ڵײ�����С��Բ��A�ڶ�����
 * Ҫ�������Բ�̶��Ƶ�����3�ϣ�ÿ��ֻ���ƶ�һ��������ֻ���Ȱᶯ���Ӷ�����Բ�̣�
 * ������ѳߴ�ϴ��Բ�̶ѷ��ڳߴ��С��Բ����
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

