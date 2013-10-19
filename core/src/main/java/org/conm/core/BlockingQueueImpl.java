/*
 * Copyright (C) 2013 Code-House, Lukasz Dywicki.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.conm.core;

import java.util.concurrent.BlockingQueue;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import org.conm.api.BlockingQueueMXBean;
import org.conm.api.CompositeTypeMapper;

public class BlockingQueueImpl<T> extends StandardMBean implements BlockingQueueMXBean {

    private final BlockingQueue<T> queue;
    private final CompositeTypeMapper<T> mapper;

    public BlockingQueueImpl(BlockingQueue<T> queue, CompositeTypeMapper<T> mapper) throws NotCompliantMBeanException {
        super(BlockingQueueMXBean.class);
        this.queue = queue;
        this.mapper = mapper;
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public int getRemainingCapacity() {
        return queue.remainingCapacity();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    @SuppressWarnings("unchecked")
    public TabularData browse() throws OpenDataException {
        Object[] array = queue.toArray();

        CompositeType rowType = new CompositeType("element", "Single element in queue", new String[] {"index", "element"}, new String[] {"Element index", "Element"}, new OpenType[] {
            SimpleType.INTEGER, mapper.getType()
        });
        TabularType tabularType = new TabularType("elements", "Elements contained in array", rowType, new String[] {"index"});
        TabularDataSupport dataSupport = new TabularDataSupport(tabularType);

        for (int i = 0; i < array.length; i++) {
            dataSupport.put(new CompositeDataSupport(rowType, new String[] {"index", "element"}, new Object[] {i, mapper.create((T) array[i])}));
        }

        return dataSupport;
    }

}
