package net.jokes.core.event;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import net.jokes.core.application.InfrastructureException;
import net.jokes.core.domain.VoteValue;
import org.apache.commons.lang.CharEncoding;
import org.axonframework.serializer.SerializedObject;
import org.axonframework.serializer.SerializedType;
import org.axonframework.serializer.SimpleSerializedObject;
import org.axonframework.serializer.SimpleSerializedType;
import org.axonframework.upcasting.Upcaster;
import org.axonframework.upcasting.UpcastingContext;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class VoteAddedEventUpcaster implements Upcaster<Object> {
    @Override
    public boolean canUpcast(SerializedType serializedType) {
        return serializedType.getName().equals(VoteAddedEvent.class.getName());
    }

    @Override
    public Class<Object> expectedRepresentationType() {
        return Object.class;
    }

    @Override
    public List<SerializedObject<?>> upcast(SerializedObject<Object> intermediateRepresentation, List<SerializedType> expectedTypes, UpcastingContext context) {
        try {
            VoteAddedEvent sourceEvent = (VoteAddedEvent) new XStream().fromXML(new InputStreamReader(new ByteArrayInputStream((byte[]) intermediateRepresentation.getData()), CharEncoding.ISO_8859_1));
            String targetXML = new XStream().toXML(new VoteAddedEventV2(sourceEvent.getUserName(), sourceEvent.getText(), VoteValue.INDIFFERENT));

            return Lists.<SerializedObject<?>>newArrayList(new SimpleSerializedObject<byte[]>(targetXML.getBytes(CharEncoding.ISO_8859_1), byte[].class, expectedTypes.get(0)));
        } catch (UnsupportedEncodingException e) {
            throw new InfrastructureException("Failed to upcast event of type " + intermediateRepresentation.getType(), e);
        }
    }

    @Override
    public List<SerializedType> upcast(SerializedType serializedType) {
        return Lists.<SerializedType>newArrayList(new SimpleSerializedType(VoteAddedEventV2.class.getName(), serializedType.getRevision()));
    }
}
