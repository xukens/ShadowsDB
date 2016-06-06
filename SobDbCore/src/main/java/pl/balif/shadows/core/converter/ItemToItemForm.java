package pl.balif.shadows.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.balif.shadows.core.domain.Item;
import pl.balif.shadows.core.dto.form.ItemForm;

/**
 * Created by RudyKot on 2016-05-26.
 */
@Component
public class ItemToItemForm implements Converter<Item, ItemForm> {

    @Override
    public ItemForm convert(Item item) {
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
        return itemForm;
    }
}
