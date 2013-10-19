package org.conm.core;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;

import org.conm.api.CompositeTypeMapper;

public class ToStringCompositeTypeMapper implements CompositeTypeMapper<Object> {

    private final CompositeType type;

    public ToStringCompositeTypeMapper() throws OpenDataException {
        String[] itemNames = new String[] {"element"};
        String[] itemDescriptions = new String[] {"Element converted by toString instance method"};
        OpenType<?>[] itemTypes = new OpenType[] {SimpleType.STRING};
        type = new CompositeType("element", "Type describing type", itemNames, itemDescriptions, itemTypes);
    }

    @Override
    public CompositeType getType() {
        return type;
    }

    @Override
    public CompositeData create(Object value) throws OpenDataException {
        return new CompositeDataSupport(type, new String[] {"element"}, new String[] {value.toString()});
    }

}
