package pl.balif.shadows.core.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component("localConversionServices")
@Primary
public class ConversionService extends DefaultConversionService {

    private final Set<Converter> converterSet;

    @Autowired
    public ConversionService(Set<Converter> converterSet) {
        this.converterSet = converterSet;
        ConversionServiceFactory.registerConverters(converterSet, this);
    }

    public <S, T, CS extends Collection<S>, CT extends Collection<T>> CT convert(CS source, Class<T> target) {
        return (CT) this.convert(source, TypeDescriptor.forObject(source),
                TypeDescriptor.collection(source.getClass(), TypeDescriptor.valueOf(target)));
    }


}
