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
package org.conm.api;

import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.TabularData;


public interface ThreadMXBean {

    String getName();

    long getId();

    String getState();

    boolean isAlive();

    boolean isInterrupted();

    boolean isDaemon();

    void interrupt();

    TabularData getStackTrace() throws OpenDataException;

    void start();

}
