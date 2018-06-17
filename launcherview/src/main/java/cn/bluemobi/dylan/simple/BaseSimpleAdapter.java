package cn.bluemobi.dylan.simple;

import cn.bluemobi.dylan.adapter.BaseMainAdapter;
import cn.bluemobi.dylan.adapter.BaseSubAdapter;

/**
 * Version 1.0
 * <p>
 * Date: 16/6/7 12:00
 * Author: linglongxin24@163.com
 */
public interface BaseSimpleAdapter {
    BaseMainAdapter getMainAdapter();
    BaseSubAdapter getSubAdapter();
    boolean isShareViewPool();
}
