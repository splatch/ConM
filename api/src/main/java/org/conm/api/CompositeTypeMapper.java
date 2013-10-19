package org.conm.api;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;

public interface CompositeTypeMapper<T> {

    CompositeType getType() throws OpenDataException;

    CompositeData create(T value) throws OpenDataException;

}
