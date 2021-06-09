package ro.ubb.exam.web.converter;

import ro.ubb.exam.core.model.BaseEntity;
import ro.ubb.exam.web.dto.BaseDto;

/**
 * Created by C64.
 */

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}

