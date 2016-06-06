package pl.balif.shadows.core.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.balif.shadows.core.converter.ConversionService;
import pl.balif.shadows.core.dto.form.ItemForm;
import pl.balif.shadows.core.repositorie.ItemRepository;
import pl.balif.shadows.core.service.ItemService;

/**
 * Created by RudyKot on 2016-06-06.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ConversionService conversionService) {
        this.itemRepository = itemRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<ItemForm> getItemsList() {
        return conversionService.convertCollection(itemRepository.findAll(), ItemForm.class);
    }
}
