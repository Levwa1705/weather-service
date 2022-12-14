package com.example.weathermonitoring.converter;

import com.example.weathermonitoring.model.dto.PageDTO;
import com.example.weathermonitoring.utils.PageConverterUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<S, T> implements Converter<S, T>, WeatherFiller<S, T> {

    @Override
    public T createTarget() {
        Class<T> clazz = (Class)
                ((ParameterizedType)
                        getClass()
                                .getGenericSuperclass())
                        .getActualTypeArguments()[1];
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new IllegalStateException(String.format("Не удалось создать экземпляр класса %s, " +
                    "возможно не был задан конструктор без параметров", clazz.getName()), e);
        }
    }


    public List<T> convert(List<S> s) {
        if (CollectionUtils.isEmpty(s)) {
            return Collections.emptyList();
        }
        return s.stream().map(this::convert).collect(Collectors.toList());
    }

    /**
     * Конвертирует пагинированные ответы с Repository
     */
    public PageDTO<T> convert(Page<S> s) {
        List<T> result = convert(s.getContent());
        return PageConverterUtils.convert(s, result);
    }
    /**
     * @param source источник данных
     * @return target цель конвертации
     */
    @Override
    public T convert(S source) {
        T target = createTarget();
        abstractFill(source, target); // Предварительное наполнение (для абстрактных наследников, этого конвертора)
        fill(source, target); // основное наполнение
        return target;
    }

    /**
     * Предварительное наполнение
     */
    public void abstractFill(S source, T target) {
        // здесь мог быть ваш код
    }


}
